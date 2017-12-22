package com.prop.persistencia;

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
	
	public void emmagatzemaJugador(String[] info) {
		regDB.emmagatzemaJugador(info);
	}
	
	public void emmagatzemaPartida(String[] partida, String idJugador) {
		partDB.emmagatzemaPartida(partida,idJugador);
	}
		
	public void emmagatzemaRanking(String[][] ranking) {
			
	}
		
	public void partidesNoFinalitzades(String nomjugador) {
		
	}
		
	public String[][] obteRanking() {
		String[][] asdf = null;
		return asdf;
	}
		
	public String[][] obtePartidesJugador(String nomjugador) {
		String[][] asdf = null;
		return asdf;
	}
	
	public static void main(String[] args) {
		ControladorDePersistencia cP = new ControladorDePersistencia();
		String id = "idJugador1";
		//String[] s = new String[] {"idPartida1", "mode1", "temps1", "numJugades1", "puntuacio1", "numFiles1", "longCodi1", "boolFinalitzada1", "jugades1", "codiAmagat1", "dificultat1", "guanyada1"};
		String[] s = new String[] {"idPartida2", "mode2modificadooooouoouo", "temps2", "numJugades2", "puntuacio2", "numFiles2", "longCodi2", "boolFinalitzada2", "jugades2", "codiAmagat2", "dificultat2", "guanyada2"};
		//String[] s = new String[] {"idPartida3", "mode3", "temps3", "numJugades3", "puntuacio3", "numFiles3", "longCodi3", "boolFinalitzada3", "jugades3", "codiAmagat3", "dificultat3", "guanyada3"};
		cP.emmagatzemaPartida(s, id);
	}
	
}
