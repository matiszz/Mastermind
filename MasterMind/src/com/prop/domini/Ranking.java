package com.prop.domini;


public class Ranking {
	FilaRanking puntuaciones[];
	
	public Ranking(FilaRanking puntuaciones[]) {
		this.puntuaciones = puntuaciones;
	}
	
	public FilaRanking[] getpuntuaciones() {
		return puntuaciones;
	}
	
	public void setpuntuaciones(FilaRanking[] puntuaciones) {
		this.puntuaciones = puntuaciones;
	}
}
