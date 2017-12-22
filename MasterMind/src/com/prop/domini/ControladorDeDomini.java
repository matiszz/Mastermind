package com.prop.domini;

import java.util.ArrayList;

import com.prop.persistencia.*;
import com.prop.presentacio.*;

public class ControladorDeDomini {
    GeneradorJocs generador;
    Ranking ranking;
    Partida partida;
    Jugador jugador;
    Registre reg = null;
    GeneradorJocs gen =  null;
    Joc joc = null;
    ControladorDePersistencia persistencia = null;
    ControladorDePresentacio presentacio = null;

    //Creadora
    public ControladorDeDomini(ControladorDePresentacio ctrl) {
        ranking = new Ranking();
        persistencia = new ControladorDePersistencia();
        presentacio = ctrl;
        reg = new Registre();

    }

    //Setters
    public void setGenerador(GeneradorJocs generador) {
        this.generador = generador;
    }

    public void setrRnking(Ranking ranking) {
        this.ranking = ranking;
    }

    //Getters
    public Ranking getRanking() {
        return this.ranking;
    }

    public GeneradorJocs getGenerador() {
        return this.generador;
    }

    //Casos d'ús
    public boolean registrar(String id) {//Cas d'us registrar usuari, retorna fals si l'id està en us. Altrament registra jugador i l'emmagatzema a la BD

        boolean creat = false; //Si creat = false vol dir que l'id ja esta en us
        jugador = reg.registrar(id);
        if(jugador != null) { //El jugador s'ha creat
            creat = true;
            String[] j = jugador.converteixaString();
            persistencia.emmagatzemaJugador(j);
        }
        return creat;
    }

    public boolean iniciasessio(String alies) {
    		jugador = reg.registrar(alies);
    		if(jugador == null) return false;
    		else return true;
    }
    
    public void generarJoc(int dificultat,boolean codeMaker) { //Genera generador de jocs, el joc i la partida segons la dificultat i el mode
        if(gen == null) {
            switch (dificultat) {
            case 1:
                gen = new GeneradorJocs(20,4,5,codeMaker,dificultat);
            break;
            case 2:
                gen = new GeneradorJocs(15,4,5,codeMaker,dificultat);
            break;
            case 3:
                gen = new GeneradorJocs(10,4,5,codeMaker,dificultat);
            break;
            }
        }
        joc = gen.generaJocDefault();
        partida = joc.crearPartida();
        this.jugarPartida();
    }

    public void emmagatzemaCodi(int[] codi) {
        ArrayList<Integer> c = new ArrayList<Integer>();
        for(int i = 0; i < codi.length;++i) c.add(codi[i]);
        partida.setCodiAmagat(c);
    }

    public void acabaPartida() {
        partida.finalitzarPartida();
        String s[] = partida.converteixaString();
        presentacio.mostraTauler(s);
    }

    public void jugadaCompleta(ArrayList<Integer> codiproposat, ArrayList<Integer> codirespost) {
    		presentacio.jugadaCompleta(codiproposat,codirespost);
    }
    
    public void jugarPartida() { //Converteix la partida al tipus per enviar entre capes i fa que el ctrlpresentacio mostri la vista
        /*
         Comproba que existeix un joc i un generador de partides.
         Crea la partida i l'assigna a joc.
         Inicia la partida segons si es codemaker o codebreaker.
         Inicia el clock
         */
        if(partida.mode == "CodeMaker") {
            Algorisme a = new Algorisme(this);
            a.simulaPartida(partida,jugador);
        }
    }

    public void guardarPartida() { //Converteix la partida en l'estructura per passar entre capes i la envia a la capa de persistencia.
        /*
         Escriu en un fitxer totes les dades de la partida actual.
         Atura el clock
         */
        String[] p = partida.converteixaString();
        partida.clock.aturarRellotge();
        persistencia.emmagatzemaPartida(p,jugador.getIdJugador());
    }

    public void finalitzarPartida() {//Guarda la partida(NO a la BD), actualitza estadistiques jugador i actualitza ranking si cal.
        partida.guardarPartida();
        int res = partida.finalitzarPartida();
        jugador.actualitzar_partides(res,partida.getguanyada());
        int dificultat = generador.getDificultat();
        FilaRanking f = new FilaRanking(res,jugador.getIdJugador());
        boolean afegida = ranking.afegeix_fila(f, dificultat);
        if(afegida) {
            String[][] rank = ranking.converteix_Ranking();
            persistencia.emmagatzemaRanking(rank);
        }
        presentacio.mostraMenuprincipal();
    }

    public Partida converteixPartida(String[] info){ //ULL hi ha parametres que no es tenen en compte
        int i = 0;
        Partida newp = new Partida(Integer.parseInt(info[i]), info[i+1],Boolean.parseBoolean(info[i+2]),Integer.parseInt(info[i+3]),Integer.parseInt(info[i+4]),Integer.parseInt(info[i+10]));
        return newp;
    }

    public void continuarPartida() { //Primer obte totes les partides, se les pasa a la capa de presentació, espera una selecció i reanuda la partida seleccionada
        /*
         Recupera del fitxer les partides guardades del jugador actual,
         */
        //String[][] partides = persistencia.obtePartidesJugador(jugador.getIdJugador());
        //String[] seleccionada = presentacio.mostra_partides_disponibles(partides);
        //partida = converteixpartida(seleccionada);
        this.jugarPartida();
        //S'ha de cridar al controlador de domini per que obtingui les partides no finalitzades del jugador que te com atribut
    }

    private ArrayList<Integer> converteixCodi(int[] codi) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < codi.length;++i) {
            res.add(codi[i]);
        }
        return res;
    }

    private String[] converteixCodi(ArrayList<Integer> codi) {
        String[] res = new String[codi.size()];
        for(int i = 0; i < codi.size();++i)
            res[i]=codi.get(i).toString();
        return res;
    }

    public void ferJugada(int[] codip) { //Nomes te sentit en codebreaker i si juga la persona. Realitza la jugada que li pasen, actualitza el tauler, processa la jugada y retorna el codi respost a la capa de presentacio
        ArrayList<Integer> codiproposat = converteixCodi(codip);
        if(jugador != null && partida != null) {
                int num = partida.getNumJugades(); //Retorna el numero de la jugada
                ArrayList<Integer> solucio = partida.getCodiamagat();
                Jugada j = new Jugada(num,partida,jugador);
                j.setcodiProposat(codiproposat);
                partida.ferJugada(j);
                Algorisme a = new Algorisme(this);
                ArrayList<Integer> codiresp = a.aplica_logica(solucio, codiproposat);
                j.setcodiRespost(codiresp);
                String[] cod = converteixCodi(codiresp);
                presentacio.mostraCodiRespost(cod);
        }
    }

    public String[][] consultarRanking() { //Va a la capa de persistencia y retorna el ranking a la capa de presentacio.
        String[][] rank = persistencia.obteRanking();
        return rank;
    }

    public String[] getIdPartidesGuardades(String alies) {//retorna el id de les partides guardades del jugador amb idjugador=alies
//       return persistencia.getIdPartidesGuardades(alies);
        String[] s = {};
        return s;
    }
    	
}
