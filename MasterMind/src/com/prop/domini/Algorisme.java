package com.prop.domini;

import java.util.ArrayList;
import java.util.Random;

public class Algorisme {
	ArrayList< ArrayList<Integer> > combinacions;
	ArrayList< ArrayList< ArrayList<Integer> > > matriu;
	ArrayList<Integer> jugat;
	ArrayList<Integer> valid; //Per cada posició i, si valid[i]==1 llavors la fila matrix[i] es valida, si valid[i] == 0 matri[i] invalida
	
		public Algorisme() {
			combinacions = new ArrayList<ArrayList<Integer>>();
			jugat = new ArrayList<Integer>();
			matriu = new ArrayList< ArrayList< ArrayList<Integer> > >();
			valid = new ArrayList<Integer>();
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
		
		public boolean busca_color(int color, ArrayList<Integer> vector) {
			for(int i = 0; i < vector.size();++i) if(vector.get(i) == color) return true;
			return false;
		}
		
		public int calcula_max(ArrayList<Integer> a) {
			//Calula el màxim de les posicions de l'array a
			int posmin = 0;
			for(int i = 1; i < a.size();++i) {
				if(a.get(i) < a.get(posmin) ) posmin = i;
			}
			return posmin;
		}
		
		public void genera_combinacions(int pos, int columnes,int colors, ArrayList<Integer> intermig) {
			if(pos == columnes) {
				ArrayList<Integer> nou = new ArrayList<Integer>();
				copiar(intermig,nou);
				combinacions.add(nou);
				valid.add(1);
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
		
		public ArrayList<Integer> calcula_eliminacion_minima(ArrayList <Integer> resposta) {
			ArrayList<Integer> minims = new ArrayList<Integer>();
			for(int i = 0; i < matriu.size();++i) {
				int elim = 0;
				if (valid.get(i) == 1) {
					ArrayList< ArrayList<Integer> > f = matriu.get(i);
					for(int j = 0; j < combinacions.size();++j) {
						if(f.get(j) != resposta) ++elim;
					}
					minims.add(elim);
				}
			}
			return minims;
		}
		
		public void elimina_incoherents(ArrayList<ArrayList<Integer>>combinacions,ArrayList<Integer> resposta,int columnes) {
			for(int p = 0; p < columnes; ++p) {
				int color = resposta.get(p);
				if(color == 0 || color == 1) { //Tot malament o posicio malament
					int incorrecte = jugat.get(p);
					for(int p1 = 0; p1 < combinacions.size(); ++p1) { 
						ArrayList<Integer> comb  = combinacions.get(p1);
						//Recorro i descarto si la posibilitat te aquesta posicio igual
						if(comb.get(p) == incorrecte) {
							valid.set(p1, 0);
							combinacions.remove(p1);
						}
					}
				}
				else { //Tot bé
					int correcte = jugat.get(p);
					for(int p1 = 0; p1 < combinacions.size();++p1) { 
						ArrayList<Integer> comb  = combinacions.get(p1);
						//Recorro i descarto si la posibilitat no te aquesta posicio igual
						if(comb.get(p) != correcte) {
							valid.set(p1, 0);
							combinacions.remove(p1);
						}
					}
				}
			}
		}
		
		public ArrayList<Integer> aplica_logica(ArrayList<Integer> codiamagat, ArrayList<Integer> codijugat) {
			//Determina la resposta obtinguda si juguem codijugat y la solució és codiamagat
			ArrayList<Integer> solucio = new ArrayList<Integer>();
			for(int i = 0; i < codijugat.size();++i) {
				int color = codijugat.get(i);
				if(codiamagat.get(i) == codijugat.get(i)) solucio.add(i,2); //Espiga negra
				else { //Mirem si el color hi és a la solució
					if(busca_color(color,codiamagat)) solucio.add(i,1);
					else solucio.add(i,0);
				}
			}
			return solucio;
		}
		
		public void genera_matriu(ArrayList<ArrayList<Integer>> combinaciones) {
			for(ArrayList<Integer> codijugat : combinaciones) {
				ArrayList< ArrayList < Integer> > fila = new ArrayList< ArrayList < Integer> >();
				for(ArrayList<Integer> codiamagat : combinaciones) {
					ArrayList<Integer> elem_mat = aplica_logica(codiamagat,codijugat);
					fila.add(elem_mat);
				}
				matriu.add(fila);
			}
		}
		
		public ArrayList<Integer> five_guess(int columnes, int colors, ArrayList<Integer> resposta){
			ArrayList<Integer> intermig = new ArrayList<Integer>();
			if(resposta.isEmpty()) {
				genera_combinacions(0,columnes,colors,intermig);
				genera_matriu(combinacions);
				jugat = combinacions.get(0);
			}
			else { //Five Guess
				elimina_incoherents(combinacions,resposta,columnes);
			//Por cada combinacion, soposar tots els possibles codis ocults i veure quantes possibilitats permet eliminar
				ArrayList<Integer> min = calcula_eliminacion_minima(resposta);
			//Seleccionar el mínim de cada possibilitat
				int pos = calcula_max(min);
			//Seleccionar el màximo entre totes les possibilitats i jugar la possibilitat suposadament és adequeada
				jugat = combinacions.get(pos);
			}
			return jugat;
		}
		
		public ArrayList<Integer> genera_random(ArrayList< ArrayList<Integer> > combinacions) {
			Random r = new Random();
			ArrayList<Integer> random = combinacions.get(r.nextInt(combinacions.size()));
			return random;
		}

		
		public ArrayList<Integer> calcula_jugada(int columnes,int colors, ArrayList<Integer> resposta){
			ArrayList<Integer> intermig = new ArrayList<Integer>();
			if(resposta.isEmpty()) {
				 genera_combinacions(0,columnes,colors,intermig);
				 jugat = combinacions.get(0);
			}
			else jugat = genera_random(combinacions);
			
			return jugat;
		}
		
		public boolean comprova(ArrayList<Integer> ar) {
			boolean b = true;
			for(int i = 0; i < ar.size() && b; ++i) 
				if(ar.get(i) != 2) b = false;
			return b;
		}
		
		public void simulaPartida(Partida p, Jugador j,ControladorDeDomini c) {
			for(int i = 1; i <= 10; ++i) {
				ArrayList<Integer> combinacio = new ArrayList<Integer>();
				ArrayList<Integer> respost = new ArrayList<Integer>();
				combinacio = this.five_guess(p.longCodi, 4, respost);
				respost = this.aplica_logica(p.codiamagat, combinacio);
				Jugada jug = new Jugada(i,p,j);
				jug.codiProposat = combinacio;
				jug.codiRespost = respost;
				jug.encert = this.comprova(respost);
				if(jug.encert) {
					i = 11;
				}
			}
		}
}