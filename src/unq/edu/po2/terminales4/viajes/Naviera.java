package unq.edu.po2.terminales4.viajes;

import java.util.*;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;

public class Naviera {
	String nombre;
	List<Circuito> circuitos = new ArrayList<Circuito>();
	
	public Naviera (String nombre, List<Circuito> circuitos) {
		this.nombre = nombre;
		this.circuitos.addAll(circuitos);
	}
	//Test
	public String getNombre() {
		return nombre;
	}
	public int mejorTiempoHasta(Puerto origen, Puerto destino) {
		return circuitos.stream().mapToInt(c -> c.diasDesdeHasta(origen, destino)).min().orElse(0);
	}
}
