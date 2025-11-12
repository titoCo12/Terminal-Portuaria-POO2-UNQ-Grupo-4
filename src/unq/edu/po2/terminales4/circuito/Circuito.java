package unq.edu.po2.terminales4.circuito;

import java.util.ArrayList;
import java.util.List;

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

	public Puerto getOrigen() {
		return this.inicio;
	}

	public void agregarPuerto(Puerto puertoNuevo, int diasHastaSiguientePuerto, double precioHastaSiguientePuerto) {
		Tramo tramoNuevo = new Tramo(this.fin, puertoNuevo, precioHastaSiguientePuerto, diasHastaSiguientePuerto);
		this.tramos.add(tramoNuevo);
		this.fin = puertoNuevo;
	}

	public int getDuracionDias() {
		return this.tramos.stream().mapToInt(tramo -> tramo.tiempoEnDias()).sum();
	}

	public boolean pasaPor(Puerto puerto) {
		
		return this.puertosDelCircuito().contains(puerto);
		
	}

	public int diasHasta(Puerto puerto) {
		return this.tramosHasta(puerto).stream().mapToInt(tramo -> tramo.tiempoEnDias()).sum();
	}
	
	public Double precioDesdeHasta(Puerto origen, Puerto destino) {
		Double valorOrigen = this.tramosHasta(origen).stream().mapToDouble(t -> t.precioTramo()).sum();
		Double valorDestino = this.tramosHasta(destino).stream().mapToDouble(t -> t.precioTramo()).sum();
		return valorDestino - valorOrigen;
		//si el origen es el primer tramo del circuito, su valor va a ser 0 obviamente :)
	}
	
	public int diasDesdeHasta(Puerto origen, Puerto destino) {
		return this.diasHasta(destino) - this.diasHasta(origen);
	}
	
	
	public boolean contieneRuta(Puerto origen, Puerto destino) {
		List<Puerto> recorrido = this.puertosDelCircuito();
		boolean cond = false;
		if (recorrido.contains(origen) && recorrido.contains(destino)) {
			cond = recorrido.indexOf(origen) < recorrido.indexOf(destino);
		}
		return cond;
	}
		
	public int cantidadTerminalesEntre(Puerto origen, Puerto destino) {
		List<Puerto> recorrido = this.puertosDelCircuito();
		if(origen.equals(destino)) return 0;
		return recorrido.indexOf(destino) - recorrido.indexOf(origen) - 1;
	}
	
	
	//privados
	private List<Puerto> puertosDelCircuito() {
		List<Puerto> puertosDelCircuito = new ArrayList<Puerto>();
		this.tramos.stream().forEach(tramo -> {
			//Agregando el origen, ya tengo los puertos ordenados. El circuito debe estar cerrado
			puertosDelCircuito.add(tramo.getOrigen());
		});
		//agrego el ultimo destino si no estaba vacio
		if (!this.tramos.isEmpty()) {
	        puertosDelCircuito.add(this.tramos.get(this.tramos.size() - 1).getDestino());
	    }
		
		return puertosDelCircuito.stream().toList();
		
	}


	private List<Tramo> tramosHasta(Puerto puerto) {
		List<Tramo> tramosHasta = new ArrayList<Tramo>();
		
		for(Tramo tramo : this.tramos) {
			//si no es el origen agrego el tramo. Si es el origen. NO agrego el tramo.
			if (tramo.getOrigen().equals(puerto)) {
	            break;
	        }
			tramosHasta.add(tramo); 
		 }
		 return tramosHasta;
	
	}
	

}
