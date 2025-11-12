package unq.edu.po2.container;

import java.util.ArrayList;
import java.util.List;
import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.servicio.*;

public abstract class Container {
	String identificador;
	int anchoMetros;
	int largoMetros;
	int alturaMetros;
	int pesoKilos;
	List<Servicio> servicios;
	
	public Container(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso) {
		identificador = setIdentificador(cliente, idNum);
		anchoMetros = ancho;
		largoMetros = largo;
		alturaMetros = altura;
		pesoKilos = peso;
		this.servicios = new ArrayList<Servicio>();
		
	}
	
	public void agregarServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public List<Servicio> getServicios() {
		return this.servicios;
	} 
	
	/**
	 * Setea el identificador del container
	 * @param cliente Cliente
	 * @param n es int, 7 números
	 * @return String, identificador de 11 caracteres, 4 letras  y 7 números
	 */
	public String setIdentificador(Cliente cliente, int n) {
		
		String numeroRecortado = String.format("%07d", n % 10_000_000);
		
		return generarCodCliente(cliente.getNombre()) + numeroRecortado;
	}
	
	protected String generarCodCliente(String nombre) {
		
		return getCuatroLetras(normalizarNombre(nombre));
	}
	
	protected String normalizarNombre(String nombre) {
		
		return nombre.replaceAll("\\s+", "").toUpperCase();
	}
	
	/* Voy a suponer que van a poner el apellido o al menos nombres mayores a 4 letras, 
	 * se puede hacer igual que agregue letras como los números.
	 */
	protected String getCuatroLetras(String nombre) {
		
		return nombre.substring(0, 4);
	}
	
	public abstract int getPesoCarga();
	
	public abstract ContenidoCarga getBL();
	
	public String getIdentificador() {
		return identificador;
	}
	
	//solo para reporte
	public abstract String getTipo();
	
	public int getDimensionesCubicas() {
		return anchoMetros * largoMetros * alturaMetros;
	}
	
}
