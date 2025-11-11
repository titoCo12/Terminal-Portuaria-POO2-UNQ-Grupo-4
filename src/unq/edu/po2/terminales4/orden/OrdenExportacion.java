package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.terminales4.posicion.Puerto;

public class OrdenExportacion extends Orden {

	private LocalDate fechaSalida;

	public OrdenExportacion(String nombreChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			Puerto puertoOrigen, Puerto puertoDestino, Container container, Cliente cliente, LocalDate fechaSalida) {
		super(nombreChofer, patenteCamion, fechaTurno, fechaLlegada, puertoOrigen, puertoDestino, container, cliente);
		this.fechaSalida = fechaSalida;
		
	}

	@Override
	public String getTitulo() {
		return "export";
	}



	

	public LocalDate getFechaSalida() {
		return this.fechaSalida;
	}


	


}
