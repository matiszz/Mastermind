package com.prop.domini;

public class Jugador {
    String idJugador; //identificador de la clase
    int partidesJugades;
    int partidesGuanyades;

    boolean CPU;

    public String converteixaString() {
    		String s = "";
    		return s;
    }
    public void actualitzar_partides(int puntuacio) {
    		
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