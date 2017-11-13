package com.prop.domini;
/* Clase hecha por Mati */

import java.util.*;
import com.prop.domini.*;
import com.prop.persistencia.*;

public class Partida {

    int idPartida;
    String mode;
    long temps;
    int numJugades;
    int puntuacio;
    int numFiles;
    int longCodi;
    boolean estat;
    ArrayList<Jugada> jugades;
    Rellotge clock;
    Tauler tauler;

    public Partida(int idPartida, String mode, boolean estat, int numFiles, int longCodi) {
        this.idPartida = idPartida;
        this.mode = mode;
        this.temps = 0;
        this.numJugades = 0;
        this.puntuacio = 0;
        this.estat = estat;
        this.numFiles = numFiles;
        this.longCodi = longCodi;
        clock = new Rellotge();
        jugades = new ArrayList<Jugada>();
        tauler = new Tauler(numFiles, longCodi);
    }
    
    public void ferJugada(Jugada j) {
    	jugades.add(j);
    	tauler.afegirCombinacio(j.codiProposat);
    }

    public void guardarPartida() {
        temps = clock.aturarRellotge();
    }

    public void iniciarPartida() {
        clock.iniciarRellotge();
    }

    public void reanudaPartida() {
        clock.continuarRellotge(temps);
    }
    
    public void estatTauler() {
    	tauler.printTauler();
    }

    /* ############################################################################# */
    /* ############################# Getters i Setters ############################# */
    /* ############################################################################# */

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getNumJugades() {
        return numJugades;
    }

    public void setNumJugades(int numJugades) {
        this.numJugades = numJugades;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }
}