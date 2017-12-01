package com.prop.domini;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class RankingTest {

	

	@Test
	void c_getrankings(ArrayList<FilaRanking>facil, ArrayList<FilaRanking>medio, ArrayList<FilaRanking>dificil) {
		FilaRanking f = new FilaRanking(3,"pep");
		ArrayList<FilaRanking> r_facil = new ArrayList<FilaRanking>();
		ArrayList<FilaRanking> r_medio = new ArrayList<FilaRanking>();
		ArrayList<FilaRanking> r_dificil =  new ArrayList<FilaRanking>();
		r_medio.add(f);
		r_facil.add(f);
		r_dificil.add(f);
		
		Ranking r = new Ranking();
		assertNull(r, "Ranking r no creat");
		assertNull(facil, "Arraylist de facil es null");
		assertNull(medio, "Arraylist de medio es null");
		assertNull(dificil, "Arraylist de dificil es null");
			
		r.getrankings(facil, medio, dificil);
			
		assertEquals(r_facil, facil, "r_facil asignado");
		assertEquals(r_medio, medio, "r_medio asignado");
		assertEquals(r_dificil, dificil, "r_dificil asignado");
	}
	
	@Test
	void c_setrankings(ArrayList<FilaRanking>facil, ArrayList<FilaRanking>medio, ArrayList<FilaRanking>dificil){
		Ranking r = new Ranking();
		r.setrankings(facil, medio, dificil);
		ArrayList<FilaRanking>facil2 = new ArrayList<FilaRanking>();
		ArrayList<FilaRanking>medio2 = new ArrayList<FilaRanking>();;
		ArrayList<FilaRanking>dificil2 = new ArrayList<FilaRanking>();;
		r.getrankings(facil2, medio2, dificil2);
		assertNotEquals(facil2,facil,"el ranking facil no es igual");
		assertNotEquals(medio2,facil,"el ranking facil no es igual");
		assertNotEquals(dificil2,facil,"el ranking facil no es igual");
	}
	
	@Test
	void c_ranking_buit(int dificultat) {
		assertNull(dificultat, "dificultat es null");
		Ranking ranking = new Ranking();
		assertEquals(true,ranking.ranking_buit(dificultat),"el ranking ha d'estar buit");
	}
	
	void c_afegeix_fila(FilaRanking f, int dificultat) {
		assertNull(dificultat, "dificultat es null");
		assertNull(f, "filaranking buida");
		Ranking r = new Ranking();
		r.afegeix_fila(f,dificultat);
		boolean p = r.ranking_buit(dificultat);
		assertEquals(true,p, "no s'ha inserit la fila correctament");
	}
	
}
