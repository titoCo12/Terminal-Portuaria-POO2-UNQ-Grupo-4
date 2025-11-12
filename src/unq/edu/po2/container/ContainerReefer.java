package unq.edu.po2.container;

import java.time.LocalDateTime;

import unq.edu.po2.cliente.Cliente;

public class ContainerReefer extends Container{
	
	int celciusDeseado;
	double consumo = 0.0;
	LocalDateTime momentoConexion;
	LocalDateTime momentoDesconexion;
	Producto BL;

	public ContainerReefer(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, Producto producto, int temperaturaDeseada, LocalDateTime tiempoConexion, LocalDateTime tiempoDesconexion) {
		super(cliente, idNum, ancho, largo, altura, peso);
		celciusDeseado = temperaturaDeseada;
		momentoConexion = tiempoConexion;
		momentoDesconexion = tiempoDesconexion;
		this.BL = producto;
	}
	
	public String getTipo() {
		return "Reefer";
	}
	
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	
	public void aumentarConsumo(double masConsumo) {
		consumo += masConsumo;
	}
	
	public double getConsumoXHora() {
		return consumo;
	}
	
	public LocalDateTime getMomentoConexion() {
		return momentoConexion;
	}
	
	public LocalDateTime getMomentoDesconexion() {
		return momentoDesconexion;
	}
	
	@Override
	public ContenidoCarga getBL() {
		return this.BL;
	}
	
	@Override
	public int getPesoCarga() {
		return this.BL.getPesoKilos();
	}

}
