package com.prop.persistencia;


public class ControladorDePersistencia {
	
		RegistreDatabase regDB = new RegistreDatabase("RegistreJugadors.txt");
		PartidesDatabase partDB = new PartidesDatabase("Partides.txt");
		RankingDatabase rankDB = new RankingDatabase("RankingJugadors.txt");

		/* Guarda info a una base de datos que puede ser la del ranking, registro o partida (puede que haya alguna mas) */
		/* Parámetros: 
		 * int modo: 0 si es para almacenar en la bd de registro
		 * 			 1 si es para almacenar en la bd de partida
		 * 			 2 si es para almacenar en la bd de ranking 
		 * String[] info: vector con la info del objeto segun el modo que se haya pasado */
		public void emmagatzema(int mode, String[] info) {
			if (mode == 0) { //registro jugadores
				regDB.emmagatzemaJugador(info);
			}
			else if (mode == 1) { //partidas
				
			}
			else if (mode == 2) { //ranking
				
			}
		}
		
		/* Consulta jugador */
		public String[] consultaJugador(String id) {
			String[] jugador = null;
			return jugador;
		}
		
		//public void partides_no_finalitzades(String nomjugador) {}
		
		//public String[] obteranking() {}
		
		//public String[] obtepartidesjugador(String nomjugador) {}
		
}