package com.prop.domini;

import java.util.ArrayList;

import com.prop.domini.Partida;

public class Jugada {
	int numJugada;
	ArrayList<String> codiProposat;
	ArrayList<String> codiRespost;
	boolean encert;
	Jugador jugador;
	Partida partida;
	
	public Jugada (Partida p, Jugador j) {
		this.numJugada = 0 ;
		this.encert = false;
		this.jugador = j;
		this.partida = p;
		
	}
	
	public Jugada(int numJugada,ArrayList<String> codiProposat, ArrayList<String> codiRespost, boolean encert, Jugador jugador, Partida partida) {
		this.numJugada = numJugada;
		this.codiProposat = codiProposat;
		this.codiRespost = codiRespost;
		this.encert = encert;
		this.jugador = jugador;
		this.partida = partida;
	}
	
	//Setters
	public void setnumJugada(int numJugada) {	
		this.numJugada = numJugada;
	}
	
	public void setcodiProposat(ArrayList<String> codiProposat) {	
		this.codiProposat = codiProposat;
	}
	
	public void setcodiRespost(ArrayList<String> codiRespost) {	
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
	
	public ArrayList<String> getcodiProposat() {
		return codiProposat;
	}

	public ArrayList<String> getcodiRespost() {
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
