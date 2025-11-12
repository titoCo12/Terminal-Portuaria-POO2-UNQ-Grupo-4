package unq.edu.po2.terminales4.condicionesRutas;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;

public class CondicionLlegada implements CondicionRuta {

	private LocalDate llegada;
	
	public CondicionLlegada(LocalDate llegada) {
		this.llegada = llegada;
	}
	
	//Usamos get en los valores que son tipo Optional, ya que en este caso sabemos que revisamos antes que existan
	public List<Ruta> validarViajes(List<Viaje> viajes, Puerto origen) {
		Stream<Viaje> vs = viajes.stream().filter(v -> v.pasaPor(origen));
		vs = vs.filter(v -> v.pasaEnFecha(llegada));
		return vs.map(v -> new Ruta(origen, v.puertoEnFecha(llegada).get(), v)).toList();
	}
	
}
