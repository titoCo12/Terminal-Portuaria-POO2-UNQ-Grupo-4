package unq.edu.po2.naviera;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;

public class Naviera {
	String nombre;
	List<Circuito> circuitos;
	
	public Naviera (String nombre) {
		this.nombre = nombre;
		this.circuitos = new ArrayList<>();
	}
	
	public void agregarCircuito(Circuito circuito) {
		circuitos.add(circuito);
	}
	
	public int mejorTiempoLlegadaA(Puerto puertoA, Puerto puertoB) {
		List<Circuito> conectados = circuitosConectados(puertoA, puertoB);
		return tiempoMinimo(conectados, puertoA, puertoB);
	}
	
	private List<Circuito> circuitosConectados(Puerto puertoA, Puerto puertoB) {
		return circuitos.stream().filter(c -> c.contieneRuta(puertoA, puertoB))
				.collect(Collectors.toList());
	}
	
	private int tiempoMinimo(List<Circuito> conectados, Puerto pOrigen, Puerto pDestino) {
		return conectados.stream().mapToInt(c -> c.diasDesdeHasta(pOrigen, pDestino))
				.min().getAsInt();
	}

}
