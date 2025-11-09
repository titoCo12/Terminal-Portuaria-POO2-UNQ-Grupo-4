package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public class ContainerDry extends Container{
	
	public ContainerDry( Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, ContenidoCarga carga) {
		super(cliente, idNum, ancho, largo, altura, peso, carga);
	}
	
	// FALTAN LOS SERVICIOS
	@Override
	public double costoServicios() {
		// TODO Auto-generated method stub
		return 0;
	}

}
