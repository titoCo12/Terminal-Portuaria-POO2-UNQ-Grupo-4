package unq.edu.po2.terminales4.camion;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.terminales4.orden.Orden;
import unq.edu.po2.terminales4.terminal.Terminal;

public class Camion {
	
	String matricula;
	Chofer chofer;
	Orden orden;
	Terminal terminal;
	
	public Camion(String matricula, Chofer chofer, Orden orden, Terminal terminal) {
		this.matricula = matricula;
		this.chofer = chofer;
		this.orden = orden;
		this.terminal = terminal;
	}
	
	public Chofer getChofer() {
		return chofer;
	}
	public void entregarCarga(Orden orden, Camion camion) {
		terminal.llegadaDeCamion(orden, this);
	}
	public String getPatente() {
		return matricula;
	}
}
