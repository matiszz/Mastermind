package com.prop.persistencia;

import java.util.ArrayList;
import java.util.List;

public class ControladorDePersistencia {
	public static RegistreDatabase regDB;
	public static PartidesDatabase partDB;
	public static RankingDatabase rankDB;
	
	public ControladorDePersistencia() {
		regDB = new RegistreDatabase("RegistreJugadors.txt");
		partDB = new PartidesDatabase("Partides.txt");
		rankDB = new RankingDatabase("RankingJugadors.txt");
		regDB.crearDatabase();
		partDB.crearDatabase();
		rankDB.crearDatabase();
	}
	
	/* Guarda en la BBDD toda la info del jugador pasada por parámetros en el vector info solo si no existía
	 * ese jugador, sino no hace nada */
	public void emmagatzemaJugador(String[] info) {
		regDB.emmagatzemaJugador(info);
	}
	
	/* Guarda en la BBDD toda la info de una partida en concreto, si exístia ya esa partida, se borra la partida
	 * antigua con toda su info y se guarda la info actualizada
	 */
	public void emmagatzemaPartida(String[] partida, String idJugador) {
		partDB.emmagatzemaPartida(partida,idJugador);
	}
	
	/* Devuelve los idPartida de las partidas no finalizadas del jugador idJugador */	
	public List<Integer> partidesNoFinalitzades(String idJugador) {
		return partDB.partidesNoFinalitzades(idJugador);
	}
	
	public List<String> getIdPartidesGuardades(String idJugador) {
		return partDB.getIdPartidesGuardades(idJugador);
	}
	
	/* Devuelve la info de la partida idPartida a partir del parámetro idPartida que le pasamos */
	public List<String> getInfoPartida(String idPartida) {
		return partDB.getInfoPartida(idPartida);
	}
	
	/* Deprecated */
	public List< List<String> > obtePartidesJugador(String idJugador) {
		List< List<String> > l = new ArrayList< List<String> >();
		return l;
	}
	
	public void emmagatzemaRanking(String[][] ranking) {
			
	}
	
	public String[][] obteRanking() {
		String[][] asdf = null;
		return asdf;
	}
	
	public static void main(String[] args) {
		ControladorDePersistencia cP = new ControladorDePersistencia();
		//String id = "idJugador1";
		//String[] s = new String[] {"1234", "mode1yaempezamos", "temps1", "numJugades1", "puntuacio1", "numFiles1", "longCodi1", "false", "jugades1", "codiAmagat1", "dificultat1", "guanyada1"};
		//String[] s = new String[] {"idPartida2", "mode2modificadooooooo", "temps2", "numJugades2", "puntuacio2", "numFiles2", "longCodi2", "true", "jugades2", "codiAmagat2", "dificultat2", "guanyada2"};
		//String[] s = new String[] {"idPartida3", "mode3afull", "temps3", "numJugades3", "puntuacio3", "numFiles3", "longCodi3", "false", "jugades3", "codiAmagat3", "dificultat3", "guanyada3"};
		//cP.emmagatzemaPartida(s, id);
		List<String> l = cP.getInfoPartida("1233");
		for (int i=0; i<l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
	}
	
	
	
}
