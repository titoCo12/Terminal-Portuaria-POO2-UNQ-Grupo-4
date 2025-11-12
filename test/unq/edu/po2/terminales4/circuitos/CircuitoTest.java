package unq.edu.po2.terminales4.circuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;

class CircuitoTest {

	Circuito circuitoCon2Puertos, circuitoCon3Puertos;
	Puerto puertoInicial, segundoPuerto, tercerPuerto, puertoNoPerteneciente;
	int diasHastaSegundoPuerto, diasHastaTercerPuerto;
	double precioHastaSegundoPuerto, precioHastaTercerPuerto;
	
	@BeforeEach
	void setUp() throws Exception {
		
		puertoInicial = mock(Puerto.class);
		segundoPuerto = mock(Puerto.class);
		tercerPuerto = mock(Puerto.class);
		puertoNoPerteneciente = mock(Puerto.class);
		diasHastaSegundoPuerto = 5;
		precioHastaSegundoPuerto = 1000d;
		diasHastaTercerPuerto = 12;
		precioHastaTercerPuerto = 700d;
		
		circuitoCon2Puertos = new Circuito("Circuito 1", puertoInicial);
		circuitoCon3Puertos = new Circuito("Circuito 2", puertoInicial);
		
		circuitoCon2Puertos.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		
		circuitoCon3Puertos.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		circuitoCon3Puertos.agregarPuerto(tercerPuerto, diasHastaTercerPuerto, precioHastaTercerPuerto);
	}

	@Test
	void testConstructorPuertoOrigen() {
		assertEquals(puertoInicial, circuitoCon2Puertos.getOrigen());
	}
	
	
	@Test
	void testAgregarSegundoPuertoAlCircuitoTiempo5Dias() {
		
		assertEquals(puertoInicial, circuitoCon2Puertos.getOrigen());
		assertEquals(diasHastaSegundoPuerto, circuitoCon2Puertos.getDuracionDias());
	}
	
	@Test
	void testAgregarTercerPuertoAlCircuitoTiempo5Dias() {
		
		assertEquals(puertoInicial, circuitoCon3Puertos.getOrigen());
		assertEquals(diasHastaSegundoPuerto + diasHastaTercerPuerto, circuitoCon3Puertos.getDuracionDias());
	}
	
	@Test
	void testPasaPorPuertoVerdadero() {
		
		assertTrue(circuitoCon3Puertos.pasaPor(segundoPuerto));
	}
	
	@Test
	void testPasaPorPuertoFalso() {
		
		
		assertFalse(circuitoCon3Puertos.pasaPor(puertoNoPerteneciente));
	}
	
	@Test
	void diasHastaSegundoPuertoEs5() {
		
		assertEquals(diasHastaSegundoPuerto, circuitoCon3Puertos.diasHasta(segundoPuerto));
	}
	
	@Test
	void diasHastaTercerPuertoEs17() {
		
		assertEquals(diasHastaSegundoPuerto + diasHastaTercerPuerto, circuitoCon3Puertos.diasHasta(tercerPuerto));
	}
	
	@Test 
	void testContieneRuta() {
		assertTrue(circuitoCon3Puertos.contieneRuta(segundoPuerto, tercerPuerto));
		assertTrue(circuitoCon3Puertos.contieneRuta(puertoInicial, tercerPuerto));
		assertTrue(circuitoCon3Puertos.contieneRuta(puertoInicial, segundoPuerto));
	}
	
	@Test 
	void testNoContieneRuta() {
		assertFalse(circuitoCon3Puertos.contieneRuta(puertoNoPerteneciente, tercerPuerto));
		assertFalse(circuitoCon3Puertos.contieneRuta(puertoInicial, puertoNoPerteneciente));
	}
	
	@Test 
	void testContienePuertos_Pero_NoContieneRuta_Falso() {
		assertFalse(circuitoCon3Puertos.contieneRuta(tercerPuerto, puertoInicial));
		assertFalse(circuitoCon3Puertos.contieneRuta(segundoPuerto, puertoInicial));
	}

	
	@Test
	void testPrecioDesdeHasta() {
		assertEquals(precioHastaSegundoPuerto, circuitoCon3Puertos.precioDesdeHasta(puertoInicial, segundoPuerto));
		assertEquals(precioHastaSegundoPuerto + precioHastaTercerPuerto, circuitoCon3Puertos.precioDesdeHasta(puertoInicial, tercerPuerto));
	}
	
	@Test
	void terminalesEntre() {
		
	}
	
	@Test
	void diasDesdeHasta() {
		
	}
	
}
