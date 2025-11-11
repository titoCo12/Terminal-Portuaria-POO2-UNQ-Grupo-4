package unq.edu.po2.terminales4.puerto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.posicion.Posicion;
import unq.edu.po2.terminales4.posicion.Puerto;

class PuertoTest {

	Puerto puertoBsAs;
	Posicion posicion;
	@BeforeEach
	void setUp() throws Exception {
		posicion = mock(Posicion.class);
		puertoBsAs = new Puerto("Buenos Aires", posicion);
	}

	@Test
	void testNombre() {
		String nombre = puertoBsAs.getNombre();
		
		assertEquals("Buenos Aires", nombre);
	}
	
	@Test
	void testPosicion() {
		Posicion pos = puertoBsAs.getPosicion();
		
		assertEquals(posicion, pos);
	}
	
	
	

}
