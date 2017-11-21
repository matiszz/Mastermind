package com.prop.persistencia;

import com.prop.domini.Jugador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	public void afegirJugador(Jugador j) { //aun ha de comprobar bastantes cosas
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write(j.getIdJugador() + " " + j.getPartidesJugades() + " " + j.getPartidesGuanyades());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
