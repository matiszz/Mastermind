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
		
		public ControladorDeDomini() {
			ranking = new Ranking();
			persistencia = new ControladorDePersistencia();
			presentacio = new ControladorDePresentacio();
			reg = new Registre();
			
		}
		
		//Setters
		public void setgenerador(GeneradorJocs generador) {
			this.generador = generador;
		}
		
		public void setranking(Ranking ranking) {
			this.ranking = ranking;
		}
		
		//Getters
		public Ranking getranking() {
			return this.ranking;
		}
		
		public GeneradorJocs getgenerador() {
			return this.generador;
		}
		
		//Casos d'ús
		public boolean registrar(String id) { //Cas d'us registrar usuari, retorna fals si l'id està en us
			/*
			Després registra el jugador i l'emmagatzema a la bd.
			 */
			boolean creat = false;; //Si creat = false vol dir que l'id ja esta en us
			jugador = reg.registrar(id); 
			/*Ha de llançar una excepció si ja existeix un jugador amb mateix id, altrament retorna el jugador creat 
			per poder emmagatemar-lo a la BD.*/
			if(jugador != null) { //El jugador s'ha creat
				creat = true;
				String[] j = jugador.converteixaString();
				persistencia.emmagatzema_jugador(j);
			}
			return creat;
		}
		
		public void generar_joc(int dificultat,boolean codeMaker) { //Genera generador de jocs, el joc i la partida segons la dificultat i el mode
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
			this.jugar_partida();
		}
		
		public void jugar_partida() { //Converteix la partida al tipus per enviar entre capes i fa que el ctrlpresentacio mostri la vista
			/*
			 Comproba que existeix un joc i un generador de partides.
			 Crea la partida i l'assigna a joc.
			 Inicia la partida segons si es codemaker o codebreaker.
			 Inicia el clock
			 */
			String s[] = partida.converteixaString();
			presentacio.mostra_tauler(s);//Fem que el controlador de presentacio mostri la partida actual
		}
		
		public void guardar_partida() { //Converteix la partida en l'estructura per passar entre capes i la envia a la capa de persistencia.
			/*
			 Escriu en un fitxer totes les dades de la partida actual.
			 Atura el clock
			 */
			String[] p = partida.converteixaString();
			partida.clock.aturarRellotge();
			persistencia.emmagatzema_partida(p,jugador.getIdJugador());
		}
		
		public void finalitzar_partida() {//Guarda la partida(NO a la BD), actualitza estadistiques jugador i actualitza ranking si cal.
			partida.guardarPartida();
			int res = partida.finalitzarPartida();
			jugador.actualitzar_partides(res,partida.getguanyada());
			int dificultat = generador.getDificultat();
			FilaRanking f = new FilaRanking(res,jugador.getIdJugador());
			boolean afegida = ranking.afegeix_fila(f, dificultat);
			if(afegida) {
				String[][] rank = ranking.converteix_Ranking();
				persistencia.emmagatzema_ranking(rank);
			}
			presentacio.mostra_menuprincipal();
		}
		
		public Partida converteixpartida(String[] info){ //ULL hi ha parametres que no es tenen en compte
			int i = 0;
			Partida newp = new Partida(Integer.parseInt(info[i]), info[i+1],Boolean.parseBoolean(info[i+2]),Integer.parseInt(info[i+3]),Integer.parseInt(info[i+4]),Integer.parseInt(info[i+10]));
			return newp;
		}
		
		public void continuar_partida() { //Primer obte totes les partides, se les pasa a la capa de presentació, espera una selecció i reanuda la partida seleccionada
			/*
			 Recupera del fitxer les partides guardades del jugador actual,
			 */
			String[][] partides = persistencia.obtepartidesjugador(jugador.getIdJugador());
			String[] seleccionada = presentacio.mostra_partides_disponibles(partides);
			partida = converteixpartida(seleccionada);
			this.jugar_partida();
			//S'ha de cridar al controlador de domini per que obtingui les partides no finalitzades del jugador que te com atribut
		}
		
		private ArrayList<Integer> converteixcodi(int[] codi) { 
			ArrayList<Integer> res = new ArrayList<Integer>();

			for(int i = 0; i < codi.length;++i) {
				res.add(codi[i]);
			}
			return res;
		}
		
		private String[] converteixcodi(ArrayList<Integer> codi) {
			String[] res = new String[codi.size()];
			for(int i = 0; i < codi.size();++i)
				res[i]=codi.get(i).toString();
			return res;
		}
		
		public void fer_jugada(int[] codip) { //Nomes te sentit en codebreaker i si juga la persona. Realitza la jugada que li pasen, actualitza el tauler, processa la jugada y retorna el codi respost a la capa de presentacio
			ArrayList<Integer> codiproposat = converteixcodi(codip);
			if(jugador != null && partida != null) {
					int num = partida.getNumJugades(); //Retorna el numero de la jugada
					ArrayList<Integer> solucio = partida.getCodiamagat();
					Jugada j = new Jugada(num,partida,jugador);
					j.setcodiProposat(codiproposat);
					partida.ferJugada(j);
					Algorisme a = new Algorisme();
					ArrayList<Integer> codiresp = a.aplica_logica(solucio, codiproposat);
					j.setcodiRespost(codiresp);
					String[] cod = converteixcodi(codiresp);
					presentacio.afegeix_codi_respost(cod);
			}
		}
		
		private Ranking converteix_info(String[] info) { 
			Ranking r = new Ranking();
			for(int j = 1; j < 4; ++j) {//Per cada dificultat
				for(int i = 0; i < info.length;i+=3) {
					FilaRanking fil = new FilaRanking();
					int n = Integer.parseInt(info[i+1]); //Cal convertir a enter
					fil.setintents(n);
					fil.setjugador(info[i+2]);		
					if(j == 1)
						r.r_facil.add(fil);
					else if (j == 2)
						r.r_medio.add(fil);
					else if (j == 3)
						r.r_dificil.add(fil);
				}
			}
			return r;
		}
		
		public String[][] consultar_ranking() { //Va a la capa de persistencia y retorna el ranking a la capa de presentacio.
			String[][] rank = persistencia.obteranking();
			return rank;
		}	
		
		
}
