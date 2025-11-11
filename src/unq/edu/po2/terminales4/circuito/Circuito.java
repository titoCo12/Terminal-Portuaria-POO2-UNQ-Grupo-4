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

	public void agregarPuerto(Puerto puertoNuevo, int diasHastaSiguientePuerto, double precioHastaSiguientePuerto) {
		Tramo tramoNuevo = new Tramo(this.fin, puertoNuevo, precioHastaSiguientePuerto, diasHastaSiguientePuerto);
		this.tramos.add(tramoNuevo);
		this.fin = puertoNuevo;
	}

	public int getDuracion() {
		return this.tramos.stream().mapToInt(tramo -> tramo.tiempoEnDias()).sum();
	}

}
