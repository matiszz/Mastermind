package com.prop.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartidesDatabase extends Database {
	private File file;
	
	public PartidesDatabase(String nom) {
		super(nom);
	}
	
	public File getRegistreDatabaseFile() {
		return file;
	}
	
	public void crearDatabase() {
		file = new File(nom);
		if (file.exists()) {
			System.out.println("Ja existeix la base de dades de les partides");
		}
		else {
			try {
				file = new File(nom);
				file.createNewFile();
				/*
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Partides guardades de MasterMind");
				bw.newLine();
				bw.flush();
				bw.close();
				
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				line = br.readLine();
				System.out.println(line);
				br.close();
				*/
				
				System.out.println("Base de dades creada correctament");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Busca primero si existe el idPartida que se le pasa, si esta, borra esa partida
	 * y almacena la nueva que se le pasa, sino, solo almacena la nueva que se le pasa
	 */
	public void emmagatzemaPartida(String[] info, String idJugador) {
		FileWriter fw;
		BufferedWriter bw;
		//seekAndDestroy(info, info[0]);
		try {
			System.out.println("IDPartida a encontrar " + info[0]);
			seekAndDestroy(info, info[0]);
			fw = new FileWriter(file,true); //true es para activar el append para que no sobreescriba lo que hab�a
			bw = new BufferedWriter(fw);
			
			bw.write(idJugador);
			bw.newLine();
			for (int i=0; i<11; i++) {
				bw.write(info[i]);
				bw.newLine();
			}
			bw.newLine();
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void seekAndDestroy(String info[], String idPartida) {
		FileWriter fw3;
		BufferedReader br;
		boolean found = false;
		try {
			System.out.println("Entro1 con el idPartida " + info[0] + " " + idPartida);
			fw3 = new FileWriter(file,true); //true es para activar el append para que no sobreescriba lo que hab�a
			br = new BufferedReader(new FileReader(file));
			String line = "";
			int mark = 0;
			
			while(((line = br.readLine()) != null) && found == false) {
				System.out.println(line);
				if (line.equals(idPartida)) {
					found = true;
					mark++;
					System.out.println("id " + line + " trobat a la linia " + mark);
				}
				else
					mark++;
			}
			fw3.flush();
			fw3.close();
			br.close();
			
			System.out.println("El booleano found es " + found);
			
			if (found) {
				int firstLine = mark - 1;
				int lastLine = firstLine + 11;
				System.out.println("FirstLine vale " + firstLine);
				System.out.println("LastLine vale " + lastLine);
				
				File temp = new File("temp.txt");
				FileWriter fw2 = new FileWriter(temp);
				BufferedWriter bw = new BufferedWriter(fw2);
				
				BufferedReader buff = new BufferedReader(new FileReader(file));
				
				String line4 = "";
				int lineReaded = 1;
				while ((line4 = buff.readLine()) != null) {
					System.out.println("Leyendo la linea " + lineReaded + " : " + line4);
					if (lineReaded < firstLine -1 || lineReaded > lastLine) {
						System.out.println("Escribiendo la linea " + lineReaded + " : " + line4);
						bw.write(line4);
						bw.newLine();
					}
					lineReaded++;
				}
				
				/*
				//Copiar el contenido de temp en Partides.txt
				FileWriter fw4 = new FileWriter(file,true);
				BufferedWriter bw4 = new BufferedWriter(fw4);
				
				BufferedReader buff2 = new BufferedReader(new FileReader(temp));
				
				System.out.println("Holaaaa: " + buff2.readLine());
				
				String line5 = "";
				while ((line5 = buff2.readLine()) != null) {
					System.out.println("Linea del temp que leo: " + line5);
					bw4.write(line5);
				}
				*/
				
				bw.close();
				buff.close();
				fw2.close();
				//buff2.close();
				//fw4.close();
				//bw4.close();
				temp.renameTo(file);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
