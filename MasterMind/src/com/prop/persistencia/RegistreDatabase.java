package com.prop.persistencia;

import com.prop.domini.Jugador;

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
			System.out.println("Ja existeix la Base de Dades");
		}
		else {
			try {
				file = new File(nom);
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Registre de Jugadors de MasterMind");
				bw.newLine();
				bw.flush();
				bw.close();
				
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				line = br.readLine();
				System.out.println(line);
				br.close();
				
				System.out.println("Base de Dades creada correctament");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Afegir un jugador al registre */
	/* Si no existe el jugador lo añade a la BD, si existe no hace nada */
	public void afegirJugador(Jugador j) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			Scanner sc = new Scanner(file); //buscamos si existe el jugador en la base de datos
			sc.nextLine(); //saltamos la primera línea ya que es el título
			Boolean found = false;
			while (sc.hasNextLine() && found.equals(false)) {
				String line = sc.nextLine();
				if (line.contains(j.getIdJugador()))
					found = true;
			}
			sc.close();
			if (found.equals(false)) { //se puede hacer una excepción personalizada para que salte si ya existe el jugador pero que palo
				fw = new FileWriter(file,true); //true es para activar el append para que no sobreescriba lo que había
				bw = new BufferedWriter(fw);
				bw.write(j.getIdJugador() + " " + j.getPartidesJugades() + " " + j.getPartidesGuanyades());
				bw.newLine(); //nueva línea
				bw.flush();
				bw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
