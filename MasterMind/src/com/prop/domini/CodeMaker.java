package com.prop.domini;

public class CodeMaker extends Jugador {
	
	boolean CPU; // fals = jugador, cert = CPU
	
	public CodeMaker(boolean CPU) {
		super(CPU);
		this.CPU = CPU;
	}
	
	public boolean isCPU() {
		return CPU;
	}

	public void setCPU(boolean CPU) {
		this.CPU = CPU;
	}
	
}
