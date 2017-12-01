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
		if(dificultat == 1 && (r_facil.isEmpty()) ) return true;
		else if(dificultat == 2 && (r_medio.isEmpty()) ) return true;
		else if(dificultat == 3 && (r_facil.isEmpty()) ) return true;
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
					System.out.println(i + ". alies: " + fil.jugador + "      intents: " + fil.intents);
					++i;
				}
			}
			else {
				System.out.println("Ranking dificultat dificil");
				int i = 1;
				for(FilaRanking fil:r_dificil) {
					System.out.println(i + ". alies: " + fil.jugador + "      intents: " + fil.intents);
					++i;
				}
			}
		}
	}
	
	public void afegeix_fila(FilaRanking f, int dificultat) { 
		//Afegeix la fila al ranking corresponent segons el paràmetre dificultat (1 = facil,2=mitjana,3=dificil)
		
		if((dificultat < 1) || (dificultat > 3) ) return;
		else if(dificultat == 1) {
			if(r_facil.isEmpty()) r_facil.add(f); 
			else { //Si no està buida
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
				if(!trobat && (r_facil.size() <10) ) r_facil.add(f); //Afegeix al final
				else if(trobat) { //Aafageix al mig
					r_facil.add(pos,f);
					if(r_facil.size() == 10) r_facil.remove(10);
				}
			}
		}
		else if (dificultat == 2) {
			if(r_medio.isEmpty()) r_medio.add(f); 
			else { //Si no està buida
				boolean trobat = false;
				int pos,i;
				pos = 0;
				for(i = 0; !trobat && i< r_medio.size();++i) {
					FilaRanking fila = r_medio.get(i);
					if(fila.intents > f.intents) {
						trobat = true;
						pos = i;
					}
				}
				if(!trobat && (r_medio.size() <10) ) r_medio.add(f); //Afegeix al final
				else if(trobat) { //Aafageix al mig
					r_medio.add(pos,f);
					if(r_medio.size() == 10) r_medio.remove(10);
				}
			}
		}
		else {
			if(r_dificil.isEmpty())	r_dificil.add(f);
			else { //Si no està buida
				boolean trobat = false;
				int pos, i;
				pos = 0;
				for(i = 0; !trobat && i< r_dificil.size();++i) {
					FilaRanking fila = r_dificil.get(i);
					if(fila.intents > f.intents) {
						trobat = true;
						pos = i;
					}
				}
				if(!trobat && (r_dificil.size() <10) ) r_dificil.add(f);  //Afegeix al final
				else if(trobat) { //Aafageix al mig
					r_dificil.add(pos,f);
					if(r_dificil.size() == 10) r_dificil.remove(10);
				}
			}
		}
	}
}
