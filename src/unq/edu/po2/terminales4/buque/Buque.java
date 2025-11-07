package unq.edu.po2.terminales4.buque;

import java.util.List;

import unq.edu.po2.terminales4.orden.Orden;
import unq.edu.po2.terminales4.posicion.Posicion;
import unq.edu.po2.terminales4.terminal.Terminal;

public class Buque{

	private String nombre;
	private FaseBuque fase;
	private Terminal terminalDestino;
	private List<Orden> ordenes;
	private Posicion posicion;
	

	public Buque(String nombre, List<Orden> ordenes) {
		this.nombre = nombre;
		this.ordenes = ordenes;
		this.fase = new FaseOutbound(this);
	}

	public void terminalDestino(Terminal terminalDestino) {
		this.terminalDestino = terminalDestino;
	}
	public void actualizarPosicion(Posicion posicion) {
		this.posicion = posicion;
		this.fase.evaluarDistanciaADestino(posicion.distanciaEnKmA(this.posicionPuertoDestino()));
	}

	public Posicion posicion() {
		return this.posicion;
	}
	private Posicion posicionPuertoDestino() {
		
		return this.terminalDestino.posicion();
	}

	protected void setFase(FaseBuque fase) {
		this.fase = fase;
		
	}

	protected void avisarArriboATerminal() {
		this.terminalDestino.preavisoBuque();
		
	}
	
	protected void avisarSalidaATerminal() {
		this.terminalDestino.buqueSaliendo();
	}
	public void iniciarTrabajo() {
		this.fase.iniciarTrabajo();
	}
	
	public void depart() {
		this.fase.depart();
	}
}
