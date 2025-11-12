package unq.edu.po2.terminales4.viajes;

import unq.edu.po2.terminales4.posicion.*;

public class Ruta {

	private Puerto origen;
	private Puerto destino;
	private Viaje viaje;
	
	public Ruta(Puerto origen, Puerto destino, Viaje viaje) {
		this.origen = origen;
		this.destino = destino;
		this.viaje = viaje; 
	}
	
	public Viaje getViaje() {
		return this.viaje;
	}
	
	public Puerto getOrigen() {
		return this.origen;
	}
	
	public Puerto getDestino() {
		return this.destino;
	}
	
	//Comparamos rutas por este codigo, sabemos que no van a existir dos rutas distintas que
	// tengan el mismo destino, origen y pertenezcan al mismo viaje.
	// ( a menos que sean instancias distintas de la misma ruta, por eso el codigo :D )
	public String getCodigo() {
		String cod = this.origen.getNombre();
		cod += this.destino.getNombre();
		cod += this.viaje.getCodigo();
		return cod; 
	}
	
	
}
