package com.prop.presentacio;
import java.util.ArrayList;
import com.prop.domini.ControladorDeDomini;

public class ControladorDePresentacio {
	
	private ControladorDeDomini c;
	private String nom;
        public static ControladorDePresentacio controller = new ControladorDePresentacio();
        
        // Constructor
	public ControladorDePresentacio() {
            this.c = new ControladorDeDomini(this);
            nom = null;
            MenuPrincipal principal = new MenuPrincipal();
	}
	
        //Obté la partida identificada per idPartida y mostra el tauler en l'estat guardat.
	public void obtePartidaSeleccionada(String idPartida) {
            //Obtiene los datos de la partida, instancia vista partida y le pasa la información para rellenar la vista.
	}
	
        // Retorna true si alies existeix, i false en cas contrari.
	public boolean clickIniciarSessio(String alies) {
            return c.iniciasessio(alies);
	}
	
        // Si s'ha creat retorna true. Si alies ja existeix, retorna false.
	public boolean clickRegistrarse(String alies) { 
            return c.registrar(alies);	
	}
	
        // Afegeix a la vista la resposta lògica al codi que s'ha proposat.
	public void mostraCodiRespost(String[] codi) {
            
	}
        
        // Posa les combinacions d'una partida guardada al tauler gràfic.
	public void mostraTauler(ArrayList<String> partida) {
            
	}
        
        // Mostra el Menú Principal.
	public void mostraMenuPrincipal() {
            
	}
        
        // Afegeix una nova jugada a la vista de la partida en mode codeMaker (automàtic).
	public void jugadaCompleta(ArrayList<Integer> codirespost, ArrayList<Integer> codiproposat) {
            
	}
	
        // Interactua amb l'usuari. Espera a que jugui, i desencadena el processament de la jugada.
	public void jugaCodeBreaker() {
            
	}
        
        // Obté les dades per restaurar una partida, i la mostra al tauler.
	public void restauraPartida(String idPartida) { 
            c.continuarPartida(idPartida);
	}
	
        // Crea una partida amb Mode = mode y Dificultat = dificultat
	public void crearPartida(String mode, String dificultat) {
            int dif;
           
            if ("facil".equals(dificultat))         dif = 1;
            else if ("mitjana".equals(dificultat))  dif = 2;
            else dif = 3;
            
            boolean b = ("CodeMaker".equals(mode));
            
            c.generarJoc(dif, b);
	}

        // Obté el Ranking de la capa de domini i el formateja.
	public ArrayList<String> demanaRanking() {
            ArrayList<String> ranking = new ArrayList<String>();// = c.consultarRanking();
            ranking.add("1.   Pep 23");
            ranking.add("2.   Joan 45");
            ranking.add("3.   Mati 60");
            return ranking;
	}
        
        // Obté les els IDs de les partides guardades de la capa de domini.
	public ArrayList<String> getIdPartidesGuardades() {
            return c.getIdPartidesGuardades(nom);
	}
	
        // Desde la vista s'envia el codi proposat (en forma d'INTs) i avisa a la 
        // capa de domini per computar la jugada i obtenir la resposta a mostrar
	public void ferJugada(int[] codi) {
            c.ferJugada(codi);
	}
        
        // Per al mode CodeMaker, estableix el codi a endevnar.
        public void setCodi(int[] codi) {
            c.emmagatzemaCodi(codi);
        }
}
