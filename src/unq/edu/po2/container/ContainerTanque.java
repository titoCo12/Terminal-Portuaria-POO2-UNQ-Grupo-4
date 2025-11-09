package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public class ContainerTanque extends Container{
	
	Producto producto;

	public ContainerTanque(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, Producto producto) {
		super(cliente, idNum, ancho, largo, altura, peso, producto);
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Override
	public Producto getBL() {
		return producto;
	}
	
	@Override
	public int getPesoCarga() {
		return producto.getPesoKilos();
	}
	
	//¿Es necesario validar que no tenga más de un tipo de producto? si lo especifican cero que sí
	
	//FALTAN LOS SERVICIOS
	@Override
	public double costoServicios() {
		// TODO Auto-generated method stub
		return 0;
	}

}
