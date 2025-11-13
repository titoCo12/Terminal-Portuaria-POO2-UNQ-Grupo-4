package unq.edu.po2.terminales4.viajes;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.circuito.*;

import java.time.LocalDate;
import java.util.*;

public class Viaje {

	private String codigo;
	private Circuito circuito;
	private Map<Puerto, LocalDate> cronograma;
	private Buque buque;
	
	public Viaje(LocalDate inicio, Circuito circ, Buque buque, Naviera naviera) {
		this.codigo = String.valueOf(this.hashCode()); 
		this.circuito = circ;
		this.crearCronograma(inicio);  
		this.buque = buque;
	}
	
	
	private void crearCronograma(LocalDate inicio) {
		LocalDate fechaActual = inicio;
		List<Puerto> puertos = this.circuito.puertosDelCircuito(); 
		Map<Puerto, LocalDate> cronograma = new HashMap<Puerto, LocalDate>();
			
		for (Puerto p : puertos) {
			fechaActual = fechaActual.plusDays(this.circuito.diasHasta(p));
			cronograma.put(p, fechaActual); 
		}
		
		this.cronograma = cronograma;
	}
	
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public boolean pasaPor(Puerto p) {
		return this.cronograma.containsKey(p);
	}
	
	//Tiene que tirar optional
	public Optional<LocalDate> fechaLlegadaA(Puerto p) {
		return Optional.ofNullable(this.cronograma.get(p));
	}
	
	//Devuelve si en esa fecha llega/sale de algun puerto
	public boolean pasaEnFecha(LocalDate fecha) {
		return this.cronograma.containsValue(fecha);
	}
	
	//Tiene que tirar optional
	public Optional<Puerto> puertoEnFecha(LocalDate fecha) {
		return this.cronograma.entrySet().stream().filter(entry -> entry.getValue().equals(fecha))
				.map(Map.Entry::getKey).findAny(); 
	}
	
	//Devuelve todos los puertos por los que pasa en orden
	public List<Puerto> getPuertos() {
		return this.circuito.puertosDelCircuito();
	} 
	
	public Circuito getCircuito() {
		return this.circuito;
	}

	public Buque getBuque() {
		return buque;
	}
}
