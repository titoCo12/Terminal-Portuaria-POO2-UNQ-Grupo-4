package unq.edu.po2.servicio;

import unq.edu.po2.container.*;

public interface Servicio {
	
	public double getMontoFinal(Container container);
	
	public String getNombre();
	// si hago return this.getClass().getSimpleName(); deja de ser interface.

}
