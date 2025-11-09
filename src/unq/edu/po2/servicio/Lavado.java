package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;

public class Lavado extends Servicio {
	
	double precioMenor;
	double precioMayor;
	final int dimensionesAComparar = 70;
	
	
	public Lavado(double precioMenor, double precioMayor) {
		this.precioMenor = precioMenor;
		this.precioMayor = precioMayor;
	}

	@Override
	public double getMontoFinal(Container container) {
		int dimensionescubicas = container.getDimensionesCubicas();
		
		if (dimensionescubicas > dimensionesAComparar) {
			return precioMayor;
		} else {
			return precioMenor;
		}
	}

}
