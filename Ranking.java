package com.prop.domini;

import java.util.ArrayList;


public class Ranking {
	ArrayList<FilaRanking> r_facil;
	ArrayList<FilaRanking> r_medio;
	ArrayList<FilaRanking> r_dificil;
	
	public Ranking() {
		r_facil = new ArrayList<FilaRanking>();
		r_medio = new ArrayList<FilaRanking>();
		r_dificil = new ArrayList<FilaRanking>();
	}

	public void getrankings(ArrayList<FilaRanking>facil, ArrayList<FilaRanking>medio, ArrayList<FilaRanking>dificil) {
		facil = r_facil;
		medio = r_medio;
		dificil = r_dificil;
	}
	
	public void setrankings(ArrayList<FilaRanking>facil, ArrayList<FilaRanking>medio, ArrayList<FilaRanking>dificil){
		r_facil = facil;
		r_medio = medio;
		r_dificil = dificil;
	}
	public boolean ranking_buit(int dificultat) {
		if(dificultat == 1 && (r_facil.size() == 0) ) return true;
		else if(dificultat == 2 && (r_medio.size() == 0) ) return true;
		else if(dificultat == 3 && (r_facil.size() == 0) ) return true;
		else return false;
	}
	
	public void mostra_ranking(int dificultat) {
		if(dificultat < 1 || dificultat > 3) return;
		else {
			if(dificultat == 1) {
				System.out.println("Ranking dificultat facil");
				int i = 1;
				for(FilaRanking fil:r_facil) {
					System.out.println(i + ". alies: " + fil.jugador + "      intents: " + fil.intents);
					++i;
				}
			}
			else if(dificultat == 2) {
				System.out.println("Ranking dificultat mitjana");
				int i = 1;
				for(FilaRanking fil:r_medio) {
					System.out.println(i + ". alies: " + fil.jugador + "      intents: " + fil.jugador);
					++i;
				}
			}
			else {
				System.out.println("Ranking dificultat dificil");
				int i = 1;
				for(FilaRanking fil:r_dificil) {
					System.out.println(i + ". alies: " + fil.jugador + "      intents: " + fil.jugador);
					++i;
				}
			}
		}
	}
	
	public void afegeix_fila(FilaRanking f, int dificultat) { 
		//Añade la fila al ranking correspondiente segun dificultad (1 = facil,2=medio,3=dificil)
		
		if((dificultat < 1) || (dificultat > 3) ) return;
		else if(dificultat == 1) {
			if(r_facil.size() == 0) r_facil.add(f); 
			else { //Si no está buida
				boolean trobat = false;
				int i,pos;
				pos = 0;
				for(i = 0; !trobat && i< r_facil.size();++i) {
					FilaRanking fila = r_facil.get(i);
					if(fila.intents > f.intents) {
						trobat = true;
						pos = i;
					}
				}
				if(!trobat && (r_facil.size() <10) ) r_facil.add(f); //Añado al final
				else if(trobat) { //Añado en medio
					r_facil.add(pos,f);
					if(r_facil.size() == 10) r_facil.remove(10);
				}
			}
		}
		else if (dificultat == 2) {
			if(r_medio.size() == 0) r_medio.add(f); 
			else { //Si no está buida
				boolean trobat = false;
				int i;
				for(i = 0; !trobat && i< r_medio.size();++i) {
					FilaRanking fila = r_medio.get(i);
					if(fila.intents > f.intents) {
						trobat = true;
					}
				}
				if(!trobat && (r_medio.size() <10) ) r_medio.add(f); //Añado al final
				else if(trobat) { //Añado en medio
					r_medio.add(i,f);
					if(r_medio.size() == 10) r_medio.remove(10);
				}
			}
		}
		else {
			if(r_dificil.size() == 0) r_dificil.add(f); 
			else { //Si no está buida
				boolean trobat = false;
				int i;
				for(i = 0; !trobat && i< r_dificil.size();++i) {
					FilaRanking fila = r_dificil.get(i);
					if(fila.intents > f.intents) {
						trobat = true;
					}
				}
				if(!trobat && (r_dificil.size() <10) ) r_dificil.add(f); //Añado al final
				else if(trobat) { //Añado en medio
					r_dificil.add(i,f);
					if(r_dificil.size() == 10) r_dificil.remove(10);
				}
			}
		}
	}
}
