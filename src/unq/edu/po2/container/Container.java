package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public abstract class Container {
	String identificador;
	int anchoMetros;
	int largoMetros;
	int alturaMetros;
	int pesoKilos;
	//Solo por el contructor porque en el uml no lo conoce PREGUNTAR
	ContenidoCarga carga; 
	//Solo por el contructor porque en el uml no lo conoce PREGUNTAR
	
	public Container( Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, ContenidoCarga carga) {
		identificador = setIdentificador(cliente, idNum);
		anchoMetros = ancho;
		largoMetros = largo;
		alturaMetros = altura;
		pesoKilos = peso;
		this.carga = carga;
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
	
	// Voy a suponer que van a poner el apellido o al menos nombres mayores a 4 letras
	public String getCuatroLetras(String nombre) {
		
		return nombre.substring(0, 4);
	}
	
	public abstract double costoServicios();
	
	public int getPesoCarga() {
		
		return carga.getPesoKilos();
	}
	
	public ContenidoCarga getBL() {
		return carga;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
}
