package com.prop.domini;
/* Clase hecha por Mati */


import java.lang.System.*;

public class Tauler {
    int numFiles;
    int numColumnes;
    int ultimaPlena;
    char[][] tauler;
    char[] codiSecret;

    public Tauler(int numFiles, int numColumnes) {
        this.numFiles = numFiles;
        this.numColumnes = numColumnes;
        ultimaPlena = -1;
        tauler = new char[numFiles][numColumnes];
    }

    /*
        Afegeix una combinació al tauler.
        -> Li passem el número de fila (coemnçant per 0) i un vector de chars amb la combinació.
        <- Retorna 0 si la entrada no és la esperada, 1 si el tauler està ple.
           Si no hi ha errors, retorna el tauler amb la nova fila afegida.
     */
    public char[][] afegirCombinacio(int fila, char[] combinacio) {
        if (combinacio.size() != numColumnes) // Si la entrada no és la esperada
            return 0;
        if (fila > numFiles) // Si ja hem ocupat totes les files
            return  1;

        for (int i = 0; i < numColumnes; i++) {
            tauler[fila][i] = combinacio[i];
        }
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
                System.out.print(tauler[i][j] + ' ');
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

    public char[] getCodiSecret() {
        return codiSecret;
    }

    public void setCodiSecret(char[] codiSecret) {
        this.codiSecret = codiSecret;
    }

    public char[][] getTauler() {
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