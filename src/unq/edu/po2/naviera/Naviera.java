package unq.edu.po2.naviera;

import java.util.ArrayList;
import java.util.List;

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
		
	}
}
