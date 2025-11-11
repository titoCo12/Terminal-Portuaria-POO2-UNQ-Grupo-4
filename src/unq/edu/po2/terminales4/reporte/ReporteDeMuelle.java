package unq.edu.po2.terminales4.reporte;

import java.util.*;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;

public class ReporteDeMuelle extends Reporte{

	public void visitBuque(Buque buque, Terminal term) {
		List<Orden> ordenes = this.ordenesDe(buque, term);
		String fecha = this.fechaLlegadaDe(ordenes);
		
		//nombre del buque
		this.escribir("buque: " + buque.getNombre() + "\n");
		//puerto de referencia
		this.escribir("puerto: " + term.getPuerto().getNombre() + "\n");
		//fecha de llegada al puerto
		this.escribir("llegada: " + fecha + "\n"); 
		//fecha de salida del puerto
		//sale el mismo dia que llega
		this.escribir("salida: " + fecha + "\n");
		//cantidad de containers operados
		this.escribir("containers operados: " + Integer.toString(ordenes.size()));
	}
	
	public void visitOrden(Orden orden) {}
	
}
