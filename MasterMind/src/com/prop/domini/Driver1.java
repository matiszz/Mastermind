package com.prop.domini;


import com.prop.persistencia.Database;
import com.prop.domini.*;

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
		System.out.println("0. Sortir del Driver");
		System.out.println("1. Crear generador de jocs");
		System.out.println("2. Crear joc per defecte");
		System.out.println("3. Crear joc personalitzat");
		System.out.println("4. Crear partida");
		System.out.println("5. Jugar partida nova");
		System.out.println("6. Continuar partida guardada");
		System.out.println("7. Crear Jugada");
		System.out.println("8. Fer Jugada"); //Pertany a jugador
		
		db = new Database("MasterMind-Database.txt");
		db.createDatabase();
		
		StringBuffer str=new StringBuffer();
		char c;
		Jugador jugador = null;
		Partida partida = null;
		Jugada jugada = null;
		try {
			Ranking r = new Ranking();
			while ((c=(char)System.in.read()) != '0' ){
				
				switch(c) {
					case '6':
						System.out.println();
					break;
					case '7': 
						if(partida == null) System.out.println("Primer has de crear una partida");
						if(jugador == null) System.out.println("Primer has de crear un jugador");
						jugada = new Jugada(partida,jugador); 
						System.out.println("Jugada creada correctament");
					break;
				}
			}            
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
