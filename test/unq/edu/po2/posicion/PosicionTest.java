package unq.edu.po2.posicion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.posicion.Posicion;
import unq.edu.po2.terminales4.posicion.Puerto;

class PosicionTest {
	Posicion posicion1;
	Posicion posicion2;
	Puerto puerto;

	@BeforeEach
	void setUp() throws Exception {
		posicion1 = new Posicion(53, 26);
		posicion2 = new Posicion(70, 16);
		puerto = new Puerto("Malvinas", posicion2);
	}

	@Test
	void nombreDelPuerto() {
		assertEquals("Malvinas", puerto.getNombre());
	}
	
	@Test
	void distanciaEnKmAPuerto() {
		//La razón de castear el int es el pequeño margen que deja el double
		int distancia = (int) posicion1.distanciaEnKmA(puerto.getPosicion());
		assertEquals(19, distancia);
	}
}
