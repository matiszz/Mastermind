package com.prop.domini;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
	//Driver clase Algorisme i Controlador de Domini

	public static void main (String args[]) {
		System.out.println("Benvingut a Mastermind! Selecciona una de les següents opcions:");
		System.out.println("0. Surt del driver");
		System.out.println("1. Algorisme basic");
		
		
		
		Scanner lector = new Scanner(System.in);
		
	
		
		char c;
		try{
			while ((c=(char)System.in.read()) != '0' ){
				switch(c) {
					case '1':
						Algorisme a = new Algorisme();
						System.out.println("Introdueix el nombre de columnes");
						int columnes = lector.nextInt();
						ArrayList<Character> colors = new ArrayList<Character>();
						colors.add('G');
						colors.add('V');
						a.basic(columnes, colors);
					break;
				}
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
			
	
	}
}
