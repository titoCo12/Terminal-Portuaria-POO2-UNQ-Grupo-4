package unq.edu.po2.container;

import unq.edu.po2.cliente.Cliente;

public class ContainerDry extends Container{
	
	ContenidoCarga BL;
	
	public ContainerDry(Cliente cliente, int idNum, int ancho, int largo, int altura, int peso, ContenidoCarga carga) {
		super(cliente, idNum, ancho, largo, altura, peso);
		BL = carga;
	}
	
	@Override
	public String getTipo() {
		return "Dry";
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
