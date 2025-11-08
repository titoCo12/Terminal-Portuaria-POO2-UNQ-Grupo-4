package unq.edu.po2.terminales4.condicionesRutas;

import java.util.*;
import java.util.stream.*;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;

public class CondicionOR implements CondicionRuta {

	private CondicionRuta cond1;
	private CondicionRuta cond2;
	
	public CondicionOR(CondicionRuta cond1, CondicionRuta cond2) {
		this.cond1 = cond1;
		this.cond2 = cond2;
	}
	
	//Nos quedamos con las rutas que cumplan una o la otra condicion (une las listas sin repetidos)
	public List<Ruta> validarViajes(List<Viaje> viajes, Puerto origen) {
		List<Ruta> rutas1 = cond1.validarViajes(viajes, origen);
		List<Ruta> rutas2 = cond2.validarViajes(viajes, origen);
	    Map<String, Ruta> rutasPorCodigo = new HashMap<>();

	    //agregamos rutas a un map usando al codigo como clave para evitar repetidos
	    // rutas de cond1
	    for (Ruta r : rutas1) {
	        rutasPorCodigo.put(r.getCodigo(), r);
	    }
	    // rutas de cond2
	    for (Ruta r : rutas2) {
	        rutasPorCodigo.put(r.getCodigo(), r);
	    }

	    // Convertir los valores del mapa a una lista final
	    return new ArrayList<Ruta>(rutasPorCodigo.values());
	}
	
	
}
