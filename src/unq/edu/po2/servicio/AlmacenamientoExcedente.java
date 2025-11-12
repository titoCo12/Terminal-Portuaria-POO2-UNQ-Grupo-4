package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;


public class AlmacenamientoExcedente implements Servicio {
	
	double total;
	
	public AlmacenamientoExcedente(double monto, int diasExcedidos) {
		this.total = monto * diasExcedidos;
	}
	
	@Override
	public double getMontoFinal(Container container) {
		return total;
	}

	@Override
	public String getNombre() {
		return "Almacenamiento Excedente";
	}

}
