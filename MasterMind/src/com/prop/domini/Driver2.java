package com.prop.domini;

import com.prop.persistencia.*;

import java.io.File;
import java.util.*;

public class Driver2 {
	/* Driver per a les classes Jugador, Registre, Ranking i FilaRanking */
	
	private static Scanner lector = new Scanner(System.in);
	private static Registre reg = null;
	private static char c;
	private static Ranking r = null;
	private static FilaRanking f = null;
	
	public static RegistreDatabase registreDB = null;
	private static File fileRegistreDB = null;
	
	public static void registrarJugador() {
		if (reg == null)
			System.out.println("No has creat cap registre");
		else {
			System.out.print("Nom d'usuari del jugador: ");
			String id = lector.next();
			Jugador jug = reg.getJugador(id);
			if (jug != null)
				System.out.println("Ja existeix cap jugador amb el nom: " + id);
			else {
				ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
				jugadors.add(reg.registrar(id));
				System.out.println("Aquests son tots els jugadors registrats:");
				for (int i = 0; i < jugadors.size(); i++)
					System.out.println("  " + jugadors.get(i).getIdJugador());
			}
		}
	}

	public static void crearRegistre() {
		if ((reg != null) || (fileRegistreDB != null))
			System.out.println("Ja has creat un registre");
		else {
			reg = new Registre();
			registreDB = new RegistreDatabase("RegistreJugadors");
			fileRegistreDB = registreDB.getRegistreDatabaseFile();
			registreDB.crearDatabase();
			System.out.println("Registre creat");
		}
	}
	
	public static void consultarInfoJugador() {
		System.out.print("Nom d'usuari del jugador: ");
		String idJugador = lector.next();
		Jugador jug = reg.getJugador(idJugador);
		if (jug == null)
			System.out.println("No existeix cap jugador amb el nom: " + idJugador);
		else {
			System.out.println("Nom jugador: " + jug.getIdJugador());
	        System.out.println("Partides jugades: " + jug.getPartidesJugades());
	        System.out.println("Partides guanyades: " + jug.getPartidesGuanyades());
		}
	}
	
	public static void crearRanking() {
		if (r != null)
			System.out.println("Ja existeix un ranking");
		else {
			r = new Ranking();
			System.out.println("Ranking creat correctament");
		}
	}
	
	public static void consultarRanking() {
		if (r == null)
			System.out.println("Primer has de crear un ranking");
		else {
			if (r.ranking_buit(1))
				System.out.println("Ranking f�cil buit, afegeix primer algun record");
			else
				r.mostra_ranking(1);
			if (r.ranking_buit(2))
				System.out.println("Ranking mitj� buit, afegeix primer algun record");
			else
				r.mostra_ranking(2);
			if (r.ranking_buit(3))
				System.out.println("Ranking dif�cil buit, afegeix primer algun record");
			else
				r.mostra_ranking(3);
		}
	}

	public static void actualitzarRanking() {
		if (r == null)
			System.out.println("Primer has de crear un ranking");
		else {
			if (f == null)
				System.out.println("Primer has de crear una fila del ranking");
			else {
				System.out.println("Escriu la dificultat entre 1(m�nima) y 3(m�xima)");
				int dif = lector.nextInt();
				if(dif < 0 || dif > 3) {
					System.out.println("Introdueix un valor entre 1 y 3 si us plau");
					return;
				}
				r.afegeix_fila(f, dif);
				System.out.println("La fila del ranking ha estat actualitzada correctament");
			}
		}
	}

	public static void crearFilaRanking() {
		System.out.println("Escriu la puntuaci� entre 1 y 25");
		int puntuacio = lector.nextInt();
		if(puntuacio <= 0 || puntuacio > 25) {
			System.out.println("Entre 1 y 25 si us plau");
			return;
		}
		System.out.println("Escriu el nom del jugador");
		String nom = lector.next();
		Jugador jug = reg.getJugador(nom);
		if (jug == null)
			System.out.println("No existeix cap jugador amb el nom: " + nom);
		else {
			f = new FilaRanking(puntuacio, nom);
			System.out.println("La fila del ranking ha estat creada correctament");
		}
	}
	
	public static void usage() {
		System.out.println("*********************************************************************");
		System.out.println("* Benvingut a Mastermind! Selecciona una de les seg�ents opcions:");
		System.out.println("*	0. Sortir del men�");
		System.out.println("*	1. Registrar un jugador");
		System.out.println("*	2. Crear un registre");
		System.out.println("*	3. Consultar informaci� d'un jugador");
		System.out.println("*	4. Crear un ranking");
		System.out.println("*	5. Consultar el ranking");
		System.out.println("*	6. Actualitzar el ranking");
		System.out.println("*	7. Crea una fila del ranking");
		System.out.println("*********************************************************************");
	}
	
	public static void main(String args[]) {
		usage();
		
		lector = new Scanner(System.in);
		
		try {
			while ((c = (char) System.in.read()) != '0') {
				switch (c) {
				case '1': 
					registrarJugador();
					break;
				case '2': 
					crearRegistre();
					break;
				case '3': 
					consultarInfoJugador();
					break;
				case '4': 
					crearRanking();
					break;
				case '5': 
					consultarRanking();
					break;
				case '6': 
					actualitzarRanking();
					break;
				case '7': 
					crearFilaRanking();
					break;
				default:
					
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
