package com.prop.domini;

import java.util.ArrayList;

import com.prop.domini.Partida;

public class Jugada {
	int numJugada;
	ArrayList<Integer> codiProposat;
	ArrayList<Integer> codiRespost;
	boolean encert;
	Jugador jugador;
	Partida partida;
	
	public Jugada (int numJugada, Partida p, Jugador j) {
		this.numJugada = numJugada;
		this.encert = false;
		this.jugador = j;
		this.partida = p;
		codiProposat = new ArrayList<Integer>();
		codiRespost = new ArrayList<Integer>();
	}
	
	public Jugada(int numJugada,ArrayList<Integer> codiProposat, ArrayList<Integer> codiRespost, boolean encert, Jugador jugador, Partida partida) {
		this.numJugada = numJugada;
		this.codiProposat = codiProposat;
		this.codiRespost = codiRespost;
		this.encert = encert;
		this.jugador = jugador;
		this.partida = partida;
	}
	
	//Setters
	
	public void setcodiProposat(ArrayList<Integer> codiProposat) {	
		this.codiProposat = codiProposat;
	}
	
	public void setcodiRespost(ArrayList<Integer> codiRespost) {	
		this.codiRespost = codiRespost;
	}
	//Getters
	
	/*public int getnumJugada() {
		return numJugada;
	}
	
	public ArrayList<Integer> getcodiProposat() {
		return codiProposat;
	}

	public ArrayList<Integer> getcodiRespost() {
		return codiRespost;
	}
	
	public Jugador getJugador() {
		return this.jugador;
	}
	public Partida getPartida() {	
		 return this.partida;
	}
	*/
}
