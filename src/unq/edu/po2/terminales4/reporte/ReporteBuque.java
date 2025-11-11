package unq.edu.po2.terminales4.reporte;

import java.util.*;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;

public class ReporteBuque extends Reporte{
	
	
	public void visitBuque(Buque buque, Terminal term) {
		//agarra imports y exports que le corresponden a esta terminal de ese buque
		List<Orden> ordenes = buque.getOrdenesQueCorrespondenA(term);
		//separo en imports y exports
		List<Orden> imps = ordenes.stream().filter(o -> o.getTitulo() == "import").toList();
		List<Orden> exps = ordenes.stream().filter(o -> o.getTitulo() == "export").toList();
		
		//abre reporte para imports
		this.escribir("<report>\n <import>");
		imps.forEach(o -> this.visitOrden(o));
		//cierra para imports, abre para exports
		this.escribir(" </import>\n <export>\n");
		exps.forEach(o -> this.visitOrden(o));
		//cierra para exports y reporte
		this.escribir(" </export>\n</report>");
	}
	
	public void visitOrden(Orden orden) {
		this.escribir("  <item>" + orden.getContainer().getIdentificador() + "<item>\n");
	}
	
}
