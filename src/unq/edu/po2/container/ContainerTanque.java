package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public class ContainerTanque extends Container{
	
	Producto producto;

	public ContainerTanque(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, ContenidoCarga carga) {
		super(cliente, idNum, ancho, largo, altura, peso, carga);
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	//¿Es necesario validar que no tenga más de un tipo de producto? si lo especifican cero que sí
	
	//FALTAN LOS SERVICIOS
	@Override
	public double costoServicios() {
		// TODO Auto-generated method stub
		return 0;
	}

}
