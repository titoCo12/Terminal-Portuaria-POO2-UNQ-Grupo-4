package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;

public class Electricidad implements Servicio {
	
	double valorPorConsumo;
	
	public Electricidad(double valorPorConsumo) {
		this.valorPorConsumo = valorPorConsumo;
	}

	@Override
	public double getMontoFinal(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}

}
