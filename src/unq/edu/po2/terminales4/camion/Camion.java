package unq.edu.po2.terminales4.camion;

import java.util.ArrayList;
import java.util.List;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.container.*;
import unq.edu.po2.terminales4.orden.Orden;
import unq.edu.po2.terminales4.terminal.Terminal;

public class Camion {
	
	String matricula;
	Chofer chofer;
	//List<Container> carga; //¿O uno sola?
	
	public Camion(String matricula, Chofer chofer) {
		this.matricula = matricula;
		this.chofer = chofer;
		//this.carga = new ArrayList<>();
	}
	
	public Chofer getChofer() {
		return chofer;
	}
	public void entregarCarga(Terminal terminal) {
		terminal.llegadaDeCamion(o);
	}
	public String getPatente() {
		return matricula;
	}
}
