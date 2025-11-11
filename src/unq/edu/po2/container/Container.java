package unq.edu.po2.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.servicio.*;

public abstract class Container {
	String identificador;
	int anchoMetros;
	int largoMetros;
	int alturaMetros;
	int pesoKilos;
	ContenidoCarga carga;
	List<Servicio> servicios;
	
	public Container( Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, ContenidoCarga carga) {
		identificador = setIdentificador(cliente, idNum);
		anchoMetros = ancho;
		largoMetros = largo;
		alturaMetros = altura;
		pesoKilos = peso;
		this.carga = carga;
		this.servicios = new ArrayList<Servicio>();
		
	}
	
	public void agregarServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public String getDesgloseServicios() {
		return servicios.stream().map(s -> s.getNombre() + ": " + s.getMontoFinal(this)).collect(Collectors.joining(", "));
	}
	
	/**
	 * Setea el identificador del container
	 * @param cliente Cliente
	 * @param n es int, 7 números
	 * @return String, identificador de 11 caracteres, 4 letras  y 7 números
	 */
	public String setIdentificador(Cliente cliente, int n) {
		
		return generarCodCliente(cliente.getNombre()) + String.format("%07d", n);
	}
	
	public String generarCodCliente(String nombre) {
		
		return getCuatroLetras(normalizarNombre(nombre));
	}
	
	public String normalizarNombre(String nombre) {
		
		return nombre.replaceAll("\\s+", "").toUpperCase();
	}
	
	/* Voy a suponer que van a poner el apellido o al menos nombres mayores a 4 letras, 
	 * se puede hacer igual que agregue letras como los números.
	 */
	public String getCuatroLetras(String nombre) {
		
		return nombre.substring(0, 4);
	}
	
	public int getPesoCarga() {
		
		return carga.getPesoKilos();
	}
	
	public ContenidoCarga getBL() {
		return carga;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public int getDimensionesCubicas() {
		return anchoMetros * largoMetros * alturaMetros;
	}
	
}
