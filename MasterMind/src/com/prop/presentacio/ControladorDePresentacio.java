package com.prop.presentacio;
import com.prop.domini.ControladorDeDomini;

public class ControladorDePresentacio {
	
	ControladorDeDomini c;
	String nom;
	
	public ControladorDePresentacio() {
		this.c = new ControladorDeDomini(this);
		nom = null;
	}
	
	public void mostra_tauler(String[] partida) {};
	
	public void mostra_menuprincipal() {};
	
	public void obteseleccionada(String idpartida) {//Obté la partida identificada per idpartida y mostra el tauler en l'estat guardat
		
		
		//Obtiene los datos de la partida, instancia vista partida y le pasa la información para rellenar la vista.
	};
	
	public void afegeix_codi_respost(String[] codirespost) {//Mostra el codi repost(vector d'strings) en la vista del tauler
	
	};
	
	public boolean click_registrarse(String alies) { //retorna true si s'ha creat el jugador, retorna false si ja exiteix
		nom = alies;
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
	public String[] demana_ranking() { //Demana el ranking a la capa de domini i dona el format necessari per mostrar-ho per pantalla
		String[] ranking = new String[2];
		ranking[0]="1.  Ro  23";
		ranking[1]="2.  Pep 40";
		
		//ranking = c.consultar_ranking();
		return ranking;
	}
	public String[] getIdPartidesGuardades() {//Demana al controlador de domini els id's de les partides guardades.
		return c.getIdPartidesGuardades(nom);
	}
	
	public String [] ferJugada(int[] codi) { 
		/*La vista li pasa la jugada proposada i el controlador avisa a la capa de domini per que computi la jugada i obtingui la
		/* resposta a mostrar */
		//vector de int's ja que el codi del domini ho demana aixi!!!!!!
		
	}
}
