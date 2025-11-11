package unq.edu.po2.terminales4.tramo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Tramo;
import unq.edu.po2.terminales4.posicion.Puerto;

class TramoTest {
	Puerto puertoDestino;
	Puerto puertoOrigen;
	double precio;
	int tiempoEnDias;
	Tramo tramo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		puertoOrigen = mock(Puerto.class);
		puertoDestino = mock(Puerto.class);
		tiempoEnDias = 30;
		precio = 4.5d;
		
		tramo = new Tramo(puertoOrigen, puertoDestino, precio, tiempoEnDias);
	}

	@Test
	void testConstructor() {
		assertEquals(puertoOrigen, tramo.getOrigen());
		assertEquals(puertoDestino, tramo.getDestino());
		assertEquals(precio, tramo.precioTramo());
		assertEquals(tiempoEnDias, tramo.tiempoEnDias());
	}

}
