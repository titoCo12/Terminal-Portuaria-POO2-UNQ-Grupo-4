package unq.edu.po2.terminales4.condicionesRutas;

import java.util.List;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;

public interface CondicionRuta {

	public List<Ruta> validarViajes(List<Viaje> viajes, Puerto origen);
	
}
