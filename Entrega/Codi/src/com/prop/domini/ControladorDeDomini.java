package com.prop.domini;


public class ControladorDeDomini {
		GeneradorJocs generador;
		Ranking ranking;
		Partida partida;
		Jugador jugador;
		
		//Creadora 
		public ControladorDeDomini(GeneradorJocs generador, Ranking ranking) {
			this.generador = generador;
			this.ranking = ranking;
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
		public void registrar(String id) { 
			/*
			 Primer comproba si hi ha algun registre, si no hi ha crea un registre.
			 Un cop comprobat que hi ha registre es mira si l'id ja existeix, si es així retorna un error,
			 altrament registra el jugador (crea la seva instancia i l'inicialitza) 
			 */
			
		}
		
		public void generar_joc() {
			/*
			 Comproba que existeixi un generador de jocs, si no existeix el crea.
			 Un cop sabe que existeix un generador de jocs, crea el joc segons el parametre,
			 Que indica si es un joc amb els valor per defecte o bé personalitzats.
			 */
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
		
		public void continuar_partida() {
			/*
			 Recupera del fitxer les partides guardades del jugador actual,
			 */
		}
		
		public void fer_jugada() {
			/*
			 Evalua el codi proposat comparant-lo amb la solució i retorna el resultat segons les regles
			 del joc. (Blanc color i la posició correcte, Negre si color correcte, posició incorrecte, 0 si
			 no hi ha res bé).
			 Anotación: 0 o cualquier otro valor, la idea es señalizar un espacio en blanco
			 */
			
		}
		public void consultar_ranking() {
			/* Crida a la funcion de ranking que retorna el ranking actual. */
			for(int i = 1; i <=3;++i)
					ranking.mostra_ranking(i);
		}	
		
		
}
