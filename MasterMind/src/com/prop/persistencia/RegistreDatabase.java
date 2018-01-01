package com.prop.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistreDatabase extends Database {
	private File file;
	
	public RegistreDatabase(String nom) {
		super(nom);
	}
	
	public File getRegistreDatabaseFile() {
		return file;
	}
	
	public void crearDatabase() {
		file = new File(nom);
		if (file.exists()) {
			System.out.println("Ja existeix la base de dades del registre de jugadors");
		}
		else {
			try {
				file = new File(nom);
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Registre de jugadors de MasterMind");
				bw.newLine();
				bw.flush();
				bw.close();
				
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				line = br.readLine();
				System.out.println(line);
				br.close();
				
				System.out.println("Base de dades creada correctament");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Afegir un jugador al registre */
	/* Si no existe el jugador lo a�ade a la BD, si existe no hace nada y printa que ya existe el jugador */
	public void emmagatzemaJugador(ArrayList<String> info) { //info[0] = idJugador, info[1] = partidesJugades, info[2] = partidesGuanyades
		FileWriter fw;
		BufferedWriter bw;
		try {
			Scanner sc = new Scanner(file); //buscamos si existe el jugador en la base de datos
			sc.nextLine(); //saltamos la primera l�nea ya que es el t�tulo
			Boolean found = false;
			while (sc.hasNextLine() && found.equals(false)) {
				String line = sc.nextLine();
				if (line.contains(info.get(0)))
					found = true;
			}
			sc.close();
			if (found.equals(false)) { //se puede hacer una excepci�n personalizada para que salte si ya existe el jugador pero que palo
				fw = new FileWriter(file,true); //true es para activar el append para que no sobreescriba lo que hab�a
				bw = new BufferedWriter(fw);
				bw.write(info.get(0) + " " + info.get(1) + " " + info.get(2));
				bw.newLine(); //nueva l�nea
				bw.flush();
				bw.close();
			}
			else System.out.println("Ja existeix el jugador");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/* Devuelve en una matriz toda la info de todos los jugadores del juego registrados hasta el momento. Cada
	 * fila es la info de cada jugador, idJugador, partidas jugadas y partidas ganadas en ese orden.
	 */
	public ArrayList< ArrayList<String> > getJugadors() {
		ArrayList< ArrayList<String> > l = new ArrayList< ArrayList<String> >();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			br.readLine(); //Leemos el titulo
			String line = "";
			while ((line = br.readLine()) != null) {
				ArrayList<String> ll = new ArrayList<String>();
				String[] llsplit = line.split("\\s+");
				for (int i=0; i<3; i++) {
					ll.add(llsplit[i]);
				}
				l.add(ll);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	

}
