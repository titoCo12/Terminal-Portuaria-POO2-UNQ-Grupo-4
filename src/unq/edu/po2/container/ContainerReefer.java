package unq.edu.po2.container;

import java.time.LocalDateTime;

import unq.edu.po2.cliente.Cliente;

public class ContainerReefer extends Container{
	
	int celciusDeseado;
	double consumo = 0.0;
	LocalDateTime momentoConexion;
	LocalDateTime momentoDesconexion;

	public ContainerReefer(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, Producto producto, int temperaturaDeseada, LocalDateTime tiempoConexion, LocalDateTime tiempoDesconexion) {
		super(cliente, idNum, ancho, largo, altura, peso, producto);
		celciusDeseado = temperaturaDeseada;
		momentoConexion = tiempoConexion;
		momentoDesconexion = tiempoDesconexion;
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
	
	//¿Es necesario validar que no tenga más de un tipo de producto? si lo especifican cero que sí
	
		//FALTAN LOS SERVICIOS
	@Override
	public double costoServicios() {
		// TODO Auto-generated method stub
		return 0;
	}

}
