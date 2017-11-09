package com.prop.domini;

import java.util.ArrayList;
import java.util.Scanner;

import com.prop.persistencia.Database;

public class Driver1 {
	// Driver para las clases GeneradorJoc,Jugada,Joc,Partida,Tauler
	static Database db;

	private static Scanner lector;

	private static Jugador jugador = null;
	private static Partida partida = null;
	private static Jugada jugada = null;
	private static GeneradorJocs generadorJocs = null;
	private static Joc joc = null;
	
	public static void crearGeneradorJocs() {
		if (generadorJocs != null)
			System.out.println("Ja existeix un Generador de Jocs");
		else {
			System.out.println("Seleccioni si us plau el mode de difícultat del joc: ");
			System.out.println("  1. Fàcil");
			System.out.println("  2. Mitjà");
			System.out.println("  3. Difícil");

			int dif = lector.nextInt();

			if (dif == 1) {
				System.out.println("Dificultat seleccionada: " + dif);
				generadorJocs = new GeneradorJocs(20, 5, 3, false, dif);
			} else if (dif == 2) {
				System.out.println("Dificultat seleccionada: " + dif);
				generadorJocs = new GeneradorJocs(25, 6, 3, false, dif);
			} else if (dif == 3) {
				System.out.println("Dificultat seleccionada: " + dif);
				generadorJocs = new GeneradorJocs(25, 7, 3, false, dif);
			}
			System.out.println("GeneradorJocs creat amb èxit");
		}
	}
	
	public static void crearJocDefecte() {
		if (generadorJocs == null)
			System.out.println("Primer has de crear un Generador de Jocs");
		else {
			if (joc != null)
				System.out.println("Ja has creat un joc, i en nomès pot haver un");
			else {
				joc = generadorJocs.generaJocDefault();
				System.out.println("Joc creat!");
			}
		}
	}
	
	public static void crearJocPersonalitzat() {
		if (generadorJocs == null)
			System.out.println("Primer has de crear un Generador de Jocs");
		else {
			if (joc != null)
				System.out.println("Ja has creat un joc, i nomès en pot haver un");
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
	}
	
	public static void crearPartida() {
		if (generadorJocs == null)
			System.out.println("Primer has de crear un Generador de Jocs");
		else {
			if (joc == null)
				System.out.println("Avans has de crear un joc");
			else {
				partida = joc.crearPartida();
				System.out.println("Partida amb id " + partida.getIdPartida() + " creada!");
			}
		}
	}
	
	public static void jugarPartida() {
		
	}	
	
	public static void continuarPartida() {
		
	}
	
	public static void crearJugada() {
		if (partida == null)
			System.out.println("Primer has de crear una partida");
		else if (jugador == null)
			System.out.println("Primer has de crear un jugador");
		else {
			int numjugada = 0;
			jugada = new Jugada(numjugada,partida, jugador);
			System.out.println("Jugada creada correctament");
		}
	}
	
	public static void asignarValorsJugada() {
		ArrayList<Integer> cp = new ArrayList<Integer>();
		ArrayList<Integer> cr = new ArrayList<Integer>();
		if(jugada == null) System.out.println("Primer has de crear una jugada");
		else {
			System.out.println("Introdueix la mida del codi");
			int mida = lector.nextInt();
			System.out.println("Introdueix el codiproposat");
			for(int i = 0; i < mida; ++i) cp.add(lector.nextInt());
			System.out.println("Introdueix el codirespost");
			jugada.setcodiProposat(cp);
			System.out.println("S'ha establert correctament el codiproposat a la jugada creada");
			for(int i = 0; i < mida; ++i) cr.add(lector.nextInt());
			jugada.setcodiRespost(cr);
			System.out.println("S'ha establert correctament el codirespost a la juada creada");
		}
	}
	
	public static void ferJugada() {
		
	}
	
	public static void mostraTauler() {
		if (partida == null)
			System.out.println("Primer has de crear una partida");
		else if (jugador == null)
			System.out.println("Primer has de crear un jugador");
		else
			partida.estatTauler();
	}
	
	public static void crearJugador() {
		Registre reg = new Registre();
		System.out.println("Identificador del jugador: ");
		String id = lector.nextLine();
		ArrayList<Jugador> jugs = new ArrayList<Jugador>();
		jugs = reg.registrar(id);
		jugador = jugs.get(0);
		System.out.println("Jugador creat");
	}
	
	public static void main(String args[]) {
		System.out.println("Benvingut a Mastermind! Selecciona una de les següents opcions:");
		System.out.println("1. Crear generador de jocs");
		System.out.println("2. Crear joc per defecte");
		System.out.println("3. Crear joc personalitzat");
		System.out.println("4. Crear partida");
		System.out.println("5. Jugar partida nova");
		System.out.println("6. Continuar partida guardada");
		System.out.println("7. Crear Jugada");
		System.out.println("8. Asignar valors a una jugada creada");
		System.out.println("9. Fer Jugada");
		System.out.println("10. Mostrar tauler");
		System.out.println("11. Crear jugador");

		db = new Database("MasterMind-Database.txt");
		db.createDatabase();
		
		lector = new Scanner(System.in);
		
		String s;
		try {
			Ranking r = new Ranking();
			while ((s = lector.nextLine()) != "0") {

				switch (s) {
				case "1": // Crear Generador de Jocs
					crearGeneradorJocs();
					break;

				case "2": // Crear Joc per defecte
					crearJocDefecte();
					break;

				case "3": // CrearJoc personalitzat
					crearJocPersonalitzat();
					break;

				case "4": // CrearPartida
					crearPartida();
					break;

				case "5": // JugarPartida nova
					jugarPartida();
					break;

				case "6": // JugarPartida guardada
					continuarPartida();
					break;

				case "7": // Crear Jugada
					crearJugada();
					break;
				case "8": // Asignar codis a una jugada a una juagada
					asignarValorsJugada();
					break;
					
				case "9": // Fer Jugada
					ferJugada();
					break;
					
				case "10": // Mostrar tauler
					mostraTauler();
					break;
					
				case "11": // Crear jugador
					crearJugador();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}