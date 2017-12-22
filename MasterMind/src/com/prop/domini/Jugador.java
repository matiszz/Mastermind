package com.prop.domini;

import java.util.ArrayList;

public class Jugador {
    String idJugador; //identificador de la clase
    int partidesJugades;
    int partidesGuanyades;

    boolean CPU;

    public ArrayList<String> converteixaString() { //Converteix a un vector de String la informacio del jugador, cada posicio es un camp d'informacio del jugador
    		ArrayList<String> s = new ArrayList<String>(); 
    		s.add(this.idJugador);
    		s.add(Integer.toString(this.partidesJugades));
    		s.add(Integer.toString(this.partidesGuanyades));
    		return s;
    }
    public void actualitzar_partides(int puntuacio,boolean guanyat) { 
    	//Determina si la partida ha sigut guanyada o perduda segons la dificultat y la puntuacio(intents), actualiza partidasguanyades en cas necessari
    		if(guanyat) this.partidesGuanyades++;
    		this.partidesJugades++;
    }
    
    public Jugador(String idJugador, int partidesJugades, int partidesGuanyades) {
        this.idJugador = idJugador;
        this.partidesJugades = partidesJugades;
        this.partidesGuanyades = partidesGuanyades;
    }

    public Jugador(boolean CPU) {
        this.CPU = CPU;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public int getPartidesJugades() {
        return partidesJugades;
    }

    public void setPartidesJugades(int partidesJugades) {
        this.partidesJugades = partidesJugades;
    }

    public int getPartidesGuanyades() {
        return partidesGuanyades;
    }

    public void setPartidesGuanyades(int partidesGuanyades) {
        this.partidesGuanyades = partidesGuanyades;
    }
}