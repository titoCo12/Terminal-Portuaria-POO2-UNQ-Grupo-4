package unq.edu.po2.servicio;

import java.time.Duration;
import java.time.LocalDate;

import unq.edu.po2.container.Container;
import unq.edu.po2.terminales4.orden.Orden;

public class AlmacenamientoExcedente implements Servicio {
	
	double monto;
	
	public AlmacenamientoExcedente(double monto) {
		this.monto = monto;
	}

	
	@Override
	public double getMontoFinal(Container container) {
		long diasExcedidos = Duration.between(orden.getFechaLLegada(), orden.getFechaRetiroCarga()).toDays();
		
		return  diasExcedidos * monto;
	}


	@Override
	public String getNombre() {
		return "Almacenamiento Excedente";
	}

	
	

}
