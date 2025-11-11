package unq.edu.po2.terminales4.circuito;

import java.util.*;
import unq.edu.po2.terminales4.posicion.*;

public class CriterioMenorTiempo implements CriterioCircuito{

	public Optional<Circuito> mejorCircuito(List<Circuito> circuitos, Puerto origen, Puerto destino) {
		return circuitos.stream().min(Comparator.comparing(c -> c.diasDesdeHasta(origen,destino)));
	}
	
}
