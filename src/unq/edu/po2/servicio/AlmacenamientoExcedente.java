package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;

public class AlmacenamientoExcedente implements Servicio {
	
	double monto;
	
	public AlmacenamientoExcedente(double monto) {
		this.monto = monto;
	}

	@Override
	public double getMontoFinal(Container container) {
		/*
		 * Sería la cantidad de días que lleva el buque en la terminal * monto
		 */
		return 0;
	}

	
	

}
