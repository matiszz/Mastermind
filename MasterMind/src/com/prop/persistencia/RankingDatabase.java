package com.prop.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RankingDatabase extends Database {
	private File file;
	
	public RankingDatabase(String nom) {
		super(nom);
	}
	
	public File getRegistreDatabaseFile() {
		return file;
	}
	
	public void crearDatabase() {
		file = new File(nom);
		if (file.exists()) {
			System.out.println("Ja existeix la base de dades del ranking");
		}
		else {
			try {
				file = new File(nom);
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Ranking de MasterMind");
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
	
	public ArrayList<String> obtenirRanking() {
		ArrayList<String> l = new ArrayList<String>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String aux = br.readLine(); //saltamos el titulo
			String line = "";
			while ((line = br.readLine()) != null) {
				l.add(line); //leo una linea y la añado al arraylist hasta que llegue al final de fichero
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
	
	public void emmagatzemaRanking(ArrayList<String> ranking) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(file)); //no activamos el append ya que cada vez que se guarde el ranking se guardara todo de nuevo
			bw.write("Ranking de MasterMind");
			bw.newLine();
			for (int i=0; i<ranking.size(); i++) {
				bw.write(ranking.get(i));
				if (i != ranking.size() -1) { //para no escribir un salto de linea al final
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
