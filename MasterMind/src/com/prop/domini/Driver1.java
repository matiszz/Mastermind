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
		GeneradorJocs generadorJocs = null;
		Joc joc = null;
		
		char c;
		try{
			Ranking r = new Ranking();
			while ((c=(char)System.in.read()) != '0' ){
				
				switch(c) {
					case '1': //Crear Generador de Jocs
						if (generadorJocs != null) System.out.println("Ja existeix un Generador de Jocs");
						else {
							System.out.println("Seleccioni si us plau el mode de difícultat del joc: ");
							System.out.println("  1. Fàcil");
							System.out.println("  2. Mitjà");
							System.out.println("  3. Difícil");
							
							int dif = lector.nextInt();
							
							if (dif == 1) {
								System.out.println("Dificultat seleccionada: " + dif);
								generadorJocs = new GeneradorJocs(20,5,3,false,dif);
							}
							else if (dif == 2) {
								System.out.println("Dificultat seleccionada: " + dif);
								generadorJocs = new GeneradorJocs(25,6,3,false,dif);
							}
							else if (dif == 3) {
								System.out.println("Dificultat seleccionada: " + dif);
								generadorJocs = new GeneradorJocs(25,7,3,false,dif);
							}
							System.out.println("GeneradorJocs creat amb èxit");
						}
						break;
					
					case '2': //Crear Joc per defecte
						if (generadorJocs == null) System.out.println("Primer has de crear un Generador de Jocs");
						else {
							if (joc != null) System.out.println("Ja has creat un joc, i en nomès pot haver un");
							else {
								joc = generadorJocs.generaJocDefault();
								System.out.println("Joc creat!");
							}
						}
						break;
					
					case '3': //CrearJoc personalitzat 
						if (generadorJocs == null) System.out.println("Primer has de crear un Generador de Jocs");
						else {
							if (joc != null) System.out.println("Ja has creat un joc, i nomès en pot haver un");
							else {
								System.out.println("  Número de files: ");
								int numFiles = lector.nextInt();
								System.out.println("  Longitud del codi: ");
								int longCodi = lector.nextInt();
								System.out.println("  Número de colors: ");
								int numColors = lector.nextInt();
								System.out.println("  Seràs el CodeMaker? (true/false) ");
								boolean mostraCodi = lector.nextBoolean();
								System.out.println("  Dificultat (1, 2, 3): ");
								int dificultat = lector.nextInt();
								joc = generadorJocs.generaJocCustom(numFiles, longCodi, numColors, mostraCodi, dificultat);
								System.out.println("Joc creat!");
							}
						}
						break;
					
					case '4': //CrearPartida
						if (generadorJocs == null) System.out.println("Primer has de crear un Generador de Jocs");
						else {
							if (joc == null) System.out.println("Avans has de crear un joc");
							else {
								partida = joc.crearPartida();
								System.out.println("Partida amb id " + partida.getIdPartida() + " creada!");
							}
						}
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