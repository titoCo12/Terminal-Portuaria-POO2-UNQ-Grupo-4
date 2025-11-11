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
	/*
	 * Todos estuvimos de acuerdo en que necesito getMontoFinal(Orden orden)
	 * pero como en la interfaz está: getMontoFinal(Container container), también lo necesito implementar,
	 * no puedo hacer que devuelva null o 0, ¿de verdád no es más fácil convertir Servicio en
	 * una clase abstracta y pasarme orden cuando armo el excedente?
	 */
	// La orden es la que la agrega
	public double getMontoFinal(Orden orden) {
		long diasExcedidos = Duration.between(orden.getFechaLLegada(), orden.getFechaRetiroCarga()).toDays();
		
		return  diasExcedidos * monto;
	}
	//Esto existe por porque lo tiene la interfaz
	@Override
	public double getMontoFinal(Container container) {
		
		return 0;
	}
	
	/*
	 * Todos estuvimos de acuerdo en que necesito getMontoFinal(Orden orden)
	 * pero como en la interfaz está: getMontoFinal(Container container), también lo necesito implementar,
	 * no puedo hacer que devuelva null o 0, ¿de verdád no es más fácil convertir Servicio en
	 * una clase abstracta y pasarme orden cuando armo el excedente?
	 */

	@Override
	public String getNombre() {
		return "Almacenamiento Excedente";
	}

}
