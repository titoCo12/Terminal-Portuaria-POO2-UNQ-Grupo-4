package unq.edu.po2.terminales4.orden;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.servicio.AlmacenamientoExcedente;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;
import unq.edu.po2.terminales4.viajes.Viaje;
import unq.edu.po2.factura.*;

public class OrdenImportacion extends Orden{
	
	public OrdenImportacion(String dniChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			Puerto puertoOrigen, Puerto puertoDestino, Container container, Cliente cliente, Viaje viaje) {
		super(dniChofer, patenteCamion, fechaTurno, fechaLlegada, puertoOrigen, puertoDestino, container, cliente, viaje);
	}
	
	
	@Override
	public void accionContainer(Terminal term) {
		term.removerContainer(getContainer()); 
	}

	@Override
	public void agregarItems(Factura factura) {
		super.agregarItems(factura);
		Double valor = this.getViaje().getCircuito().precioDesdeHasta(this.puertoOrigen, this.puertoDestino);
		factura.agregarItem("valor de viaje", valor);
	}
	
	@Override
	public void accionHook() {
		int diasExcedidos = (int)Duration.between(LocalDateTime.now(), fechaTurno).toDays();
		
		if (diasExcedidos > 0) {
			this.getContainer().agregarServicio(new AlmacenamientoExcedente(1000.0, diasExcedidos));
		}
	}
	
	
	@Override
	public String getTitulo() {
		return "import";
	}

	
}
