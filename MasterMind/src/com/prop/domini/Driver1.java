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
		partida.iniciarPartida();
	}	
	
	public static void continuarPartida() {
		partida.reanudaPartida();
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
		if (jugada == null)
            System.out.println("Primer has de crear una jugada");
        else if (jugada.getCodiProposat().isEmpty())
            System.out.println("Primer has d'establir valors a la jugada proposada");
        else if (jugada.getRespost().isEmpty())
            System.out.println("Primer has d'establir valors a la jugada resposta");
        else {
            Jugada tmp;
            tmp = new Jugada(jugada.getNumJugada(),jugada.getCodiProposat(), jugada.getCodiRespost(), true, jugador, partida);
            jugada = tmp;
        }
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
	
	public static void iniciarPartida() {
		if (partida == null)
			System.out.println("Primer has de crear una partida");
		else {
			partida.iniciarPartida();
			System.out.println("Partida iniciada.");
		}
	}
	
	public static void guardarPartida() {
		if (partida == null)
			System.out.println("Primer has de crear una partida");
		else {
			partida.guardarPartida();
			System.out.println("Partida guardada.");
		}
	}
	
	public static void reanudarPartida() {
		if (partida == null)
			System.out.println("Primer has de crear una partida");
		else {
			partida.reanudaPartida();
			System.out.println("Partida reanudada.");
		}
	}
	
	public static void veureTempsGuardat() {
		if (partida == null)
			System.out.println("Primer has de crear una partida");
		else
			System.out.println("Mil·lisegons totals: " + partida.getTemps());
	}
	
	public static void veureTempsFormat() {
		if (partida == null)
			System.out.println("Primer has de crear una partida");
		else
			System.out.println("Temps passat: " + partida.clock.getTime());
	}
	
	public static void usage() {
		System.out.println("*********************************************************************");
		System.out.println("* Benvingut a Mastermind! Selecciona una de les següents opcions:");
		System.out.println("*	0. Sortir ");
		System.out.println("*	1. Crear generador de jocs");
		System.out.println("*	2. Crear joc per defecte");
		System.out.println("*	3. Crear joc personalitzat");
		System.out.println("*	4. Crear partida");
		System.out.println("*	5. Jugar partida nova");
		System.out.println("*	6. Continuar partida guardada");
		System.out.println("*	7. Crear Jugada");
		System.out.println("*	8. Asignar valors a una jugada creada");
		System.out.println("*	9. Fer Jugada");
		System.out.println("*	10. Mostrar tauler");
		System.out.println("*	11. Crear jugador");
		System.out.println("*	12. Iniciar partida (rellotge)");
		System.out.println("*	13. Guardar partida (rellotge)");
		System.out.println("*	14. Reanudar partida (rellotge)");
		System.out.println("*	15. Veure temps guardat");
		System.out.println("*	16. Veure temps amb format");
		System.out.println("*");
		System.out.println("*	h. Veure aquest menú");
		System.out.println("*********************************************************************");
	}
	public static void main(String args[]) {
		usage();

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
				case "12": // Iniciar partida
					iniciarPartida();
					break;
				case "13": // Guardar partida
					guardarPartida();
					break;
				case "14": // Reanudar partida
					reanudarPartida();
					break;
				case "15": // Veure temps guardat
					veureTempsGuardat();
					break;
				case "16": // Veure temps actual
					veureTempsFormat();
					break;
				case "h":
					usage();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
