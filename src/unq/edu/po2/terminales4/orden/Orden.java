package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;
import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.factura.Factura;
import unq.edu.po2.factura.Item;
import unq.edu.po2.terminales4.camion.*;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;
import unq.edu.po2.terminales4.viajes.Viaje;

public abstract class Orden {
	protected String dniChofer;
	protected String patenteCamion;
	protected LocalDate fechaTurno;
	protected LocalDate fechaLLegada;
	protected Puerto puertoOrigen;
	protected Puerto puertoDestino;
	protected Cliente cliente;
	private Container container;
	private Viaje viaje;
	
	public Orden(String dniChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			Puerto puertoOrigen, Puerto puertoDestino, Container container, Cliente cliente, Viaje viaje) {
		this.dniChofer = dniChofer;
		this.patenteCamion = patenteCamion;
		this.fechaTurno = fechaTurno;
		this.fechaLLegada = fechaLlegada;
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.container = container;
		this.cliente = cliente;
		this.viaje = viaje;
	}
	
	public abstract String getTitulo();
	
	public boolean correspondeATerminal(Terminal terminalGesionada) {
		return terminalGesionada.getPuerto().getNombre().equals(this.getPuertoDestino().getNombre()) ;
	}

	public  String getDniChofer() {
		return dniChofer;
	}


	public String getPatenteCamion() {
		return patenteCamion;
	}


	public LocalDate getFechaTurno() {
		return fechaTurno;
	}


	public LocalDate getFechaLlegada() {
		return fechaLLegada;
	}

	public Puerto getPuertoOrigen() {
		return puertoOrigen;
	}

	public Puerto getPuertoDestino() {
		return puertoDestino;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Container getContainer() {
		return this.container;
	}
	
	public void enviarFactura() {
		Factura factura = this.crearFactura();
		this.getCliente().recibirFactura(factura);	
	}
	
	public Factura crearFactura() {
		Factura factura = new Factura();
	    this.agregarItems(factura);
	    return factura;
	}
	
	public void agregarItems(Factura factura) {
		this.container.getServicios()
					.stream()
					.forEach( s -> factura.agregarItem(
							new Item(s.getNombre(), s.getMontoFinal(container))
					));
	}
	
	//patron template si no coincide el camion o chofer no se hace nada
	public final void manejarLlegada(Terminal term, Camion cam) {
		if (this.condicionTransporte(cam)) {
			this.accionContainer(term);
			this.accionHook();
		}
	}
	
	private boolean condicionTransporte(Camion cam) {
		return this.esMismoCamionQueEnOrden(cam) && this.esMismoChoferQueEnOrden(cam);
	}
	
		
	private boolean esMismoChoferQueEnOrden(Camion cam) {
		return cam.getChofer().getDni().equals(this.getDniChofer());
	}

	private boolean esMismoCamionQueEnOrden(Camion cam) {
		return cam.getPatente().equals(this.getPatenteCamion());
	}
	
	public abstract void accionContainer(Terminal term);
	
	public void accionHook() {};
	
	public Viaje getViaje() {
		return this.viaje;
	}
	

}