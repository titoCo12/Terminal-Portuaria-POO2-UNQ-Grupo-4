package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;
import java.util.ArrayList;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.servicio.Servicio;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;

public abstract class Orden {
	protected String dniChofer;
	protected String patenteCamion;
	protected LocalDate fechaTurno;
	protected LocalDate fechaLLegada;
	protected String idContainer;
	protected Puerto puertoOrigen;
	protected Puerto puertoDestino;
	protected Cliente cliente;
	protected ArrayList<Servicio> servicios;
	
	public Orden(String dniChofer, String patenteCamion, LocalDate fechaTurno, LocalDate fechaLlegada,
			String idContainer, Puerto puertoOrigen, Puerto puertoDestino, Cliente cliente) {
		this.dniChofer = dniChofer;
		this.patenteCamion = patenteCamion;
		this.fechaTurno = fechaTurno;
		this.fechaLLegada = fechaLlegada;
		this.idContainer = idContainer;
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.cliente = cliente;
		this.servicios = new ArrayList<Servicio>();
		
	}
	
	
	public abstract void enviarFactura();
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


	protected String getIdContainer() {
		return idContainer;
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


	

}