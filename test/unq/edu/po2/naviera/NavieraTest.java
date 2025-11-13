package unq.edu.po2.naviera;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.viajes.Naviera;

class NavieraTest {
	Naviera jimmy;
	Circuito circuito1;
	Circuito circuito2;
	List<Circuito> circuitos;
	Puerto origen;
	Puerto destino;

	@BeforeEach
	void setUp() throws Exception {
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuitos = Arrays.asList(circuito1, circuito2);
		jimmy = new Naviera("Jimmy", circuitos);
		origen = mock(Puerto.class);
		destino = mock(Puerto.class);
		
	}

	@Test
	void nombreDeNaviera() {
		assertEquals("Jimmy", jimmy.getNombre());
	}
	
	@Test
	void menorTiempoHastaOrigenYDestino() {
		when(circuito1.diasDesdeHasta(origen, destino)).thenReturn(5);
		when(circuito2.diasDesdeHasta(origen, destino)).thenReturn(3);
		
		int tiempo = jimmy.mejorTiempoHasta(origen, destino);
		
		assertEquals(3, tiempo);
	}

}
