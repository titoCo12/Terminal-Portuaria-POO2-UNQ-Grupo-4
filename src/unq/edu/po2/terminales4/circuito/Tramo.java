package unq.edu.po2.terminales4.circuito;

import unq.edu.po2.terminales4.posicion.Puerto;

public class Tramo {

	private Puerto puertoOrigen;
	private Puerto puertoDestino;
	private double precio;
	private int tiempoDias;

	public Tramo(Puerto puertoOrigen, Puerto puertoDestino, double precio, int tiempoDias) {
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.precio = precio;
		this.tiempoDias = tiempoDias;
	}
	
	public Puerto getOrigen() {
		return this.puertoOrigen;
	}
	
	public Puerto getDestino() {
		return this.puertoDestino;
	}
	
	public double precioTramo() {
		return this.precio;
	}
	
	public int tiempoEnDias() {
		return this.tiempoDias;
	}
}
