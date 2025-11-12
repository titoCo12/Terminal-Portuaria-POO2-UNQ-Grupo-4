package unq.edu.po2.terminales4.condicionesRutas;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;


//No esperaba que esta condición sea la mas fea (X_X)
public class CondicionSalida implements CondicionRuta {

	private LocalDate salida;
	
	public CondicionSalida(LocalDate salida) {
		this.salida = salida;
	}
	
	
	//Usamos get en los valores que son tipo Optional, ya que en este caso sabemos que revisamos antes que existan
	public List<Ruta> validarViajes(List<Viaje> viajes, Puerto origen) {
		Stream<Viaje> vs = viajes.stream().filter(v -> v.pasaPor(origen));
		vs = vs.filter(v -> v.fechaLlegadaA(origen).get().equals(salida));
	
		//Ahora debe devolver las rutas posibles por cada viaje, iniciando la ruta en el origen
		// flatMap para aplanar la lista de listas que se genera
		return vs.flatMap(v -> rutasPosiblesDesde(v, origen).stream()).toList();
	}
	
	
	private List<Ruta> rutasPosiblesDesde(Viaje viaje, Puerto origen) {
	    List<Ruta> rutas = new ArrayList<>();
	    List<Puerto> puertos = viaje.getPuertos();
	    int indiceOrigen = puertos.indexOf(origen);
	    
	    //Si es el último, no hay rutas posibles
	    if (!(indiceOrigen == puertos.size() - 1)) {
	    	
	    	//Creamos todas las rutas posibles apartir del origen
	    	for (int i = indiceOrigen + 1; i < puertos.size(); i++) {
		        Puerto destino = puertos.get(i);
		        rutas.add(new Ruta(origen, destino, viaje));
		    }
	    }
	    
	    return rutas;
	}

	
}
