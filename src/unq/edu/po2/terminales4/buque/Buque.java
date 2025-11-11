package unq.edu.po2.terminales4.buque;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.reporte.*;
import unq.edu.po2.terminales4.terminal.*;

public class Buque{

	private String nombre;
	private FaseBuque fase;
	private Terminal terminalDestino;
	private List<Orden> ordenes;
	private Posicion posicion;
	

	public Buque(String nombre) {
		this.nombre = nombre;
		this.ordenes = new ArrayList<Orden>();
		this.fase = new FaseOutbound(this);
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarOrden(Orden orden) {
		this.ordenes.add(orden);
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
		this.terminalDestino.preavisoBuque(this.getOrdenesQueCorrespondenA(terminalDestino));
		
	}
	
	protected void avisarSalidaATerminal() {
		this.terminalDestino.buqueSaliendo(this);
	}
	public void iniciarTrabajo() {
		this.fase.iniciarTrabajo();
	}
	
	public void depart() {
		this.fase.depart();
	}

	public void enviarFacturas() {		
		this.getOrdenesQueCorrespondenA(this.terminalDestino).forEach(orden -> orden.enviarFactura());
	}
	
	public List<Orden> getOrdenesQueCorrespondenA(Terminal terminal) {
        return ordenes.stream()
            .filter(o -> o.correspondeATerminal(terminal))
            .collect(Collectors.toList());
    }
	
	public void acceptReporte(Reporte reporte, Terminal terminal) {
		reporte.visitBuque(this, terminal);
	}
}
