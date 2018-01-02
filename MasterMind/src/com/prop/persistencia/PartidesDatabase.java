package com.prop.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
				
				System.out.println("Base de dades creada correctament");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Busca primero si existe el idPartida que se le pasa, si esta, borra esa partida
	 * y almacena la nueva que se le pasa, sino, solo almacena la nueva que se le pasa
	 */
	public void emmagatzemaPartida(ArrayList<String> info, String idJugador) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			seekAndDestroy(info, info.get(0)); //Buscamos y eliminamos la partida con el idPartida repetido para sobreescribirla
			fw = new FileWriter(file,true); //true es para activar el append para que no sobreescriba lo que hab�a
			bw = new BufferedWriter(fw);
			//Escribimos ahora la partida nueva a almacenar
			bw.write(idJugador);
			bw.newLine();
			for (int i=0; i<12; i++) {
				bw.write(info.get(i));
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Lo que hace es buscar la linea con el idPartida repetido, si la encuentra entonces localiza las lineas
	 * que pertenecen a esa partida y las elimina. Como las elimino? Hago un fichero temporal para copiar todas
	 * las líneas del fichero original menos las del idPartida repetido con las marcas de las lineas last y first
	 * line. Entonces al final hago que temp sea el fichero original con el mismo nombre.
	 */
	public void seekAndDestroy(ArrayList<String> info, String idPartida) {
		FileWriter fw3;
		BufferedReader br;
		boolean found = false;
		try {
			fw3 = new FileWriter(file,true); //true es para activar el append para que no sobreescriba lo que hab�a
			br = new BufferedReader(new FileReader(file));
			String line = "";
			String lineAux = ""; //auxiliar para saltar de idPartida en idPartida
			lineAux = br.readLine();
			lineAux = br.readLine(); //saltamos el titulo, y el primer idJugador
			int mark = 3; //numeroLinea
			
			//Buscamos la linea con el idPartida repetido, si no la encontramos pues se acaba la función
			while(((line = br.readLine()) != null) && found == false) {
				if (line.equals(idPartida)) {
					found = true;
				}
				else
					for (int i=0; i<12; i++) { //saltamos hasta el proximo idPartida
						lineAux = br.readLine();
						mark++;
					}
			}
			fw3.flush();
			fw3.close();
			br.close();
			
			if (found) {
				//Si la encontramos, copiamos en un fichero temporal todo lo demas menos ese idPartida repetido
				int firstLine = mark - 1; //borramos el id partida, idjugador
				int lastLine = firstLine + 13; //borramos hasta bool guanyada
				File temp = new File("temp.txt");
				FileWriter fw2 = new FileWriter(temp);
				BufferedWriter bw = new BufferedWriter(fw2);
				
				BufferedReader buff = new BufferedReader(new FileReader(file));
				
				String line4 = "";
				bw.write("Partides guardades de MasterMind");
				bw.newLine();
				int lineReaded = 2;
				while ((line4 = buff.readLine()) != null) {
					if ((lineReaded < firstLine || lineReaded > lastLine) && (line4 != null)) {
						bw.write(line4);
						bw.newLine();
					}
					lineReaded++;
				}
				
				bw.close();
				buff.close();
				fw2.close();
				temp.renameTo(file);
				/* esto es muy importante, al renombrar el fichero temp a file se elimina el fichero temp
				 * y file se sustituye por temp. Es precioso.
				 */
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Devuelve los idPartida que tenga el bool finalitzada a false y que sean de idJugador */
	public ArrayList<Integer> partidesNoFinalitzades(String idJugador) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int idPartida;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String lineAux = ""; 
			lineAux = br.readLine(); //saltamos hasta el primer idJugador
			while ((line = br.readLine()) != null) {
				if (line.equals(idJugador)) {
					idPartida = Integer.parseInt(br.readLine()); //cojo el idPartida y lo transformo a entero
					for (int i=0; i<6; i++) {
						lineAux = br.readLine(); //saltamos hasta el bool finalitzada
					}
					String fin = br.readLine(); //leemos el string bool finalitzada
					if (fin.equals("false") || fin.equals("0")) { //no se si al pasar a string un booleano lo pasa como true/false o como 1/0
						l.add(idPartida);
					}
					for (int i=0; i<4 ;i++) {
						lineAux = br.readLine(); //saltamos hasta el proximo idJugador
					}
				}
				else { //saltamos hasta el proximo idJugador
					for (int i=0; i<12; i++) {
						lineAux = br.readLine();
					}
				}
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
	
	/* Deprecated, no usar, si se usa primero hay que cambiar la gestion de espacios, ahora no hay */
	public List< List<String> > obtePartidesJugador(String idJugador) {
		List< List<String> > l = new ArrayList< List<String> >();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String lineAux = "";
			lineAux = br.readLine(); 
			lineAux = br.readLine(); //saltamos hasta el primer idJugador
			while ((line = br.readLine()) != null) {
				if (line.equals(idJugador)) {
					List<String> ll = new ArrayList<String>();
					ll.add(line); //meto el idJugador
					for (int i=0; i<12; i++) { //meto la demas info de esa partida de ese jugador
						line = br.readLine();
						ll.add(line);
					}
					l.add(ll);	
					lineAux = br.readLine();
				}
				else {
					for (int i=0; i<11; i++) { //salto hasta el proximo idJugador
						lineAux = br.readLine();
					}
				}
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
	
	/* A partir de un idPartida busca en el fichero y si lo encuentra devuelve en una lista todos los campos
	 * relacionados con esa partida en concreto */
	public ArrayList<String> getInfoPartida(String idPartida) {
		boolean found = false;
		ArrayList<String> l = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String lineAux = "";
			lineAux = br.readLine(); //leemos hasta el primer idJugador
			while((line = br.readLine()) != null && !found) {
				String idJugador = line;
				line = br.readLine(); //leemos el idPartida
				if (line.equals(idPartida)) {
					found = true;
					l.add(idJugador); //añadimos el idJugador
					l.add(line); //añadimos el idPartida
					for (int i=0; i<11; i++) {
						line = br.readLine();
						l.add(line); //añadimos el resto de los campos
					}
				}
				else {
					for (int i=0; i<11; i++) {
						lineAux = br.readLine(); //leemos hasta el proximo idJugador
					}
				}
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
	
	/* Devuelve en un arraylist todos los idPartida del jugador pasado por parámetros */
	public ArrayList<String> getIdPartidesGuardades(String idJugador) {
		ArrayList<String> l = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String lineAux = "";
			lineAux = br.readLine(); //leo el titulo del fichero
			while ((line = br.readLine()) != null) {
				if (line.equals(idJugador)) {
					l.add(br.readLine()); //añado el idPartida al arraylist si coincide el idJugador
					for (int i=0; i<11; i++) {
						lineAux = br.readLine(); //salto hasta el proximo idJugador
					}
				}
				else {
					for (int i=0; i<12; i++) {
						lineAux = br.readLine(); //salto hasta el proximo idJugador
					}
				}
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