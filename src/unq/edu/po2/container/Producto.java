package unq.edu.po2.container;

public class Producto implements ContenidoCarga {
	String tipoProducto;
	int pesoKilos;
	
	public Producto (String producto, int peso) {
		tipoProducto = producto;
		pesoKilos = peso;
	}

	@Override
	public int getPesoKilos() {
		
		return pesoKilos;
	}

	@Override
	public String getTipoProducto() {
		
		return tipoProducto;
	}

}
