package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;

public class Lavado implements Servicio {
	
	double precioMenor;
	double precioMayor;
	final int dimensionesAComparar = 70;
	
	
	public Lavado(double precioMenor, double precioMayor) {
		this.precioMenor = precioMenor;
		this.precioMayor = precioMayor;
	}

	@Override
	public double getMontoFinal(Container container) {
		int dimensionesCubicas = container.getDimensionesCubicas();
		
		if (dimensionesCubicas > dimensionesAComparar) {
			return precioMayor;
		} else {
			return precioMenor;
		}
	}

	@Override
	public String getNombre() {
		return "Lavado";
	}

}
