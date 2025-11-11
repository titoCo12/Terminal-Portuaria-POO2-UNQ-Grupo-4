package unq.edu.po2.terminales4.circuito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public boolean pasaPor(Puerto puerto) {
		
		return this.puertosDelCircuito().contains(puerto);
		
	}

	private List<Puerto> puertosDelCircuito() {
		Set<Puerto> puertosDelCircuito = new HashSet<Puerto>();
		this.tramos.stream().forEach(tramo -> {
			puertosDelCircuito.add(tramo.getOrigen());
			puertosDelCircuito.add(tramo.getDestino());
		});
		return puertosDelCircuito.stream().toList();
		
	}

	public int diasHasta(Puerto puerto) {
		return this.tramosHasta(puerto).stream().mapToInt(tramo -> tramo.tiempoEnDias()).sum();
	}

	private List<Tramo> tramosHasta(Puerto puerto) {
		 List<Tramo> tramosHasta = new ArrayList<Tramo>();
		 this.tramos.stream().forEach(tramo -> {
			 if(!this.esOrigen(tramo, puerto)) 
				 //si no es el origen agrego el tramo. Si es el origen. NO agrego el tramo.
				 tramosHasta.add(tramo); 
		 });
		 return tramosHasta;
	
	}

	private boolean esOrigen(Tramo tramo, Puerto puerto) {
		return tramo.getOrigen().equals(puerto); 
	}

	public boolean contieneRuta(Puerto origen, Puerto destino) {
		List<Puerto> recorrido = this.puertosDelCircuito();
		boolean cond = false;
		if (recorrido.contains(origen) && recorrido.contains(destino)) {
			cond = recorrido.indexOf(origen) < recorrido.indexOf(destino);
		}
		return cond;
	}
	
	public int diasDesdeHasta(Puerto origen, Puerto destino) {
		return this.diasHasta(destino) - this.diasHasta(origen);
	}
	
	public Double precioDesdeHasta(Puerto origen, Puerto destino) {
		Double valorOrigen = this.tramosHasta(origen).stream().mapToDouble(t -> t.precioTramo()).sum();
		Double valorDestino = this.tramosHasta(destino).stream().mapToDouble(t -> t.precioTramo()).sum();
		return valorDestino - valorOrigen;
		//si el origen es el primer tramo del circuito, su valor va a ser 0 obviamente :)
	}
	
	public int terminalesEntre(Puerto origen, Puerto destino) {
		List<Puerto> recorrido = this.puertosDelCircuito();
		return recorrido.indexOf(destino) - recorrido.indexOf(origen) - 1;
	}


}
