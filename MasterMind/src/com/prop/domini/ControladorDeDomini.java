package com.prop.domini;

import java.util.ArrayList;

import com.prop.persistencia.*;

public class ControladorDeDomini {
		GeneradorJocs generador;
		Ranking ranking;
		Partida partida;
		Jugador jugador;
		Registre reg = null;
		GeneradorJocs gen =  null;
		Joc joc = null;
		ControladorDePersistencia ctrladorpersistencia = null;
		//Creadora 
		
		public ControladorDeDomini(GeneradorJocs generador, Ranking ranking) {
			this.generador = generador;
			this.ranking = ranking;
			ctrladorpersistencia = new ControladorDePersistencia();
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
		public void registrar(String id) { //OK
			/*
			Primer comproba si hi ha algun registre, si no hi ha el crea.
			Després registra el jugador i l'emmagatzema a la bd.
			 */
			if(reg == null) 
				reg = new Registre();
			jugador = reg.registrar(id); 
			/*Ha de llançar una excepció si ja existeix un jugador amb mateix id, altrament retorna el jugador creat 
			per poder emmagatemar-lo a la BD.*/
			if(jugador != null) //El jugador es nou
				ctrladorpersistencia.emmagatzema(jugador);
		}
		
		public void generar_joc(boolean codeMaker) {
			/*
			 Comproba que existeixi un generador de jocs, si no existeix el crea.
			 Un cop sabe que existeix un generador de jocs, crea el joc segons el parametre,
			 Que indica si es un joc amb els valor per defecte o bé personalitzats.
			 */
			if(gen == null) {
				gen = new GeneradorJocs(20,4,4,codeMaker,1); //Per defecte dificultat facil
			}
			joc = gen.generaJocDefault();
			joc.crearPartida(); //Aquí falta tractar el mode
		}
		
		
		public void jugar_partida() {
			/*
			 Comrpoba que existeix un joc i un generador de partides.
			 Crea la partida i l'assigna a joc.
			 Inicia la partida segons si es codemaker o codebreaker.
			 Inicia el clock
			 */
			
		}
		
		public void guardar_partida() {
			/*
			 Escriu en un fitxer totes les dades de la partida actual.
			 Atura el clock
			 */
		}
		
		public void finalitzar_partida() {
			/*
			 Un cop s'ha encertat el codi o bé s'han acabat el numero d'intents finalitza la partida,
			 és a dir, calcula la puntuació, comproba si s'ha dactualitzar el ranking, actualitza (si cal),
			 les dades del jugador i:
			 a)torna a iniciar una altra partida amb el mateix joc
			 b)torna a generar un nou joc
			 Atura el clock
			 */
			int dificultat = generador.getDificultat();
			FilaRanking f = new FilaRanking(partida.jugades.size(),jugador.getIdJugador());
			ranking.afegeix_fila(f, dificultat);
		}
		
		public ArrayList<Partida> converteixpartides(String info){
			ArrayList<Partida> p = new ArrayList<Partida>();
			return p;
		}
		
		public void continuar_partida() {
			/*
			 Recupera del fitxer les partides guardades del jugador actual,
			 */
			String partides =ctrladorpersistencia.obtepartidesjugador(jugador.getIdJugador());
			ArrayList<Partida> pendents = converteixpartides(partides);
			
			//S'ha de cridar al controlador de domini per que obtingui les partides no finalitzades del jugador que te com atribut
		}
		
		public void fer_jugada() {
			/*
			 Evalua el codi proposat comparant-lo amb la solució i retorna el resultat segons les regles
			 del joc. (Blanc color i la posició correcte, Negre si color correcte, posició incorrecte, 0 si
			 no hi ha res bé).
			 Anotación: 0 o cualquier otro valor, la idea es señalizar un espacio en blanco
			 */
			
		}
		
		private Ranking converteix_info(String info) { //Cal saber com pasarem la info
			Ranking r = new Ranking();
			return r;
		}
		
		public void consultar_ranking() { //OK
			/* Crida a la funcion de ranking que retorna el ranking actual. */
			if(ranking == null) { //S'ha de cridar al controlador de persistencia per que agafi del arxiu el ranking
				String info = ctrladorpersistencia.obteranking();
				ranking = converteix_info(info);
			}
			for(int i = 1; i <=3;++i)
					ranking.mostra_ranking(i);
		}	
		
		
}
