package com.prop.domini;

/* Classe creada por Mati */

import java.util.ArrayList;

public class Joc {
	int numFiles;
	int longCodi;
	int numColors;
	boolean mostraCodi;
	int dificultat;
	ArrayList<Partida> partides;
	int lastId;
	
	public Joc(int numFiles, int longCodi, int numColors, boolean mostraCodi, int dificultat) {
		super();
		this.numFiles = numFiles;
		this.longCodi = longCodi;
		this.numColors = numColors;
		this.mostraCodi = mostraCodi;
		this.dificultat = dificultat;
		this.partides = new ArrayList<Partida>();
		this.lastId = 0;
	}
	
	public Partida crearPartida() {
		Partida p = new Partida(lastId, "mode?", false, numFiles, longCodi);
		lastId++;
		partides.add(p);
		return p;
	}

	public ArrayList<Partida> getPartides() {
		return partides;
	}
	
	public int getNumFiles() {
		return numFiles;
	}

	public void setNumFiles(int numFiles) {
		this.numFiles = numFiles;
	}

	public int getLongCodi() {
		return longCodi;
	}

	public void setLongCodi(int longCodi) {
		this.longCodi = longCodi;
	}

	public int getNumColors() {
		return numColors;
	}

	public void setNumColors(int numColors) {
		this.numColors = numColors;
	}

	public boolean isMostraCodi() {
		return mostraCodi;
	}

	public void setMostraCodi(boolean mostraCodi) {
		this.mostraCodi = mostraCodi;
	}

	public int getDificultat() {
		return dificultat;
	}

	public void setDificultat(int dificultat) {
		this.dificultat = dificultat;
	}
	
	
}
