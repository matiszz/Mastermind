package com.prop.domini;


public class Jugador {
	String idJugador; //identificador de la clase
	String nomJugador;
	int partidesJugades;
	int partidesGuanyades;
	
	boolean CPU;
	
	public Jugador(String idJugador, String nomJugador, int partidesJugades, int partidesGuanyades) {
		this.idJugador = idJugador;
		this.nomJugador = nomJugador;
		this.partidesJugades = partidesJugades;
		this.partidesGuanyades = partidesGuanyades;
	}
	
	public Jugador(boolean CPU) {
		this.CPU = CPU;
	}
	
	public String getNomJugador(String idJugador) {
		return nomJugador;
	}
	
	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}
	
	public int getPartidesJugades() {
		return partidesJugades;
	}
	
	public void setPartidesJugades(int partidesJugades) {
		this.partidesJugades = partidesJugades;
	}
	
	public int getPartidesGuanyades() {
		return partidesGuanyades;
	}
	
	public void setPartidesGuanyades(int partidesGuanyades) {
		this.partidesGuanyades = partidesGuanyades;
	}	
}