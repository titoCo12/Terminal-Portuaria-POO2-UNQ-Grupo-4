package unq.edu.po2.servicio;

import java.time.Duration;

import unq.edu.po2.container.Container;
import unq.edu.po2.terminales4.orden.Orden;

public class AlmacenamientoExcedente implements Servicio {
	
	double monto;
	
	public AlmacenamientoExcedente(double monto) {
		this.monto = monto;
	}
	/*
	 * Todos estuvimos de acuerdo en que necesito getMontoFinal(Orden orden) pero como
	 * en la interfaz está: getMontoFinal(Container container), también lo necesito implementar,
	 * no puedo hacer que devuelva null o 0, ¿está bien construir AlmacenamientoExcedente con 
	 * (double monto, Orden orden) para sacarme getMontoFinal(Orden orden) y usar 
	 * getMontoFinal(Container container) a pesar de que no se use Container? 
	 * como Pesado, que solo devuelve el monto y no usa Container
	 */
	public double getMontoFinal(Orden orden) {
		long diasExcedidos = Duration.between(orden.getFechaLlegada(), orden.getFechaRetiroCarga()).toDays();
		
		return  diasExcedidos * monto;
	}
	//Esto existe porque lo tiene la interface
	@Override
	public double getMontoFinal(Container container) {
		
		return 0;
	}

	@Override
	public String getNombre() {
		return "Almacenamiento Excedente";
	}

}
