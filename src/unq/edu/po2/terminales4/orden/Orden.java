package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;
import java.util.ArrayList;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.factura.Factura;
import unq.edu.po2.servicio.Servicio;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;

public abstract class Orden {
	protected String dniChofer;
	protected String patenteCamion;
	protected LocalDate fechaTurno;
	protected LocalDate fechaLLegada;
	protected Puerto puertoOrigen;
	protected Puerto puertoDestino;
	protected Cliente cliente;
	protected ArrayList<Servicio> servicios;
	private Container container;
	
	public Orden(String dniChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			Puerto puertoOrigen, Puerto puertoDestino, Container container, Cliente cliente) {
		this.dniChofer = dniChofer;
		this.patenteCamion = patenteCamion;
		this.fechaTurno = fechaTurno;
		this.fechaLLegada = fechaLlegada;
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.container = container;
		this.cliente = cliente;
		this.servicios = new ArrayList<Servicio>();
		
	}
	
	
	public abstract String getTitulo();
	public boolean correspondeATerminal(Terminal terminalGesionada) {
		return terminalGesionada.getPuerto().getNombre().equals(this.getPuertoDestino().getNombre()) ;
	}


	protected  String getDniChofer() {
		return dniChofer;
	}


	protected String getPatenteCamion() {
		return patenteCamion;
	}


	protected LocalDate getFechaTurno() {
		return fechaTurno;
	}


	public LocalDate getFechaLLegada() {
		return fechaLLegada;
	}


	

	protected Puerto getPuertoOrigen() {
		return puertoOrigen;
	}


	protected Puerto getPuertoDestino() {
		return puertoDestino;
	}


	protected Cliente getCliente() {
		return cliente;
	}


	protected ArrayList<Servicio> getServicios() {
		return servicios;
	}

	protected Container getContainer() {
		return this.container;
	}
	
	public void enviarFactura() {
		Factura factura = this.crearFactura();
		this.getCliente().recibirFactura(factura);
		
	}

	private Factura crearFactura() {
		// TODO Auto-generated method stub
		return new Factura();
	}

}