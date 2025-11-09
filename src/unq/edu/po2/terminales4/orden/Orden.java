package unq.edu.po2.terminales4.orden;

import java.time.LocalDate;
import java.util.ArrayList;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.servicio.Servicio;
import unq.edu.po2.terminales4.camion.Camion;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;

public abstract class Orden {
	private String nombreChofer;
	private String patenteCamion;
	private LocalDate fechaSalida;
	private LocalDate fechaLLegada;
	private String idContainer;
	private Puerto puertoOrigen;
	private Puerto puertoDestino;
	private Cliente cliente;
	private ArrayList<Servicio> servicios;
	
	public Orden(String nombreChofer, String patenteCamion, LocalDate fechaSalida, LocalDate fechaLlegada,
			String idContainer, Puerto puertoOrigen, Puerto puertoDestino, Cliente cliente) {
		this.nombreChofer = nombreChofer;
		this.patenteCamion = patenteCamion;
		this.fechaSalida = fechaSalida;
		this.fechaLLegada = fechaLlegada;
		this.idContainer = idContainer;
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.cliente = cliente;
		this.servicios = new ArrayList<Servicio>();
		
	}
	
	
	public final boolean validarPuedePasar(Camion camion, LocalDate fecha) {
		//implemementar el template
		return false;
	}
	public abstract void validarTransporte();
	public abstract void validarHorario();
	public abstract Cliente getCliente();
	public abstract void enviarFactura();
	public abstract String getTitulo();
	public abstract boolean correspondeATerminal(Terminal terminalGestionada);
	

}