package unq.edu.po2.terminales4.reporte;

import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;

public class ReporteDeMuelle extends Reporte{

	public void visitBuque(Buque buque, Terminal term) {
		this.escribir(buque.getNombre() + ": \n");
		this.escribir("puerto: " + term.getPuerto().getNombre() + "\n");
		this.escribir("llegada: ");
		this.escribir(buque.getOrdenesQueCorrespondenA(term).getFirst().getLlegada() + " \n");
		//sale el mismo dia que llega
		this.escribir("salida: ");
		this.escribir(buque.getOrdenesQueCorrespondenA(term).getFirst().getLlegada() + " \n");
		this.escribir("buques operados: ");
		this.escribir(Integer.toString(buque.getOrdenesQueCorrespondenA(term).size()));
	}
	
	public void visitOrden(Orden orden, Terminal term) {}
	
}
