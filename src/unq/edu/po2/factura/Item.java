package unq.edu.po2.factura;

public class Item {
	private String descripcion;
	private double valor;
	
	public Item(String descripcion, double valor) {
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getValor() {
		return valor;
	}
	
	
}
