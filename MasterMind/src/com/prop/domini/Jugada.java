package com.prop.domini;

import com.prop.domini.Partida;

public class Jugada {
	int numJugada;
	int codiProposat[];
	int codiRespost[];
	boolean encert;
	Jugador jugador;
	Partida partida;
	
	public Jugada(int numJugada, int codiProposat[], int codiRespost[], boolean encert) {
		this.numJugada = numJugada;
		this.codiProposat = codiProposat;
		this.codiRespost = codiRespost;
		this.encert = encert;
	}
	
	//Setters
	public void setnumJugada(int numJugada) {	
		this.numJugada = numJugada;
	}
	
	public void setcodiProposat(int codiProposat[]) {	
		this.codiProposat = codiProposat;
	}
	
	public void setcodiRespost(int codiRespost[]) {	
		this.codiRespost = codiRespost;
	}
	
	public void setencert(boolean encert) {
		this.encert = encert;
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void setPartida(Partida partida) {	
		this.partida = partida;
	}
	
	//Getters
	
	public int getnumJugada() {
		return numJugada;
	}
	
	public int[] getcodiProposat() {
		return codiProposat;
	}

	public int[] getcodiRespost() {
		return codiRespost;
	}

	public boolean getencert() {
		return encert;
	}
	
	public Jugador getJugador() {
		return this.jugador;
	}
	public Partida getPartida() {	
		 return this.partida;
	}
}
