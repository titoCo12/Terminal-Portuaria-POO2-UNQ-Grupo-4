package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;

public class Pesado implements Servicio {
	
	double monto;
	
	public Pesado(double monto) {
		this.monto = monto;
	}

	@Override
	public double getMontoFinal(Container container) {
		return monto;
	}

}
