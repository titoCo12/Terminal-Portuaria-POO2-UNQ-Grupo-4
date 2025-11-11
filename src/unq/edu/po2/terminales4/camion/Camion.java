package unq.edu.po2.terminales4.camion;

import unq.edu.po2.chofer.Chofer;

public class Camion {
	
	String matricula;
	Chofer chofer;
	
	public Camion(String matricula, Chofer chofer) {
		this.matricula = matricula;
		this.chofer = chofer;
	}
	
	public Chofer getChofer() {
		return chofer;
	}

	public String getPatente() {
		return matricula;
	}
}
