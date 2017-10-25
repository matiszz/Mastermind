package com.prop.domini;

import java.util.ArrayList;

import com.prop.domini.*;


public class Driver2 {
	//Driver para las clases Jugador,Registre,Ranking
	
	/*
	Opciones del menú
	1. RegistrarJugador
	2. Crear Registre
	3. Consultat informacio jugador (partides jugades,guanyades,etc)
	4. Crear Ranking
	5. ConsultarRanking
	6. ActualitzarRanking
	 */
	
	public static void main (String args[]) {
			System.out.println("Benvingut a Mastermind! Selecciona una de les següents opcions:");
			System.out.println("1. Registrar un Jugador");
			System.out.println("2. Crear un Registre");
			System.out.println("3. Consultar informació d'un jugador");
			System.out.println("4. Crear un Ranking");
			System.out.println("5. Consultar el Ranking");
			System.out.println("6. Actualitzar el Ranking");
			 
		StringBuffer str=new StringBuffer();
		char c;
		try{
			Ranking r = new Ranking();
			while ((c=(char)System.in.read()) != '0' ){
				
			        	switch(c) {
			        		case '4': 
			        			r = new Ranking();
			        		break;
			        		case '5':
			        			
			        			if(r.ranking_buit(1)) System.out.println("Ranking fácil vacio, añade primero algun record");
			        			else r.mostra_ranking(1);
			        			if(r.ranking_buit(2)) System.out.println("Ranking medio vacio, añade primero algun record");
			        			else r.mostra_ranking(2);
			        			if(r.ranking_buit(2)) System.out.println("Ranking difícil vacio, añade primero algun record");
			        			else r.mostra_ranking(3);
			        		break;
			        		case '6':
			        			FilaRanking f = new FilaRanking(20,"Pepito");
			        			r.afegeix_fila(f, 1);
			        			FilaRanking f2 = new FilaRanking(1,"Pepito");
			        			r.afegeix_fila(f2, 1);
			        			FilaRanking f3 = new FilaRanking(10,"Marc");
			        			r.afegeix_fila(f3, 1);
			        		break;
			        	}
			}            
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
			   
	}
}
