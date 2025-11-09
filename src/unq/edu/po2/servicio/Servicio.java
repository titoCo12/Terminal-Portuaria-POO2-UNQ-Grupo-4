package unq.edu.po2.servicio;

import unq.edu.po2.container.Container;

public abstract class Servicio {
	
	Orden orden;
	
	public abstract double getMontoFinal(Container container);
	
	public void setOrden(Orden orden) {
		this.orden = orden;
	}

}
