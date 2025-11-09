package unq.edu.po2.cliente;

import unq.edu.po2.container.Container;
import unq.edu.po2.servicio.Servicio;

public class AlmacenamientoExcedente implements Servicio {
	
	double monto;
	
	public AlmacenamientoExcedente(double monto) {
		this.monto = monto;
	}

	@Override
	public double getMontoFinal(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}

}
