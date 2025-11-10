package unq.edu.po2.terminales4.reporte;

import java.util.*;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;

public class ReporteDeMuelle extends Reporte{

	public void visitBuque(Buque buque, Terminal term) {
		List<Orden> ordenes = buque.getOrdenesQueCorrespondenA(term);
		String fecha = ordenes.getFirst().getFechaLlegada().toString();
		//nombre del buque
		this.escribir(buque.getNombre() + ": \n");
		//puerto de referencia
		this.escribir("puerto: " + term.getPuerto().getNombre() + "\n");
		//fecha de llegada al puerto
		this.escribir("llegada: ");
		this.escribir(fecha + " \n");
		//fecha de salida del puerto
		//sale el mismo dia que llega
		this.escribir("salida: ");
		this.escribir(fecha + " \n");
		//cantidad de containers operados
		this.escribir("containers operados: ");
		this.escribir(Integer.toString(ordenes.size()));
	}
	
	public void visitOrden(Orden orden, Terminal term) {}
	
}
