package com.prop.domini;

public class CodeBreaker extends Jugador {
	Algorisme algorisme;
	boolean CPU;
	
	public CodeBreaker(boolean CPU) {
		super(CPU);
		this.CPU = CPU;
	}
	
	public Algorisme getalgorisme(){
		return this.algorisme;
	}
	
	public void setalgorisme(Algorisme algorisme) {
		this.algorisme = algorisme;
	}
	
}