package unq.edu.po2.terminales4.condicionesRutas;

import java.util.*;
import java.util.stream.Collectors;

import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.*;

public class CondicionAND implements CondicionRuta {

	private CondicionRuta cond1;
	private CondicionRuta cond2;
	
	public CondicionAND(CondicionRuta cond1, CondicionRuta cond2) {
		this.cond1 = cond1;
		this.cond2 = cond2;
	}
	
	/* Cabe aclarar que no podemos distinguir rutas iguales comparando por objeto, ya que aunque
	 * sean iguales son objetos instanciados por separado, por lo que los distinguimos por su "codigo"
	 * */
	
	//Se queda con las Rutas que cumplan ambas condiciones (esten en ambas listas)
	public List<Ruta> validarViajes(List<Viaje> viajes, Puerto origen) {
		List<Ruta> rutas1 = cond1.validarViajes(viajes, origen);
		List<Ruta> rutas2 = cond2.validarViajes(viajes, origen);
		
		//se supone que en java +21 me deberia dejar hacer directamente toSet() sin collectors de por 
		// medio pero al parecer no...
	    Set<String> codigos1 = rutas1.stream().map(Ruta::getCodigo).collect(Collectors.toSet());

	    //Nos quedamos solo con las rutas cuyo codigo esten en codigos1 (estan en ambas)
	    return rutas2.stream().filter(r -> codigos1.contains(r.getCodigo())).toList();
	}
	
}
