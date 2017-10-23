package com.prop.domini;
/* Clase hecha por Mati */


import java.util.*;

impimport Jugador;
ort com.prop.domini{
    String idJugador;
    ArrayList<*Jugador> jugadors = new ArrayList<*Jugadors>;;

    /*
        Registra un jugador. Si existeix, retorna tots els jugadors.
        -> String idJugador
        <- Es crea el jugador i es retorna un ArrayList de *jugadors. Si ja existia, no es crea.
     */
    public ArrayList<*Jugador> registrar(String idJugador) {
        for (int i = 0; i < jugadors.size(); i++) {

            Jugador tmp = jugadors.get(i);
            if (Jugador.getIdJugador() == idJugador)
                return jugadors;
            else {
                Jugador nou = new Jugador(idJugador, 0, 0);
                jugadors.add(nou);
                return jugdors;
            }
        }
    }

    public ArrayList<*Jugador> getJugadors() {
        return jugadors;
    }
}