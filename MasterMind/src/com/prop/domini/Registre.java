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
		<- Es crea el jugador i es retorna un ArrayList de jugadors. Si ja existia, no es crea.
	*/
	public Jugador registrar(String idJugador) {
		boolean trobat = false;
		for (int i = 0; i < jugadors.size() && !trobat; ++i) {
			Jugador tmp = jugadors.get(i);
			if (tmp.getIdJugador().equals(idJugador)) {
				trobat = true;
			}
		}
		if (trobat) {
			return null;
		}
		else {
			Jugador nou = new Jugador(idJugador, 0, 0);
			jugadors.add(nou);
			return nou;
		}
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
			if (tmp.getIdJugador().equals(idJugador)) {
				trobat = true;
			}
		}
		if (trobat) return tmp;
		else return null;
	}
}
