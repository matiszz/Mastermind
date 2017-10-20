

public class Jugador {
	String idJugador; //identificador de la clase
	int partidesJugades;
	int partidesGuanyades;
	
	public Jugador(String idJugador, int partidesJugades, int partidesGuanyades) {
		this.idJugador = idJugador;
		this.nomJugador = nomJugador;
		this.partidesJugades = partidesJugades;
		this.partidesGuanyades = partidesGuanyades;
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