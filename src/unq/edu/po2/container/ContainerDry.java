package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public class ContainerDry extends Container{
	
	ContenidoCarga carga;

	public ContainerDry( Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, ContenidoCarga carga) {
		super(cliente, idNum, ancho, largo, altura, peso, carga);
	}
	
	//¿Es necesario contar que tenga más de un tipo de producto?
	
	// FALTAN LOS SERVICIOS
	@Override
	public double costoServicios() {
		// TODO Auto-generated method stub
		return 0;
	}

}
