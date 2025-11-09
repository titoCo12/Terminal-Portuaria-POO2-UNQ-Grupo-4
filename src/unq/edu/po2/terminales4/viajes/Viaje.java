package unq.edu.po2.terminales4.viajes;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.circuito.*;
import java.time.LocalDate;
import java.util.*;

public class Viaje {

	private String codigo;
	private Circuito circuito;
	private Buque buque;
	private Naviera naviera;
	private LocalDate inicio;
	private Map<Puerto, LocalDate> cronograma;
	
	public Viaje(LocalDate inicio, Circuito circ, Buque buque, Naviera naviera) {
		this.codigo = String.valueOf(this.hashCode());
		this.inicio = inicio;
		this.circuito = circ;
		this.buque = buque;
		this.naviera = naviera;
		this.crearCronograma();
	}
	
	private void crearCronograma() {
		//TODO: Implementar metodo que genere cronograma en base a fecha de inicio y circuito y lo asigne.
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
		return this.cronograma.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
	            .map(Map.Entry::getKey)
	            .toList();
	}
}
