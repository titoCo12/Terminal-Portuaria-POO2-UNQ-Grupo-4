package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public class ContainerTanque extends Container{

	public ContainerTanque(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, ContenidoCarga producto) {
		super(cliente, idNum, ancho, largo, altura, peso, producto);
	}
	
	//¿Es necesario validar que no tenga más de un tipo de producto?

}
