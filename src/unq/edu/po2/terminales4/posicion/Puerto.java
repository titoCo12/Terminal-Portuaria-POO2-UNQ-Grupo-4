package unq.edu.po2.terminales4.posicion;

public class Puerto {

	private String nombre;
	private Posicion posicion;
	
	public Puerto(String nombre, Posicion pos) {
		this.nombre = nombre;
		this.posicion = pos;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
}
