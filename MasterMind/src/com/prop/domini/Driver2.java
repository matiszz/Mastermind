package com.prop.domini;

import java.util.*;

public class Driver2 {
	// Driver para las clases Jugador,Registre,Ranking,Fila Ranking
	
	private static Scanner lector = new Scanner(System.in);
	private static Registre reg = null;
	private static char c;
	private static Ranking r = null;
	private static FilaRanking f = null;
	
	public static void registrarJugador() {
		if (reg == null)
			System.out.println("No has creat cap Registre");
		else {
			System.out.print("Nom d'usuari del jugador: ");
			String id = lector.next();
			ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
			jugadors = reg.registrar(id);
			System.out.println("Aquests son tots els jugadors registrats:");
			for (int i = 0; i < jugadors.size(); i++)
				System.out.println("  " + jugadors.get(i).getIdJugador());
		}
	}

	public static void crearRegistre() {
		if (reg != null)
			System.out.println("Ja has creat un Registre");
		else {
			reg = new Registre();
			System.out.println("Registre creat.");
		}
	}
	
	public static void consultarInfoJugador() {
		System.out.print("Nom d'usuari del jugador: ");
		String idJugador = lector.next();
		Jugador jug = reg.getJugador(idJugador);
		System.out.println("Nom Jugador: " + jug.getIdJugador());
        System.out.println("Partides jugades: " + jug.getPartidesJugades());
        System.out.println("Partides guanyades: " + jug.getPartidesGuanyades());
	}
	
	public static void crearRanking() {
		if (r != null)
			System.out.println("Ja existeix un Ranking");
		else {
			r = new Ranking();
			System.out.println("Ranking creat correctament");
		}
	}
	
	public static void consultarRanking() {
		if (r == null)
			System.out.println("Primer has de crear un Ranking");
		else {
			if (r.ranking_buit(1))
				System.out.println("Ranking fácil vacio, añade primero algun record");
			else
				r.mostra_ranking(1);
			if (r.ranking_buit(2))
				System.out.println("Ranking medio vacio, añade primero algun record");
			else
				r.mostra_ranking(2);
			if (r.ranking_buit(3))
				System.out.println("Ranking difícil vacio, añade primero algun record");
			else
				r.mostra_ranking(3);
		}
	}

	public static void actualitzarRanking() {
		if (r == null)
			System.out.println("Primer has de crear un Ranking");
		else {
			if (f == null)
				System.out.println("Primer has de crear una fila Ranking");
			else {
				System.out.println("Escriu la dificultat entre 1(minima) y 3(maxima)");
				int dif = lector.nextInt();
				r.afegeix_fila(f, dif);
				System.out.println("FilaRanking actualitzada correctament");
			}
		}
	}

	public static void crearFilaRanking() {
		System.out.println("Escriu la puntuació entre 1 y 25");
		int puntuacio = lector.nextInt();
		System.out.println("Escriu el nom del jugador");
		String nom = lector.next();
		f = new FilaRanking(puntuacio, nom);
		System.out.println("FilaRanking creada correctament");
	}
	
	public static void usage() {
		System.out.println("*********************************************************************");
		System.out.println("* Benvingut a Mastermind! Selecciona una de les següents opcions:");
		System.out.println("*	0. Sortir del menú");
		System.out.println("*	1. Registrar un Jugador");
		System.out.println("*	2. Crear un Registre");
		System.out.println("*	3. Consultar informació d'un jugador");
		System.out.println("*	4. Crear un Ranking");
		System.out.println("*	5. Consultar el Ranking");
		System.out.println("*	6. Actualitzar el Ranking");
		System.out.println("*	7. Crea una FilaRanking");
		System.out.println("*********************************************************************");
	}
	
	public static void main(String args[]) {
		usage();
		
		lector = new Scanner(System.in);
		
		try {
			while ((c = (char) System.in.read()) != '0') {
				switch (c) {
				case '1': // Registrar jugador
					registrarJugador();
					break;
				case '2': // Crear un Registre
					crearRegistre();
					break;
				case '3': // Consultar informació d'un jugador
					consultarInfoJugador();
					break;
				case '4': // Crear un Ranking
					crearRanking();
					break;
				case '5': // Consultar el Ranking
					consultarRanking();
					break;
				case '6': // Actualitzar el Ranking
					actualitzarRanking();
					break;
				case '7': // Crear una FilaRanking
					crearFilaRanking();
					break;
				default:
					if (c!='\n') usage();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
