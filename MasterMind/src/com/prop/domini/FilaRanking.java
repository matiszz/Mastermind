package com.prop.domini;


public class FilaRanking {
	int intents;
	String jugador;
	
	public FilaRanking() {
		this.intents = 0;
		this.jugador = "Posicio no ocupada";
	}
	
	public FilaRanking(int intents, String jugador) {
		this.intents = intents;
		this.jugador = jugador;
	}
	
	public int getintents() {
		return intents;
	}
	
	public void setintents(int intents) {
		this.intents = intents;
	}
	
	public String getjugador() {
		return jugador;
	}
	
	public void setjugador(String jugador) {
		this.jugador = jugador;
	}
}
