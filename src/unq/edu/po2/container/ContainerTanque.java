package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public class ContainerTanque extends Container{

	Producto BL;
	
	public ContainerTanque(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, Producto producto) {
		super(cliente, idNum, ancho, largo, altura, peso);
		BL = producto;
	}
	@Override
	public String getTipo() {
		return "Tanque";
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

