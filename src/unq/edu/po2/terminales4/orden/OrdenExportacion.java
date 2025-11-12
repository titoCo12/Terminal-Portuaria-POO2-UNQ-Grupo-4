package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;
import unq.edu.po2.terminales4.viajes.Viaje;

public class OrdenExportacion extends Orden {

	private LocalDate fechaSalida;

	public OrdenExportacion(String nombreChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			Puerto puertoOrigen, Puerto puertoDestino, Container container, Cliente cliente, LocalDate fechaSalida, Viaje viaje) {
		super(nombreChofer, patenteCamion, fechaTurno, fechaLlegada, puertoOrigen, puertoDestino, container, cliente, viaje);
		this.fechaSalida = fechaSalida;
		
	}

	@Override
	public String getTitulo() {
		return "export";
	}
	
	@Override
	public void accionContainer(Terminal term) {
		term.almacenarContainer(getContainer());
	}
	
	
	public LocalDate getFechaSalida() {
		return this.fechaSalida;
	}


	


}
