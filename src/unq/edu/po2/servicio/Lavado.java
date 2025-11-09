package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;

public class Lavado implements Servicio {
	
	double precio;
	
	public Lavado(double precio) {
		this.precio = precio;
	}

	@Override
	public double getMontoFinal(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}

}
