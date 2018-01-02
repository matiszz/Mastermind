package com.prop.domini;

import java.util.ArrayList;

public class Registre {

    ArrayList<Jugador> jugadors;

    public Registre() {
        jugadors = new ArrayList<Jugador>();
    }

    /*
	Registra un jugador i l'afegeix al ArrayList de Jugadors.
     */
    public Jugador registrar(String idJugador) {
        Jugador nou = new Jugador(idJugador, 0, 0);
        jugadors.add(nou);
        return nou;
    }

    /*
	Obté tota la llista de jugadors.
            <- Retrona un ArrayList de Jugadors
     */
    public ArrayList<Jugador> getJugadors() {
        return jugadors;
    }

    /*
	Retorna un jugador.
            -> String idJugador d'un jugador existent
            <- Retorna el jugador amb identificador idJugador
     */
    public Jugador getJugador(String idJugador) {
        boolean trobat = false;
        Jugador tmp = null;
        for (int i = 0; i < jugadors.size() && !trobat; ++i) {
            tmp = jugadors.get(i);
            System.out.println("Jugador " + tmp.getIdJugador());
            if (tmp.getIdJugador().equals(idJugador)) {
                trobat = true;
            }
        }
        if (trobat) {
            System.out.println("Jugador " + idJugador + " encontrado");
            return tmp;
        } else {
            System.out.println("Jugador " + idJugador + " no encontrado");
            return null;
        }
    }
    
    public void setJugadors(ArrayList<Jugador> j) {
    	jugadors = j;
    }
}
