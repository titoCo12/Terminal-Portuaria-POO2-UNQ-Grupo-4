package unq.edu.po2.terminales4.reporte;

import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;
import java.util.*;

public abstract class Reporte {

	private StringBuilder reporte = new StringBuilder();
	
	public abstract void visitBuque(Buque buque, Terminal term);
	public abstract void visitOrden(Orden orden);
	
	protected List<Orden> ordenesDe(Buque buque, Terminal term) {
	    return buque.getOrdenesQueCorrespondenA(term);
	}
	
	//considera caso en el que un buque no cargue ni descargue nada en un puerto
	protected String fechaLlegadaDe(List<Orden> ordenes) {
	    return ordenes.isEmpty() ? "--/--/--" : ordenes.get(0).getFechaLlegada().toString();
	}
	
	public void escribir(String info) {
		reporte.append(info);
	}
	
	public String devolverReporte() {
		return this.reporte.toString();	
	}
	
}
