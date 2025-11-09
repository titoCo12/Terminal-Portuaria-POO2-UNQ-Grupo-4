package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;

public class OrdenExportacion extends Orden {

	private LocalDate fechaSalida;

	public OrdenExportacion(String nombreChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			String idContainer, Puerto puertoOrigen, Puerto puertoDestino, Cliente cliente, LocalDate fechaSalida) {
		super(nombreChofer, patenteCamion, fechaTurno, fechaLlegada, idContainer, puertoOrigen, puertoDestino, cliente);
		this.fechaSalida = fechaSalida;
		
	}

	@Override
	public String getTitulo() {
		return "export";
	}

	@Override
	public boolean correspondeATerminal(Terminal terminalGestionada) {
		// TODO Auto-generated method stub
		return false;
	}

	

	public LocalDate getFechaSalida() {
		return this.fechaSalida;
	}

	@Override
	public void enviarFactura() {
		// TODO Auto-generated method stub
		
	}




}
