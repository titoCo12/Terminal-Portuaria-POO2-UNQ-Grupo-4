package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.terminales4.posicion.Puerto;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaRetiroCarga;
	
	public OrdenImportacion(String dniChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			Puerto puertoOrigen, Puerto puertoDestino, Container container, Cliente cliente) {
		super(dniChofer, patenteCamion, fechaTurno, fechaLlegada, puertoOrigen, puertoDestino, container, cliente);
	}

	@Override
	public String getTitulo() {
		return "import";
	}

	public LocalDate getFechaRetiroCarga() {
		return fechaRetiroCarga;
	}

	public void agreagarFechaRetiroCarga(LocalDate fechaRetiroCarga) {
		this.fechaRetiroCarga = fechaRetiroCarga;
	}

	
}
