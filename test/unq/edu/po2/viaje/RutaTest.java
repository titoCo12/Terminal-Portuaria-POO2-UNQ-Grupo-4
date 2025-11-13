package unq.edu.po2.viaje;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.viajes.Ruta;
import unq.edu.po2.terminales4.viajes.Viaje;

class RutaTest {
	Ruta ruta;
	Puerto puerto1,puerto2;
	Viaje viaje;
	
	@BeforeEach
	void setUp() throws Exception {
		viaje = mock(Viaje.class);;	
		puerto1 = mock(Puerto.class);
		puerto2 = mock(Puerto.class);
		ruta = new Ruta(puerto1, puerto2, viaje);
	}

	@Test
	void testGetCodigo() {
		when(puerto1.getNombre()).thenReturn("Puerto1");
		when(puerto2.getNombre()).thenReturn("Puerto2");
		when(viaje.getCodigo()).thenReturn("BV2VA");
		
		assertEquals("Puerto1Puerto2BV2VA", ruta.getCodigo());
	}

}
