package com.prop.domini;

import java.util.ArrayList;

public class Algorisme {
	ArrayList<String> posibilitats;
	ArrayList<Character> jugat;
	
		public Algorisme() {
			posibilitats = new ArrayList<String>();
			jugat = new ArrayList<Character>();
		};
	
		public void printa(ArrayList<String> r) {
			for(String s : r) {
				System.out.println(s);
			}
		}
		
		public void genera(int pos,int columnes, ArrayList<Character> colors, ArrayList<Character> resultat){
			if(pos == columnes) {
				String e = new String();
				for(int i = 0; i < columnes;++i) {
					e += resultat.get(i);
				}
				posibilitats.add(e);
			}
			else {
				for(Character col:colors) {
					resultat.add(col);
					genera(pos+1,columnes,colors,resultat);
					resultat.remove(pos);
				}
			}
		}
		
		public ArrayList<Character> genera_nova_jugada(ArrayList<Character> resposta){
			//Analiza la respuesta para dar la siguiente jugada
			ArrayList<Character> nova_jugada = new ArrayList<Character>();
			for(Character c : resposta) {
				if(c == B)
					
				else if( c == N)
					
				else {
					
				}
			}
			return resposta;
		}
		
		public ArrayList<Character> basic(int primer,int columnes, ArrayList<Character>colors, ArrayList<Character> resposta){ 
			//Devuelve ArrayList<Character>
			
			ArrayList<Character> intermedis = new ArrayList<Character>();
			
			if(primer == 1) {//Solo genera todas la soluciones una vez
				genera(0,columnes,colors,intermedis); 
				String jugada = posibilitats.get(0);
				//Convertir String en arraylist<character>
				return jugat;
			}
			else { //Hago otra jugada a partir de la respuesta
				return genera_nova_jugada(resposta);
			}
		}
}
