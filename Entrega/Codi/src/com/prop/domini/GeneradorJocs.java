package com.prop.domini;

import com.prop.domini.Joc;

public class GeneradorJocs {
	int numFiles;
	int longCodi;
	int numColors;
	boolean mostraCodi; //que hace mostraCodi?¿
	int dificultat;
	Joc juego;
	
	public GeneradorJocs(int numFiles, int longCodi, int numColors, boolean mostraCodi, int dificultat) {
		this.numFiles = numFiles;
		this.longCodi = longCodi;
		this.numColors = numColors;
		this.mostraCodi = mostraCodi;
		this.dificultat = dificultat;
		this.juego = null;
	}
	
	public Joc generaJocDefault() {
		juego = new Joc(numFiles, longCodi, numColors, mostraCodi, dificultat);
		return juego;
	}
	
	public Joc generaJocCustom(int numFiles, int longCodi, int numColors, boolean mostraCodi, int dificultat) {
		juego = new Joc(numFiles, longCodi, numColors, mostraCodi, dificultat);
		return juego;
	}

	public Joc getJoc() {
		return juego;
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
