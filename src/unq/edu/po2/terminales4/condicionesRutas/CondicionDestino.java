package unq.edu.po2.terminales4.condicionesRutas;
import java.util.*;
import java.util.stream.Stream;

import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;

public class CondicionDestino implements CondicionRuta {

	private Puerto destino;
	
	public CondicionDestino(Puerto p) {
		this.destino = p;
	}
	
	//Usamos get en los valores que son tipo Optional, ya que en este caso sabemos que revisamos antes que existan
	public List<Ruta> validarViajes(List<Viaje> viajes, Puerto origen) {
	    Stream<Viaje> vs = viajes.stream().filter(v -> v.pasaPor(origen) && v.pasaPor(destino));
		vs = vs.filter(v -> v.fechaLlegadaA(origen).get().isBefore(v.fechaLlegadaA(destino).get()));
		return vs.map(v -> new Ruta(origen, destino, v.fechaLlegadaA(origen).get(), v.fechaLlegadaA(destino).get(), v)).toList();
	}

	
}
