package com.prop.presentacio;

public class ControladorDePresentacio {
	
	public void mostra_tauler(String[] partida) {};
	
	public void mostra_menuprincipal() {};
	
	public int obteseleccionada() {
		int d = 4;
		return d;
	};
	
	public String[] mostra_partides_disponibles(String[][] infopartides) {
		int opcioseleccionada = obteseleccionada();
		return infopartides[opcioseleccionada];
	};
	
	public void afegeix_codi_respost(String[] codirespost) {};//Mostra el codi repost(vector d'strings) en la vista del tauler
	
	public boolean click_registrarse(String alies) { //retorna true si s'ha creat el jugador, retorna false si ja exiteix
		boolean b = false;
		return b;
	};
	
	public void crear_partida(String mode, String dificultat) {
		switch(dificultat) { //Crida al controlador de domini indicant el mode de partida i la dificultat de la partida
			case "Facil":
				
			break;
			case "Mitjana":
				
			break;
			case "Dificil":
		}
	}
}
