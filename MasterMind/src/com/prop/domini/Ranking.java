package com.prop.domini;

import java.util.ArrayList;


public class Ranking {
	ArrayList<FilaRanking> r_facil;
	ArrayList<FilaRanking> r_medio;
	ArrayList<FilaRanking> r_dificil;
	ControladorDeDomini ctrl;
	
	public Ranking(ControladorDeDomini ctrl) {
		r_facil = new ArrayList<FilaRanking>();
		r_medio = new ArrayList<FilaRanking>();
		r_dificil = new ArrayList<FilaRanking>();
		this.ctrl = ctrl;
		this.recuperaRanking();
	}

	public void recuperaRanking() {
		ArrayList<String> RankingDB = ctrl.recuperaRanking();
		for(int i = 0; i < RankingDB.size();++i) {
			String fila = RankingDB.get(i);
			
			String[] campos = fila.split(" ");
			if((campos[1] != "-") && (campos[2] != "")){

				FilaRanking f = new FilaRanking(Integer.parseInt(campos[1]),campos[2]);
				if(i < 10) { //Facil
					this.afegeix_fila(f, 1);
				}
				else if(i >= 10 && i < 20) { //Medio
					this.afegeix_fila(f, 2);
				}
				else {//Dificil
					this.afegeix_fila(f, 3);
				}
			}
		}
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
	
	public boolean afegeix_fila(FilaRanking f, int dificultat) { 
		//Afegeix la fila al ranking corresponent segons el paràmetre dificultat (1 = facil,2=mitjana,3=dificil)
		boolean afegida = false;
		
		//if((dificultat < 1) || (dificultat > 3) ) //Ja s'haura comprovat a la capa de presentacio
		if(dificultat == 1) {
			if(r_facil.isEmpty()) {
				r_facil.add(f); 
				afegida = true;
			}
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
				if(!trobat && (r_facil.size() <10) ) {
					afegida = true;
					r_facil.add(f); //Afegeix al final
				}
				else if(trobat) { //Aafageix al mig
					r_facil.add(pos,f);
					afegida = true;
					if(r_facil.size() == 10) r_facil.remove(10);
				}
			}
		}
		else if (dificultat == 2) {
			if(r_medio.isEmpty()) {
				r_medio.add(f); 
				afegida = true;
			}
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
				if(!trobat && (r_medio.size() <10) ) {
					afegida = true;
					r_medio.add(f); //Afegeix al final
				}
				else if(trobat) { //Aafageix al mig
					r_medio.add(pos,f);
					afegida = true;
					if(r_medio.size() == 10) r_medio.remove(10);
				}
			}
		}
		else {
			if(r_dificil.isEmpty()) {
				r_dificil.add(f);
				afegida = true;
			}
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
				if(!trobat && (r_dificil.size() <10) ) {
					afegida = true;
					r_dificil.add(f);  //Afegeix al final
				}
				else if(trobat) { //Aafageix al mig
					r_dificil.add(pos,f);
					afegida = true;
					if(r_dificil.size() == 10) r_dificil.remove(10);
				}
			}
		}
	return afegida;
	}
	
	public boolean existeixRanking() {
		boolean buit;
		buit = ((r_facil.size() == 0) && (r_medio.size() == 0) && (r_dificil.size() == 0));
		return buit;
	}
	
	public ArrayList<String> converteix_Ranking(){
		ArrayList<String> res = new ArrayList<String>();
		int i ;
		for(i = 0; i < r_facil.size();++i) {
			FilaRanking f = r_facil.get(i);
			String elem = (i+1) + f.converteix();
			res.add(elem);
		}
		while(i < 10) {
			res.add((i+1) + " - -");
			i++;
		}
		for(i = 0; i < r_medio.size();++i) {
			FilaRanking f = r_medio.get(i);
			String elem = (i+1) + f.converteix();
			res.add(elem);
		}
		while(i < 10) {
			res.add((i+1) + " - -");
			i++;
		}
		for(i = 0; i < r_dificil.size();++i) {
			FilaRanking f = r_dificil.get(i);
			String elem = (i+1) + f.converteix();
			res.add(elem);
		}
		while(i < 10) {
			res.add((i+1) +" - -");
			i++;
		}
		return res;
	}
}
