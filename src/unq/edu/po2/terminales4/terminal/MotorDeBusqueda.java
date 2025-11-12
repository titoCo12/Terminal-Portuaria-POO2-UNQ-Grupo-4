package unq.edu.po2.terminales4.terminal;

import java.time.LocalDate;
import java.util.*;

import unq.edu.po2.terminales4.buque.Buque;
import unq.edu.po2.terminales4.circuito.*;
import unq.edu.po2.terminales4.condicionesRutas.CondicionRuta;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;



public class MotorDeBusqueda {
	
	private List<Viaje> publicaciones;
	private List<Circuito> circuitos;
	private CriterioCircuito criterio;
	
	public MotorDeBusqueda(List<Viaje> viajes, List<Circuito> circs ) {
		this.publicaciones = viajes;
		this.circuitos = circs;
		this.criterio = new CriterioMenorTiempo(); 
	}
	
	public void agregarViaje(Viaje v) {
		publicaciones.add(v);
	}
	
	public void agregarCircuito(Circuito c) {
		circuitos.add(c);
	}
	
	public int cantViajes() {
		return this.publicaciones.size();
	}
	
	public int cantCircuitos() {
		return this.circuitos.size();
	}	
	
	public List<Ruta> busquedaRutas(Puerto origen, CondicionRuta condicion) {
		return condicion.validarViajes(publicaciones, origen);
	}
	
	
	
	public Optional<Circuito> mejorCircuito(Puerto origen, Puerto destino, CriterioCircuito criterio) {
		this.criterio = criterio;
		//filtra por los que contengan ese "conjunto de tramos" de origen a destino primero
		List<Circuito> filtrados = circuitos.stream().filter(c -> c.contieneRuta(origen, destino)).toList();
		
		return this.criterio.mejorCircuito(filtrados, origen, destino); 
	}
	
	public CriterioCircuito getCriterio() {
		return this.criterio;
	}

	public Optional<LocalDate> salidaDeBuqueHasta(Buque buque, Puerto origen, Puerto destino) {
		return  this
				.publicaciones.stream()
				.filter(v -> v.getBuque().equals(buque))
				.filter(v -> v.pasaPor(origen) && v.pasaPor(destino))
				.filter(v -> v.fechaLlegadaA(origen).get().isBefore(v.fechaLlegadaA(destino).get()))
				.map(v -> v.fechaLlegadaA(origen).get())
				.min(Comparator.naturalOrder());
	}
	
}
