package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.terminales4.posicion.Puerto;

public class OrdenImportacion extends Orden{
	
	public OrdenImportacion(String dniChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			String idContainer, Puerto puertoOrigen, Puerto puertoDestino, Cliente cliente) {
		super(dniChofer, patenteCamion, fechaTurno, fechaLlegada, idContainer, puertoOrigen, puertoDestino, cliente);
	}

	@Override
	public void enviarFactura() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitulo() {
		// TODO Auto-generated method stub
		return "import";
	}

	
	
}
