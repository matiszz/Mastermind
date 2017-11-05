package com.prop.domini;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
	//Driver clase Algorisme i Controlador de Domini

	public static void main (String args[]) {
		System.out.println("Benvingut a Mastermind! Selecciona una de les següents opcions:");
		System.out.println("0. Surt del driver");
		System.out.println("1. Algorisme basic");
		System.out.println("2. Algorisme five guess");
		
		Scanner lector = new Scanner(System.in);
		
		char c;
		try{
			while ((c=(char)System.in.read()) != '0' ){
				switch(c) {
					case '1':
						boolean guanyat =  false;
						Algorisme a = new Algorisme();
						System.out.println("Introdueix el nombre de columnes");
						int columnes = lector.nextInt();
						System.out.println("Introdueix el nombre de colors");
						int colors= lector.nextInt();
						ArrayList<Integer> resposta = new ArrayList<Integer>();
						ArrayList<Integer> codiproposat = new ArrayList<Integer>();
						int j = 0;
						System.out.println("Introdueix la combinacio a endivinar");
						ArrayList<Integer> codisecret = new ArrayList<Integer>();
						for(int i = 0; i < columnes;++i) codisecret.add(lector.nextInt());
						while(!guanyat && j < 10) {
							System.out.println("Iteracio " + j);
							codiproposat = a.calcula_jugada(columnes,colors, resposta);
							for(int i = 0; i < codiproposat.size(); ++i) System.out.print(codiproposat.get(i));
							System.out.println("");
							resposta = a.aplica_logica(codisecret, codiproposat);
							int negres = 0;
							for(int r = 0; r < columnes;++r) 
								if(resposta.get(r) == 2) ++negres;
							guanyat = (negres == columnes);	
							++j;
						}
						if(guanyat) System.out.println("Has encertat");
						
					break;
					case '2':
						boolean guanyat2 =  false;
						Algorisme a2 = new Algorisme();
						System.out.println("Introdueix el nombre de columnes");
						int columnes2 = lector.nextInt();
						System.out.println("Introdueix el nombre de colors");
						int colors2= lector.nextInt();
						System.out.println("Introdueix la combinacio a endivinar");
						ArrayList<Integer> codisecret2 = new ArrayList<Integer>();
						for(int i = 0; i < columnes2;++i) codisecret2.add(lector.nextInt());
						
						ArrayList<Integer> resposta2 = new ArrayList<Integer>();
						ArrayList<Integer> codiproposat2 = new ArrayList<Integer>();
						int k = 0;
						while(!guanyat2 && k < 10) {
							System.out.println("Iteracio " + k);
							for(int s = 0; s < columnes2; ++s) System.out.print(codiproposat2.get(s));
							codiproposat2 = a2.five_guess(columnes2,colors2, resposta2);
							resposta2 = a2.aplica_logica(codisecret2, codiproposat2);
							int negres2 = 0;
							for(int r = 0; r < columnes2;++r) 
								if(resposta2.get(r) == 2) ++negres2;
							guanyat = (negres2 == columnes2);	
							++k;
							
						}
						
						if(guanyat2) System.out.println("Has encertat");
					break;
					default:
						lector.close();
					break;
				}
			
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
			
	
	}
}
