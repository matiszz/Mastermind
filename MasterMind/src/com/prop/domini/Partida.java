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
    boolean estat;
    ArrayList<Jugada> jugades;
    Rellotge clock;

    public Partida(int idPartida, String mode, int temps, int numJugades, int puntuacio, boolean estat) {
        this.idPartida = idPartida;
        this.mode = mode;
        this.temps = temps;
        this.numJugades = numJugades;
        this.puntuacio = puntuacio;
        this.estat = estat;
        clock = new Rellotge();
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