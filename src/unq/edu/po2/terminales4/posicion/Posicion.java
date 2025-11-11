package unq.edu.po2.terminales4.posicion;

public class Posicion {
	
	int coordX;
	int coordY;
	
	public Posicion(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public double distanciaEnKmA(Posicion posicionPuertoDestino) {
		int diferenciaCoordX = this.coordX - posicionPuertoDestino.coordX;
		int diferenciaCoordY = this.coordY - posicionPuertoDestino.coordY;
		return Math.sqrt(diferenciaCoordX * diferenciaCoordX + diferenciaCoordY * diferenciaCoordY);
	}

}
