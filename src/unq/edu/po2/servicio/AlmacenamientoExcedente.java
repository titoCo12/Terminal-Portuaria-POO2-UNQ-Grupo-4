package unq.edu.po2.servicio;

import java.time.Duration;
import java.time.LocalDate;

import unq.edu.po2.container.Container;

public class AlmacenamientoExcedente extends Servicio {
	
	double monto;
	
	public AlmacenamientoExcedente(double monto, Orden orden) {
		this.monto = monto;
		this.orden = orden;
	}

	@Override
	public double getMontoFinal(Container container) {
		long diasExcedidos = Duration.between(orden.getFechaLlegada(), LocalDate.now()).toDays();
		return  diasExcedidos * monto;
	}

	
	

}
