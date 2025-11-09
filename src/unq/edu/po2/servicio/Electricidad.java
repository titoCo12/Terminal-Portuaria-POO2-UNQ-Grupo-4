package unq.edu.po2.servicio;

import java.time.Duration;

import unq.edu.po2.container.Container;
import unq.edu.po2.container.ContainerReefer;

public class Electricidad implements Servicio {
	
	double precioPorKw;
	
	public Electricidad(double precioPorKw) {
		this.precioPorKw = precioPorKw;
	}
	
	//Duration es de tipo long pero no creo que supere los 2.147 millones de horas (245 años)
	@Override
	public double getMontoFinal(Container container) {
		ContainerReefer reefer = (ContainerReefer) container;
		
		int horas = (int) Duration.between(reefer.getMomentoConexion(), reefer.getMomentoDesconexion()).toHours();

		return horas * reefer.getConsumoXHora() * precioPorKw;
	}

}
