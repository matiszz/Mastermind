package com.prop.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Database {
	String nom, line;
	
	public Database(String nom) {
		this.nom = nom;
	}
	
	public void createDatabase() {
		File file = new File(nom);
		if (file.exists()) {
			System.out.println("Ja existeix la Base de Dades");
		}
		else {
			try {
				file = new File(nom);
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Base de Dades de MasterMind");
				bw.flush();
				bw.close();
				
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				line = br.readLine();
				System.out.println(line);
				br.close();
				
				/*while ((line = br.readLine()) != null) {
					System.out.print(line);
				}
				br.close();*/
				
				System.out.println("Base de Dades creada correctament");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
