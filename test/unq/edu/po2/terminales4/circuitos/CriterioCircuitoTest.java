package unq.edu.po2.terminales4.circuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unq.edu.po2.terminales4.circuito.*;
import unq.edu.po2.terminales4.posicion.*;


class CriterioCircuitoTest {

	//Importante aclaracion: Un criterio siempre devuelve almenos un circuito,
	// a menos que el motor de busqueda no le pase ninguno.
	
	private CriterioCircuito criterio;
	private Circuito c1;
	private Circuito c2;
	private Circuito c3;
	private Optional<Circuito> result;
	private List<Circuito> circuitos;
	private Puerto origen;
	private Puerto destino;
	
	
	@BeforeEach
	void setUp() {
		c1 = mock(Circuito.class);
		c2 = mock(Circuito.class);
		c3 = mock(Circuito.class);
		origen = mock(Puerto.class);
		destino = mock(Puerto.class);
		circuitos = new ArrayList<Circuito>();
		circuitos.add(c1);
		circuitos.add(c2);
		circuitos.add(c3);
	}
	
	@Test
	void criterioMenorTiempo() {
		
		//Setup
		criterio = new CriterioMenorTiempo();
		
		when(c1.diasDesdeHasta(origen, destino)).thenReturn(10);
		when(c2.diasDesdeHasta(origen, destino)).thenReturn(5);
		when(c3.diasDesdeHasta(origen, destino)).thenReturn(12);
		
		//Exercise
		result = criterio.mejorCircuito(circuitos, origen, destino);
		
		assertEquals(c2, result.get());
	}
	
	@Test
	void criterioMenorPrecio() {
		
		//Setup
		criterio = new CriterioMenorPrecio();
		
		when(c1.precioDesdeHasta(origen, destino)).thenReturn(1000.0);
		when(c2.precioDesdeHasta(origen, destino)).thenReturn(500.0);
		when(c3.precioDesdeHasta(origen, destino)).thenReturn(120.0);
		
		//Exercise
		result = criterio.mejorCircuito(circuitos, origen, destino); 
		
		assertEquals(c3, result.get());
	}
	
	@Test
	void criterioMenosTerminales() {
		
		//Setup
		criterio = new CriterioMenosTerminales();
		
		when(c1.cantidadTerminalesEntre(origen, destino)).thenReturn(7);
		when(c2.cantidadTerminalesEntre(origen, destino)).thenReturn(12);
		when(c3.cantidadTerminalesEntre(origen, destino)).thenReturn(9);
		
		//Exercise
		result = criterio.mejorCircuito(circuitos, origen, destino);
		
		assertEquals(c1, result.get());
	}

}
