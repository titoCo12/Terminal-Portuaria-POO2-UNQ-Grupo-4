package unq.edu.po2.servicio;

import java.time.Duration;

import unq.edu.po2.container.Container;
import unq.edu.po2.container.ContainerReefer;

public class Electricidad implements Servicio {
	
	double precioPorKw;
	
	public Electricidad(double precioPorKw) {
		this.precioPorKw = precioPorKw;
	}
	
	@Override
	public double getMontoFinal(Container container) {
		ContainerReefer reefer = (ContainerReefer) container;
		
		long horas = Duration.between(reefer.getMomentoConexion(), reefer.getMomentoDesconexion()).toHours();

		return horas * reefer.getConsumoXHora() * precioPorKw;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Electricidad";
	}

}
