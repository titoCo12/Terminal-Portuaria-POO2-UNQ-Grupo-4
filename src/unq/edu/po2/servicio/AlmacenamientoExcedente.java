package unq.edu.po2.servicio;

import java.time.LocalDate;

import unq.edu.po2.container.Container;

public class AlmacenamientoExcedente implements Servicio {
	
	double monto;
	
	public AlmacenamientoExcedente(double monto) {
		this.monto = monto;
	}

	@Override
	public double getMontoFinal(Container container) {
		long diasExcedidos = Duration.between(orden.getFechaLlegada(), LocalDate.now()).toDays();
		return  diasExcedidos * monto;
	}

	
	

}
