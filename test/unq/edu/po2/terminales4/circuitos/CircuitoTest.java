package unq.edu.po2.terminales4.circuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;

class CircuitoTest {

	Circuito circuito;
	Puerto puertoInicial;
	
	@BeforeEach
	void setUp() throws Exception {
		
		puertoInicial = mock(Puerto.class);
		
		circuito = new Circuito("Circuito 1", puertoInicial);
	}

	@Test
	void testConstructorPuertoOrigen() {
		assertEquals(puertoInicial, circuito.getOrigen());
	}
	
	

}
