package com.prop.domini;

import java.util.ArrayList;

import com.prop.persistencia.*;
import com.prop.presentacio.*;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorDeDomini {
	boolean partidaGuanyada = false;
    Ranking ranking;
    Partida partida;
    Jugador jugador;
    Registre reg = null;
    GeneradorJocs gen = null;
    Joc joc = null;
    ControladorDePersistencia persistencia = null;
    ControladorDePresentacio presentacio = null;
    int id;
    
    //Creadora
    public ControladorDeDomini(ControladorDePresentacio ctrl) {
        persistencia = new ControladorDePersistencia();
        presentacio = ctrl;
        reg = new Registre();
        obtenirJugadors();
    }
    
    public void instanciaRanking() {
    	 	ranking = new Ranking(this);
    }
    //Casos d'ús
    public boolean registrar(String id) {//Cas d'us registrar usuari, retorna fals si l'id està en us. Altrament registra jugador i l'emmagatzema a la BD
        
        boolean creat = false; //Si creat = true s'ha creat correctament
        jugador = reg.registrar(id);
        if (jugador != null) { //El jugador s'ha creat
            creat = true;
            ArrayList<String> j = jugador.converteixaString();
            persistencia.emmagatzemaJugador(j);
        }
        return creat;
    }
    
    public boolean iniciasessio(String alies) {
        jugador = reg.getJugador(alies);
        if (jugador == null)
            return false; // El jugador existeix
        else
            return true;  // El jugador no existeix
    }
    
    public Partida generarJoc(int dificultat, boolean codeMaker) { //Genera generador de jocs, el joc i la partida segons la dificultat i el mode
        partidaGuanyada = false;
        switch (dificultat) {
            case 1:
                gen = new GeneradorJocs(12, 4, 5, codeMaker, dificultat);
                break;
            case 2:
                gen = new GeneradorJocs(9, 4, 5, codeMaker, dificultat);
                break;
            case 3:
                gen = new GeneradorJocs(7, 4, 5, codeMaker, dificultat);
                break;
        }
        joc = gen.generaJocDefault();
        ArrayList<String> idUsat = this.obtenirTotIdPartida();
        this.id = this.calculaMaxId(idUsat);
        id++;
        partida = joc.crearPartida(id);
        return partida;
    }

    public void emmagatzemaCodi(int[] codi) {
        ArrayList<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < codi.length; ++i) {
            c.add(codi[i]);
        }
        partida.setCodiAmagat(c);
    }
    
    public void setRandomCodi() {
        ArrayList<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 4; ++i)
            c.add(ThreadLocalRandom.current().nextInt(0, 5));
        
        partida.setCodiAmagat(c);
    }
    
    public void jugadaCompleta(ArrayList<Integer> codiproposat, ArrayList<Integer> codirespost) {
        System.out.println("Jugada completa");
        presentacio.jugadaCompleta(codiproposat, codirespost);
    }

    public void jugarPartida() { //Converteix la partida al tipus per enviar entre capes i fa que el ctrlpresentacio mostri la vista
        /*
         Comproba que existeix un joc i un generador de partides.
         Crea la partida i l'assigna a joc.
         Inicia la partida segons si es codemaker o codebreaker.
         Inicia el clock
         */
        if (partida.mode == "CodeMaker") {
            Algorisme a = new Algorisme(this);
            a.simulaPartida(partida, jugador);
        }
    }

    // Retorna true si la partida està guanyada
    public boolean hasGuanyat() {
    		return partidaGuanyada;
    }
    
    // Retorna true si ha perdut i no pot jugar 
    public boolean hasPerdut() {
    		if((partida.numJugades == partida.numFiles) && !partidaGuanyada) return true;
    		else return false;
    }
    
    // Llegeix dades dels jugadors i les guarda a la classe Registre
    public void obtenirJugadors() {
    	ArrayList<ArrayList<String>> jugs = persistencia.getJugadors();
    	ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    	for (ArrayList<String> j : jugs) {
    		Jugador jTmp = new Jugador(j.get(0), Integer.parseInt(j.get(1)), Integer.parseInt(j.get(2)));
    		jugadors.add(jTmp);
    	}
    	reg.setJugadors(jugadors);
    }
    
    public void guardarPartida() { //Converteix la partida en l'estructura per passar entre capes i la envia a la capa de persistencia.
        /*
         Escriu en un fitxer totes les dades de la partida actual.
         Atura el clock
         */
        ArrayList<String> p = partida.converteixaString();
        partida.clock.aturarRellotge();
        persistencia.emmagatzemaPartida(p, jugador.getIdJugador());
    }

    public void finalitzarPartida() {//Guarda la partida(NO a la BD), actualitza estadistiques jugador i actualitza ranking si cal.
        partida.guardarPartida();
        int res = partida.finalitzarPartida();
        if(partida.mode != "CodeMaker" && partidaGuanyada) {
        		jugador.actualitzar_partides(res, partida.getguanyada());
        		persistencia.actualitzaJugador(jugador.converteixaString());
        		int dificultat = partida.getdificultat();
        		FilaRanking f = new FilaRanking(res, jugador.getIdJugador());
        		boolean afegida = ranking.afegeix_fila(f, dificultat);
        		if (afegida) {
        			ArrayList<String> rank = ranking.converteix_Ranking();
        			persistencia.emmagatzemaRanking(rank);
        		}
        }
    }

    public ArrayList<String> obtenirTotIdPartida(){
    		return persistencia.getIdPartides();
    }
    
    public int calculaMaxId(ArrayList<String> a) {
    		if(a.size() != 0) {
    			int max = Integer.parseInt(a.get(0));
    			for(int i = 1; i < a.size();++i) {
    				String s = a.get(i);
    				int actual = Integer.parseInt(s);
    				if(max < actual) max = actual;
    			}	
    			return max;
    		}
    		return 1;
    }	
    
    public Partida converteixPartida(ArrayList<String> info) { //ULL hi ha parametres que no es tenen en compte
        int i = 1;
        //Creo la partida pasandole idPArtida,mode,finalitzada,numFiles,longCodi,dificultat
        
        Partida newp = new Partida(Integer.parseInt(info.get(i)),info.get(i + 1), Boolean.parseBoolean(info.get(i + 7)), Integer.parseInt(info.get(i + 5)), Integer.parseInt(info.get(i + 6)), Integer.parseInt(info.get(i + 8)));
        i = 10;
        ArrayList<Jugada> ljugades = new ArrayList<Jugada>();
        
        String codis = info.get(i);
        int numJugades = Integer.parseInt(info.get(4));
        int longitudJugada = 2*newp.longCodi;
        
        for(int j = 0; j < numJugades;++j) {//Recorro cadaJugada
        		ArrayList<Integer> codiProposat = new ArrayList<Integer>();
        		ArrayList<Integer> codiRespost = new ArrayList<Integer>();
        		
        		//Creem la jugada que estem tractant 
        		Jugada jugada = new Jugada(j,newp,jugador);
    			int inici = j*longitudJugada;
    			int fin = inici+longitudJugada;
    			int meitat = ((inici+fin)/2);
        		for(int l = inici ; l < fin ;++l) {//Jugada va [j*longitudJugada - j*longitudJugada+longitudJugada)
        			int numero = codis.charAt(l)-'0';
        			if(l < meitat) {//CodiProposat
        				codiProposat.add(numero);
        			}
        			else {//CodiRespost	
        				codiRespost.add(numero);
        			}
        		}
        		//Lleno la jugada
        		jugada.setcodiProposat(codiProposat);
        		jugada.setcodiRespost(codiRespost);
        		jugada.encert = false;
        		ljugades.add(jugada); //Añado la jugada nueva	
        		
        }
        String codiAmagat = info.get(i+1);
        ArrayList<Integer> ca = new ArrayList<Integer>();
        for(int k = 0; k <codiAmagat.length();++k) {
        		ca.add(codiAmagat.charAt(k)-'0');
        }
        newp.setCodiAmagat(ca);
        newp.setJugades(ljugades);
        newp.guanyada=false;
        newp.setNumJugades(numJugades);
        return newp;
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> continuarPartida(String idPartida) { //Primer obte totes les partides, se les pasa a la capa de presentació, espera una selecció i reanuda la partida seleccionada
        /*
         Recupera del fitxer les partides guardades del jugador actual,
         */
    	partidaGuanyada = false;
        ArrayList<String> partides = persistencia.getInfoPartida(idPartida);
        partida = converteixPartida(partides);
        
        ArrayList<ArrayList<ArrayList<Integer>>> tauler = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i < partida.numJugades; ++i) {
            ArrayList<ArrayList<Integer>> fila = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> jugada = new ArrayList<Integer>();
            ArrayList<Integer> resposta = new ArrayList<Integer>();
            jugada = partida.jugades.get(i).codiProposat;
            resposta = partida.jugades.get(i).codiRespost;
            fila.add(jugada);
            fila.add(resposta);
            tauler.add(fila);
        }
        return tauler;
    }

    private ArrayList<Integer> converteixCodi(int[] codi) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < codi.length; ++i) {
            res.add(codi[i]);
        }
        return res;
    }

    private String[] converteixCodi(ArrayList<Integer> codi) {
        String[] res = new String[codi.size()];
        for (int i = 0; i < codi.size(); ++i) {
            res[i] = codi.get(i).toString();
        }
        return res;
    }
    
    public boolean correcte(ArrayList<Integer> a) {
    		boolean correcte = true;
    		for(int i = 0; correcte && i < a.size();++i)
    			if(a.get(i) != 2) correcte = false;
    		return correcte;
    }

    public void ferJugada(int[] codip) { //Nomes te sentit en codebreaker i si juga la persona. Realitza la jugada que li pasen, actualitza el tauler, processa la jugada y retorna el codi respost a la capa de presentacio
        ArrayList<Integer> codiproposat = converteixCodi(codip);
        
        if (jugador != null && partida != null) {
            int num = partida.getNumJugades(); //Retorna el numero de la jugada
            ArrayList<Integer> solucio = partida.getCodiamagat();
            
            Jugada j = new Jugada(num, partida, jugador);
            j.setcodiProposat(codiproposat);
            partida.ferJugada(j);
            
            Algorisme a = new Algorisme(this);
            ArrayList<Integer> codiresp = a.aplica_logica(solucio, codiproposat);
            
            j.setcodiRespost(codiresp);
            partidaGuanyada = correcte(codiresp);
            presentacio.mostraCodiRespost(codiresp);
        }
    }

    public ArrayList< String> consultarRanking() { //Va a la capa de persistencia y retorna el ranking a la capa de presentacio.
        ArrayList< String> rank = persistencia.obteRanking();
        return rank;
    }

    public ArrayList<String> getIdPartidesGuardades(String alies) {//retorna el id de les partides guardades del jugador amb idjugador=alies
        return persistencia.getIdPartidesGuardades(alies);
    }

    // Retorna true si el mode es CodeMaker
    public boolean esCodeMaker() {
        return partida.mode.equals("CodeMaker");
    }
    
    public ArrayList<Integer> getSolucio() {
        return partida.getCodiamagat();
    }
    
    public ArrayList<String> recuperaRanking(){
    		return persistencia.obteRanking();
    }
    
    public int getDificultat() {
        return partida.getdificultat();
    }
    
    public int getDificultatPartida(String idPartida) {
        ArrayList<String> par = persistencia.getInfoPartida(idPartida);
        return Integer.parseInt(par.get(9));
    }
    
    public void CpuVsCpu(int i) {
    	
    	 	Algorisme a = new Algorisme(this);
    	 	if(i%2 == 0) a.cpuVsCpu(partida, true);
    	 	else a.cpuVsCpu(partida,false);
  
    }

    public String getIdPartidaActual() {
        return Integer.toString(partida.getIdPartida());
    }
}