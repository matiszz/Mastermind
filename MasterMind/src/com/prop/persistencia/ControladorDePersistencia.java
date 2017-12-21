package com.prop.persistencia;

public class ControladorDePersistencia {

	RegistreDatabase regDB;
	PartidesDatabase partDB;
	RankingDatabase rankDB;
	
	public ControladorDePersistencia() {
		regDB = new RegistreDatabase("RegistreJugadors.txt");
		partDB = new PartidesDatabase("Partides.txt");
		rankDB = new RankingDatabase("RankingJugadors.txt");
	}
	
	//Se ejecuta la primera vez que se ejecuta el programa, luego en las demas ejecuciones solo hace print como que ya se han creado las databases
	public void inicialitzaDatabases() {
		regDB.crearDatabase();
		partDB.crearDatabase();
		rankDB.crearDatabase();
	}
	
	public void emmagatzemaJugador(String[] info) {
		regDB.emmagatzemaJugador(info);
	}
	
	public void emmagatzemaPartida(String[] partida,String idjugador) {
		
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

	public String[] getIdPartidesGuardades(String alies) {
	    return null;
    }
	
}
