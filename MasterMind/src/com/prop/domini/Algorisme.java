package com.prop.domini;

import java.util.ArrayList;

public class Algorisme {
	ArrayList<ArrayList<Integer>> combinacions;
	ArrayList<Integer> jugat;
	
		public Algorisme() {
			combinacions = new ArrayList<ArrayList<Integer>>();
			jugat = new ArrayList<Integer>();
		};
		public void printa(ArrayList<Integer> a) {
			for(Integer k : a) {
				System.out.print(k);
			}

		}
		
		public void copiar( ArrayList<Integer> ori,  ArrayList<Integer> dest) {
			for(int i = 0; i < ori.size(); ++i) {
				int valor = ori.get(i);
				dest.add(valor);
			}
		}
		
		public void genera_combinacions(int pos, int columnes,int colors, ArrayList<Integer> intermig) {
			if(pos == columnes) {
				ArrayList<Integer> nou = new ArrayList<Integer>();
				copiar(intermig,nou);
				combinacions.add(nou);
				
			}
			else {
				ArrayList<Integer> copia = new ArrayList<Integer>();
				copiar(intermig,copia);
				int posn = pos+1;
				for(int i = 0; i < colors; ++i) {
					if(i != 0) copia.remove(copia.size()-1);
					copia.add(i);
					genera_combinacions(posn,columnes, colors,copia);
				}
			}
		}
		
		public ArrayList<Integer> calcula_jugada(int columnes,int colors, ArrayList<Integer> resposta){
			ArrayList<Integer> intermig = new ArrayList<Integer>();
			if(resposta.isEmpty()) {
				genera_combinacions(0,columnes,colors,intermig);
			}
			else {
				for(int p = 0; p < columnes; ++p) {
					int color = resposta.get(p);
					if(color == 0 || color == 1) { //Tot malament o posicio malament
						int incorrecte = jugat.get(p);
						for(int p1 = 0; p1 < combinacions.size(); ++p1) { 
							ArrayList<Integer> comb  = combinacions.get(p1);
							//Recorro i descarto si no la posibilitat te aquesta posicio igual
							if(comb.get(p) == incorrecte) combinacions.remove(p1);
						}
					}
					else { //Tot bé
						int correcte = jugat.get(p);
						for(int p1 = 0; p1 < combinacions.size();++p1) { 
							ArrayList<Integer> comb  = combinacions.get(p1);
							//Recorro i descarto si no la posibilitat no te aquesta posicio igual
							if(comb.get(p) != correcte) combinacions.remove(p1);
						}
					}
				}
			
			}
			jugat = combinacions.get(0);
			return jugat;
		}
	
}