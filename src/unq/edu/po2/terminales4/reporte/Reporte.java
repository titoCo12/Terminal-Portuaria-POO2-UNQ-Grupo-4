package unq.edu.po2.terminales4.reporte;

import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;

public abstract class Reporte {

	private StringBuilder reporte;
	
	public abstract void visitBuque(Buque buque, Terminal term);
	public abstract void visitOrden(Orden orden);
	
	public void escribir(String info) {
		reporte.append(info);
	}
	
	public String devolverReporte() {
		return this.reporte.toString();	
	}
	
}
