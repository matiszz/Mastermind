package com.prop.domini;

import java.util.ArrayList;

public class Algorisme {
	
		public Algorisme() {};
	
		public void printa(ArrayList<Character> r) {
			for(int i = 0; i < r.size(); i+=3) {
				char c1,c2,c3;
				c1 = r.get(i);
				c2 = r.get(i+1);
				c3 = r.get(i+2);
				System.out.print(c1);
				System.out.print(c2);
				System.out.println(c3);
			}
		}
		
		public void basic_backtrack(int pos,int columnes, ArrayList<Character> colors, ArrayList<Character> resultat){
			if(pos == columnes) printa(resultat);
			else {
				for(Character col:colors) {
					resultat.add(col);
					basic_backtrack(pos+1,columnes,colors,resultat);
					resultat.remove(pos);
				}
			}
		}
		
		public void basic(int columnes, ArrayList<Character>colors){ //Devuelve ArrayList<Character>
			ArrayList<Character> resultat = new ArrayList<Character>();
			ArrayList<String> codisgenerats = new ArrayList<String>();
			ArrayList<Character> intermedis = new ArrayList<Character>();
			
			basic_backtrack(0,columnes,colors,intermedis); 
			
			
		}
}