package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;

public class OrdenExportacion extends Orden {



	public OrdenExportacion(String nombreChofer, String patenteCamion, LocalDate fechaSalida, LocalDate fechaLlegada,
			String idContainer, Puerto puertoOrigen, Puerto puertoDestino, Cliente cliente) {
		super(nombreChofer, patenteCamion, fechaSalida, fechaLlegada, idContainer, puertoOrigen, puertoDestino, cliente);
		
	}

	@Override
	public void validarTransporte() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarHorario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enviarFactura() {
		// TODO Auto-generated method stub
		
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

}
