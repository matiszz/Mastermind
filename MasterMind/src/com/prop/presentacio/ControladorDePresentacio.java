package com.prop.presentacio;

public class ControladorDePresentacio {
	
	public void mostra_tauler(String[] partida) {};
	
	public void mostra_menuprincipal() {};
	
	public int obteseleccionada() {};
	
	public String[] mostra_partides_disponibles(String[][] infopartides) {
		int opcioseleccionada = obteseleccionada();
		return infopartides[opcioseleccionada];
	};
	
	public void afegeix_codi_respost(String[] codirespost) {};//Mostra el codi repost(vector d'strings) en la vista del tauler
}
