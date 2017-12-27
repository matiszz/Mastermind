package com.prop.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	/* Si no existe el jugador lo añade a la BD, si existe no hace nada */
	public void emmagatzemaJugador(String[] info) { //info[0] = idJugador, info[1] = partidesJugades, info[2] = partidesGuanyades
		FileWriter fw;
		BufferedWriter bw;
		try {
			Scanner sc = new Scanner(file); //buscamos si existe el jugador en la base de datos
			sc.nextLine(); //saltamos la primera linea ya que es el titulo
			Boolean found = false;
			while (sc.hasNextLine() && found.equals(false)) {
				String line = sc.nextLine();
				if (line.contains(info[0]))
					found = true;
			}
			sc.close();
			if (found.equals(false)) { //se puede hacer una excepcion personalizada para que salte si ya existe el jugador pero que palo
				fw = new FileWriter(file,true); //true es para activar el append para que no sobreescriba lo que hab�a
				bw = new BufferedWriter(fw);
				bw.write(info[0] + " " + info[1] + " " + info[2]);
				bw.newLine(); //nueva linea
				bw.flush();
				bw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

}
