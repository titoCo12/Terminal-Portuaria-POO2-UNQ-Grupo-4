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
	/*
	public void entregarCarga(Terminal terminal, Orden orden, Camion camion) {
		//Le agrego a la terminal el container con la orden y saco la carga con esa orden de la lista
		terminal.recibirContainer(orden.getContainer());
		dejarCarga(orden.getContainer());
	}
	
	public void recibirCarga(Container container) {
		carga.add(container);
	}
	
	public void dejarCarga(Container container) {
		carga.remove(container);
	}
	*/
	public String getPatente() {
		return matricula;
	}
}
