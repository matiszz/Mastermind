package com.prop.presentacio;
import java.util.ArrayList;

import com.prop.domini.ControladorDeDomini;

public class ControladorDePresentacio {
	
	ControladorDeDomini c;
	String nom;
	
	public ControladorDePresentacio() {
		this.c = new ControladorDeDomini(this);
		nom = null;
		VistaMenuPrincipal principal = new VistaMenuPrincipal();
	}
	
	
	
	public void obteseleccionada(String idpartida) {//Obté la partida identificada per idpartida y mostra el tauler en l'estat guardat
		
		//Obtiene los datos de la partida, instancia vista partida y le pasa la información para rellenar la vista.
	};
		
	public boolean clickIniciarSessio(String alies) { //Fals si no existeix, true si existeix.
		return c.iniciasessio(alies);
	}
	
	public boolean clickRegistrarse(String alies) { //retorna true si s'ha creat el jugador, retorna false si ja exiteix
		return c.registrar(alies);	
	};
	
	public void mostraCodiRespost(String[] codi) {//Afegeix a la vista actual la resposta al codiproposat en la ultima jugada computada
		
	}
	public void mostraTauler(ArrayList<String> partida) {//Se li pasa tota la partida i selecciona les jugadas per restaurar-les (mostrar-les per pantalla)
		
	};
	public void mostraMenuPrincipal() {
		
		
		
	}
	public void jugadaCompleta(ArrayList<Integer> codirespost, ArrayList<Integer> codiproposat) { 
		//Afegeix una nova jugada computada a la vista de la partida quan es juga en mode codeMaker(automàtic)
		
	}
	
	public void jugaCodeBreaker() { // es la funcion que va interactuando con el usuario, va esperandoa a que juegue y desencadena el procesmiento de la jugada
		
	}
	public void restauraPartida(String idPartida) { //Obte tot el necessari per restaurar la partida i mostrar el tauler.
		c.continuarPartida(idPartida);
	}
	
	public void crearPartida(String mode, String dificultat) {
		int dif;
		if(dificultat == "facil") dif = 1;
		if(dificultat == "mitjana") dif = 2;
		else dif = 3;
		boolean b = (mode =="CodeMaker");
		c.generarJoc(dif,b);
	}

	public ArrayList<String> demanaRanking() { //Demana el ranking a la capa de domini i dona el format necessari per mostrar-ho per pantalla
		/*Pruebas 
		 * String[] ranking = new String[2];
		 ranking[0]="1.  Ro  23";
		 ranking[1]="2.  Pep 40";
		 */
		ArrayList<String> ranking = c.consultar_ranking();
		return ranking;
	}

	public ArrayList<String> getIdPartidesGuardades() {//Demana al controlador de domini els id's de les partides guardades.
		return c.getIdPartidesGuardades(nom);
	}
	
	public void ferJugada(int[] codi) { 
		/*La vista li pasa la jugada proposada i el controlador avisa a la capa de domini per que computi la jugada i obtingui la
		/* resposta a mostrar */
		//vector de int's ja que el codi del domini ho demana aixi!!!!!!
		c.ferJugada(codi);
	}
}
