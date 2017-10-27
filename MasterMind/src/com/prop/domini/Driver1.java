package com.prop.domini;


import java.util.Scanner;

import com.prop.persistencia.Database;

public class Driver1 {
	//Driver para las clases GeneradorJoc,Joc,Partida,
	/*
	 Opciones del menú:
	 1.CrearGeneradorJocs
	 2.CrearJoc per defecte
	 3.CrearJoc personalitzat 
	 4.CrearPartida
	 5.JugarPartida nova
	 6.JugarPartida guardada
	 7.Crear Jugada
	 8.Fer Jugada
	 */
	static Database db;
	
	public static void main (String args[]) {
		System.out.println("Benvingut a Mastermind! Selecciona una de les següents opcions:");
		System.out.println("1. Crear generador de jocs");
		System.out.println("2. Crear joc per defecte");
		System.out.println("3. Crear joc personalitzat");
		System.out.println("4. Crear partida");
		System.out.println("5. Jugar partida nova");
		System.out.println("6. Continuar partida guardada");
		System.out.println("7. Crear Jugada");
		System.out.println("8. Fer Jugada");
		
		db = new Database("MasterMind-Database.txt");
		db.createDatabase();
		
		Scanner lector = new Scanner(System.in);
		
		Jugador jugador = null;
		Partida partida = null;
		Jugada jugada = null;
		
		char c;
		try{
			Ranking r = new Ranking();
			while ((c=(char)System.in.read()) != '0' ){
				
				switch(c) {
					case '1': //Crear Generador de Jocs
						
						System.out.println("Seleccioni si us plau el mode de difícultat del joc: ");
						System.out.println("1. Fàcil");
						System.out.println("2. Mitjà");
						System.out.println("3. Difícil");
						
						int dif = lector.nextInt();
						
						if (dif == 1) {
							System.out.println("Dificultat seleccionada: " + dif);
							GeneradorJocs generadorJocs = new GeneradorJocs(20,5,3,false,dif);
						}
						else if (dif == 2) {
							System.out.println("Dificultat seleccionada: " + dif);
							GeneradorJocs generadorJocs = new GeneradorJocs(25,6,3,false,dif);
						}
						else if (dif == 3) {
							System.out.println("Dificultat seleccionada: " + dif);
							GeneradorJocs generadorJocs = new GeneradorJocs(25,7,3,false,dif);
						}
						
						break;
					
					case '2': //Crear Joc per defecte
						
						break;
					
					case '3': //CrearJoc personalitzat 
						
						break;
					
					case '4': //CrearPartida
	
						break;
						
					case '5': //JugarPartida nova
						
						break;
						
					case '6': //JugarPartida guardada
						
						break;
						
					case '7': //Crear Jugada
						if(partida == null) 
							System.out.println("Primer has de crear una partida");
						else if(jugador == null) 
							System.out.println("Primer has de crear un jugador");
						else {
							jugada = new Jugada(partida,jugador); 
							System.out.println("Jugada creada correctament");
						}
						break;
						
					case '8': //Fer Jugada
						
						break;
				}
			}            
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}