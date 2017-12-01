package com.prop.domini;

import java.util.ArrayList;
import java.util.Arrays;

/* Clase hecha por Mati */

public class Tauler {
    int numFiles;
    int numColumnes;
    int ultimaPlena;
    ArrayList<ArrayList<Integer>> tauler;
    ArrayList<Integer> codiSecret;

    public Tauler(int numFiles, int numColumnes) {
        this.numFiles = numFiles;
        this.numColumnes = numColumnes;
        ultimaPlena = 0;
        tauler = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numFiles; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int j = 0; j < numColumnes; j++) {
				tmp.add(0);
			}
			tauler.add(tmp);
		}
    }

    /*
    Afegeix una combinació al tauler.
        -> Li passem el número de fila (coemnçant per 0) i un vector de chars amb la combinació.
        <- Retorna 0 si la entrada no és la esperada, 1 si el tauler està ple.
           Si no hi ha errors, retorna el tauler amb la nova fila afegida.
    */
    public ArrayList<ArrayList<Integer>> afegirCombinacio(ArrayList<Integer> combinacio) {
    	tauler.set(ultimaPlena, combinacio);
        ultimaPlena++;
        return tauler;
    }

    /*
    Indica quantes files queden lliures
        <- Retorna el número de files que queden vuides.
    */
    public int quantesQueden() {
        return numFiles-ultimaPlena;
    }

    /*
    Imprimeix l'estat actual del tauler.
    */
    public void printTauler() {
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                System.out.print(""+ tauler.get(i).get(j) + ' ');
            }
            System.out.println();
        }
    }

    /* ############################################################################# */
    /* ############################# Getters i Setters ############################# */
    /* ############################################################################# */

    public int getUltimaPlena() {
        return ultimaPlena;
    }

    public ArrayList<Integer> getCodiSecret() {
        return codiSecret;
    }

    public void setCodiSecret(ArrayList<Integer> codiSecret) {
        this.codiSecret = codiSecret;
    }

    public ArrayList<ArrayList<Integer>> getTauler() {
        return tauler;
    }

    public int getNumFiles() {
        return numFiles;
    }

    public void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }

    public int getNumColumnes() {
        return numColumnes;
    }

    public void setNumColumnes(int numColumnes) {
        this.numColumnes = numColumnes;
    }
}