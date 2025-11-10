package unq.edu.po2.servicio;

import java.time.Duration;
import java.time.LocalDate;

import unq.edu.po2.container.Container;
import unq.edu.po2.terminales4.orden.Orden;

public class AlmacenamientoExcedente extends Servicio {
	
	double monto;
	
	public AlmacenamientoExcedente(double monto, Orden orden) {
		this.monto = monto;
		this.orden = orden;
	}

	
	@Override
	public double getMontoFinal(Container container) {
		long diasExcedidos = Duration.between(orden.getFechaLLegada(), orden.getFechaRetiroCarga()).toDays();
		return  diasExcedidos * monto;
	}

	
	

}
