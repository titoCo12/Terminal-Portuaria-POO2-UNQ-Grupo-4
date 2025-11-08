package unq.edu.po2.terminales4.viajes;

import java.time.LocalDate;
import unq.edu.po2.terminales4.posicion.*;

public class Ruta {

	private Puerto origen;
	private Puerto destino;
	private LocalDate salida;
	private LocalDate llegada;
	private Viaje viaje;
	
	public Ruta(Puerto origen, Puerto destino, LocalDate salida, LocalDate llegada, Viaje viaje) {
		this.origen = origen;
		this.destino = destino;
		this.salida = salida;
		this.llegada = llegada;
		this.viaje = viaje;
	}
	
	public Viaje getViaje() {
		return this.viaje;
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
