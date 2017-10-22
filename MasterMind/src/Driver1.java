package com.prop.domini;

import com.prop.persistencia.Database;

public class Driver1 {
	//Driver para las clases GeneradorJoc,Joc,Partida
	/*
	 Opciones del menú:
	 1.CrearGeneradorJocs
	 2.CrearJoc per defecte
	 3.CrearJoc personalitzat 
	 4.CrearPartida
	 5.JugarPartida nova
	 6.JugarPartida guardada
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
		
		db = new Database("MasterMind-Database.txt");
		db.createDatabase();
		
	}
}
