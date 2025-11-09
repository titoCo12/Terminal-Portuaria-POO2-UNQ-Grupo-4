package unq.edu.po2.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Contenedor implements ContenidoCarga {
	List<ContenidoCarga> contenidos = new ArrayList<>();
	
	public Contenedor(List<ContenidoCarga> contenidos) {
		this.contenidos = contenidos;
	}
	
	public void agregarContenido(ContenidoCarga contenido) {
		contenidos.add(contenido);
	}

	@Override
	public int getPesoKilos() {
		
		return pesoDeContenidos(contenidos);
	}
	
	public int pesoDeContenidos(List<ContenidoCarga> contenidos) {
		return contenidos.stream().mapToInt(ContenidoCarga::getPesoKilos).sum();
	}
	
	//Sólo el dry se puede subdividir con un servicio extra "Desconsolidado" por eso usé "distinct().collect(Collectors.joining(", ")"
	@Override
	public String getTipoProducto() {
		return contenidos.stream().map(ContenidoCarga::getTipoProducto).distinct().collect(Collectors.joining(", "));
	}

}
