package unq.edu.po2.terminales4.reporte;

import java.util.*;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.terminal.*;

public class ReporteDeAduana extends Reporte{

	
	public void visitBuque(Buque buque, Terminal term) {
		List<Orden> ordenes = this.ordenesDe(buque, term);
		String fecha = this.fechaLlegadaDe(ordenes);
		
		//boilerplate de html con tags, head y elementos meta tipicos
		this.escribir(this.boilerplateHTML());
		//nombre del puerto
		this.escribir("<h1>" + term.getPuerto().getNombre() + "</h1>\n");
		//nombre del buque
		this.escribir("<h2> Buque: " + buque.getNombre() + "</h2>\n");
		//fecha de llegada
		this.escribir("<h2> Llegada: " + fecha + "</h2>\n");
		//fecha de salida (igual a llegada)
		this.escribir("<h2> Salida: " + fecha + "</h2>\n");
		//principio de lista
		this.escribir("<ul>\n");
		
		//listar los containers (orden = un container)
		ordenes.forEach(o -> this.visitOrden(o));
		
		//cerramos lista y html
		this.escribir("</ul>\n</body>\n</html>");
	}
	
	public void visitOrden(Orden orden) {
		String id = orden.getContainer().getIdentificador();
		String tipo = orden.getContainer().getTipo();
		//anotar como elemento de la lista 
		this.escribir("<li> id:" + id + " - tipo: " + tipo + "</li>\n");
	}
	
	//tipica boilerplate para todo archivo html
	private String boilerplateHTML() {
		return "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"<title>Reporte de Aduana</title>\n" + 
				"</head>\n" + 
				"<body>\n";
	}
	
}
