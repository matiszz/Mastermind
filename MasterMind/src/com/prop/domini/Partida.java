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
    boolean finalitzada;
    int dificultat; //Cal mantenir la dificultat de la partida, inicialitzarla i actualitzarla
    ArrayList<Jugada> jugades;
    ArrayList<Integer> codiamagat; //Codi amagat, cal revisar al actualizarlo,inicializarlo etc
    boolean guanyada; //Cak inicialitzar i mantenir l'atribut, serà true si ha encertat en menys intents de les maximes
    Rellotge clock;
    Tauler tauler;

    public ArrayList<String> converteixaString() { //Converteix a un vector d'String la informacio de la partida, cada posicio es un camp d'informacio de la partida per emmagatzemarla
    		ArrayList<String> s = new ArrayList<String>();
    		s.add(Integer.toString(this.idPartida));
    		s.add(mode);
    		s.add(Long.toString(temps));
    		s.add(Integer.toString(this.numJugades));
    		s.add(Integer.toString(this.puntuacio));
    		s.add(Integer.toString(this.numFiles));
    		s.add(Integer.toString(this.longCodi));
    		s.add(Boolean.toString(this.finalitzada));
    		s.add(Integer.toString(this.dificultat));
    		for(int i = 0; i < jugades.size();++i) {
    			String l = (jugades.get(i)).converteix_a_string();
    			s.add(l);  
    		}
    		String codi = "";
    		for(int i = 0; i < longCodi;++i) {
    			codi+=Integer.toString(codiamagat.get(i));
    		}
    		s.add(codi);
    		s.add(Boolean.toString(this.guanyada));
     	return s;
    }
    public boolean getguanyada() {
    		return this.guanyada;
    }
    
    public ArrayList<Integer> getCodiamagat(){
    		return this.codiamagat;
    }
    
    public int getdificultat() {
    		return this.dificultat;
    }
    
    public void setJugades(ArrayList<Jugada> r) {
    		this.jugades = r;
    }
    public Partida(int idPartida, String mode, boolean fin, int numFiles, int longCodi,int dificultat) {
        this.idPartida = idPartida;
        this.mode = mode;
        this.temps = 0;
        this.numJugades = 0;
        this.puntuacio = 0;
        this.finalitzada = fin;
        this.numFiles = numFiles;
        this.longCodi = longCodi;
        clock = new Rellotge();
        jugades = new ArrayList<Jugada>();
        tauler = new Tauler(numFiles, longCodi);
        guanyada = false;
        this.dificultat = dificultat;
    }
    
    public void ferJugada(Jugada j) {
    	jugades.add(j);
    	tauler.afegirCombinacio(j.codiProposat);
    	puntuacio++;
        numJugades++;
    }

    public void guardarPartida() {
        temps = clock.aturarRellotge();
        finalitzada = false;
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
    
    public int finalitzarPartida() {
    	finalitzada = true;
    	return puntuacio;
    }

    /* ############################################################################# */
    /* ############################# Getters i Setters ############################# */
    /* ############################################################################# */

    public void setCodiAmagat(ArrayList<Integer> c) {
        this.codiamagat = c;
    }
    
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
        return finalitzada;
    }

    public void setEstat(boolean estat) {
        this.finalitzada = estat;
    }
}