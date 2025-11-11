package unq.edu.po2.terminales4.circuito;

import java.util.ArrayList;

import unq.edu.po2.terminales4.posicion.Puerto;

public class Circuito {

	private ArrayList<Tramo> tramos;
	private Puerto inicio;
	private Puerto fin;

	public Circuito(String nombreCircuito, Puerto puertoInicial) {
		this.tramos = new ArrayList<Tramo>();
		this.inicio = puertoInicial;
		this.fin = puertoInicial;
	}

	public Object getOrigen() {
		// TODO Auto-generated method stub
		return this.inicio;
	}

}
