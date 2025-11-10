package unq.edu.po2.terminales4.reporte;

import java.util.*;

import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;

public class ReporteDeMuelle extends Reporte{

	public void visitBuque(Buque buque, Terminal term) {
		List<Orden> ordenes = buque.getOrdenesQueCorrespondenA(term);
		String fecha = ordenes.getFirst().getFechaLlegada().toString();
		
		this.escribir(buque.getNombre() + ": \n");
		this.escribir("puerto: " + term.getPuerto().getNombre() + "\n");
		this.escribir("llegada: ");
		this.escribir(fecha + " \n");
		//sale el mismo dia que llega
		this.escribir("salida: ");
		this.escribir(fecha + " \n");
		this.escribir("buques operados: ");
		this.escribir(Integer.toString(ordenes.size()));
	}
	
	public void visitOrden(Orden orden, Terminal term) {}
	
}
