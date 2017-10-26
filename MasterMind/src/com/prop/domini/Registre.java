package com.prop.domini;

import java.util.ArrayList;

public class Registre {
	 ArrayList<Jugador> jugadors;

	    public Registre() {
	        jugadors = new ArrayList<Jugador>();
	    }

	    /*
	    Registra un jugador. Si existeix, retorna tots els jugadors.
	        -> String idJugador
	        <- Es crea el jugador i es retorna un ArrayList de *jugadors. Si ja existia, no es crea.
	     */
	    public ArrayList<Jugador> registrar(String idJugador) {
	    	boolean trobat = false;
	        for (int i = 0; i < jugadors.size() && !trobat; ++i) {
	            Jugador tmp = jugadors.get(i);
	            if (tmp.getIdJugador().equals(idJugador)) {
	            	trobat = true;
	            }
	        }
	        if (trobat) 
	        	return jugadors;
	        else {
	        	Jugador nou = new Jugador(idJugador, "juan", 0, 0);
                jugadors.add(nou);
                return jugadors;
            }
	    }

	    public ArrayList<Jugador> getJugadors() {
	        return jugadors;
	}
}
