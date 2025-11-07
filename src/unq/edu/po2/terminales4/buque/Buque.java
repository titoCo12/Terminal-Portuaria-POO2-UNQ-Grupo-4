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
	

	public Buque(String nombre) {
		this.nombre = nombre;
		this.fase = new FaseOutbound(this);
	}

	public void terminalDestino(Terminal terminalDestino) {
		this.terminalDestino = terminalDestino;
	}
	public void actualizarPosicion(Posicion posicion) {
		this.fase.distancia(posicion.distanciaEnKmA(this.posicionPuertoDestino()));
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
	
	public void iniciarTranajo() {
		this.fase.iniciarTrabajo();
	}
	
	public void finalizarTrabajo() {
		this.fase.finalizarTrabajo();
	}
}
