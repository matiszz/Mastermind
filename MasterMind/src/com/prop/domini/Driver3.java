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
						
						while(j < 10 && !guanyat) {
							codiproposat = a.calcula_jugada(columnes,colors, resposta);
							for(int i = 0; i < codiproposat.size(); ++i) System.out.print(codiproposat.get(i));
							resposta.clear();
							System.out.println("");
							System.out.println("Fica la resposta al codi proposat");
							int negres = 0;
							for(int i = 0; i < columnes;++i) { //Lectura de la resposta de l'usuari.
								int k = lector.nextInt();
								if(k == 0) resposta.add(0);
								if(k == 1) resposta.add(1);
								if(k == 2) {
									negres++;
									resposta.add(2);
								}
							}
							if(negres == columnes) guanyat = true;
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
						ArrayList<Integer> resposta2 = new ArrayList<Integer>();
						ArrayList<Integer> codiproposat2 = new ArrayList<Integer>();
						int k = 0;
						while( k < 10 && !guanyat2) {
								codiproposat = a2.five_guess(columnes2,colors2, resposta2);
								for(int i = 0; i < codiproposat2.size(); ++i) System.out.print(codiproposat2.get(i));
								resposta2.clear();
								System.out.println("");
								System.out.println("Fica la resposta al codi proposat");
								int negres = 0;
								for(int i = 0; i < columnes2;++i) { //Lectura de la resposta de l'usuari.
									int l = lector.nextInt();
									if(l == 0) resposta2.add(0);
									if(l == 1) resposta2.add(1);
									if(l== 2) {
										negres++;
										resposta2.add(2);
									}
								}
								if(negres == columnes2) guanyat2 = true;
								++k;
							
						}
						
						if(guanyat2) System.out.println("Has encertat");
					break;
				}
			lector.close();
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
			
	
	}
}
