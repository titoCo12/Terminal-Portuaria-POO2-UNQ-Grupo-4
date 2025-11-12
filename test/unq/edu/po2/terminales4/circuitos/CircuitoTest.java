package unq.edu.po2.terminales4.circuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;

class CircuitoTest {

	Circuito circuitoCon2Puertos, circuitoCon4Puertos;
	Puerto puertoInicial, segundoPuerto, tercerPuerto, puertoNoPerteneciente, cuartoPuerto;
	int diasHastaSegundoPuerto, diasHastaTercerPuerto, diasHastaCuartoPuerto;
	double precioHastaSegundoPuerto, precioHastaTercerPuerto, precioHastaCuartoPuerto;
	
	@BeforeEach
	void setUp() throws Exception {
		
		puertoInicial = mock(Puerto.class);
		segundoPuerto = mock(Puerto.class);
		tercerPuerto = mock(Puerto.class);
		cuartoPuerto = mock(Puerto.class);
		puertoNoPerteneciente = mock(Puerto.class);
		diasHastaSegundoPuerto = 5;
		precioHastaSegundoPuerto = 1000d;
		diasHastaTercerPuerto = 12;
		precioHastaTercerPuerto = 700d;
		diasHastaCuartoPuerto = 9;
		precioHastaCuartoPuerto = 1300d;
		circuitoCon2Puertos = new Circuito("Circuito 1", puertoInicial);
		circuitoCon4Puertos = new Circuito("Circuito 2", puertoInicial);
		
		circuitoCon2Puertos.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		
		circuitoCon4Puertos.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		circuitoCon4Puertos.agregarPuerto(tercerPuerto, diasHastaTercerPuerto, precioHastaTercerPuerto);
		circuitoCon4Puertos.agregarPuerto(cuartoPuerto, diasHastaCuartoPuerto, precioHastaCuartoPuerto);
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
		
		assertEquals(puertoInicial, circuitoCon4Puertos.getOrigen());
		assertEquals(diasHastaSegundoPuerto + diasHastaTercerPuerto + diasHastaCuartoPuerto, circuitoCon4Puertos.getDuracionDias());
	}
	
	@Test
	void testPasaPorPuertoVerdadero() {
		
		assertTrue(circuitoCon4Puertos.pasaPor(segundoPuerto));
	}
	
	@Test
	void testPasaPorPuertoFalso() {
		
		
		assertFalse(circuitoCon4Puertos.pasaPor(puertoNoPerteneciente));
	}
	
	@Test
	void diasHastaSegundoPuertoEs5() {
		
		assertEquals(diasHastaSegundoPuerto, circuitoCon4Puertos.diasHasta(segundoPuerto));
	}
	
	@Test
	void diasHastaTercerPuertoEs17() {
		
		assertEquals(diasHastaSegundoPuerto + diasHastaTercerPuerto, circuitoCon4Puertos.diasHasta(tercerPuerto));
	}
	
	@Test 
	void testContieneRuta() {
		assertTrue(circuitoCon4Puertos.contieneRuta(segundoPuerto, tercerPuerto));
		assertTrue(circuitoCon4Puertos.contieneRuta(puertoInicial, tercerPuerto));
		assertTrue(circuitoCon4Puertos.contieneRuta(puertoInicial, segundoPuerto));
	}
	
	@Test 
	void testNoContieneRuta() {
		assertFalse(circuitoCon4Puertos.contieneRuta(puertoNoPerteneciente, tercerPuerto));
		assertFalse(circuitoCon4Puertos.contieneRuta(puertoInicial, puertoNoPerteneciente));
	}
	
	@Test 
	void testContienePuertos_Pero_NoContieneRuta_Falso() {
		assertFalse(circuitoCon4Puertos.contieneRuta(tercerPuerto, puertoInicial));
		assertFalse(circuitoCon4Puertos.contieneRuta(segundoPuerto, puertoInicial));
	}

	
	@Test
	void testPrecioDesdeHasta() {
		assertEquals(precioHastaSegundoPuerto, circuitoCon4Puertos.precioDesdeHasta(puertoInicial, segundoPuerto));
		assertEquals(precioHastaSegundoPuerto + precioHastaTercerPuerto, circuitoCon4Puertos.precioDesdeHasta(puertoInicial, tercerPuerto));
		assertEquals(0, circuitoCon4Puertos.precioDesdeHasta(puertoInicial, puertoInicial));
	}
	
	@Test
	void testCantidadTerminalesEntre() {
		
		assertEquals(0, circuitoCon4Puertos.cantidadTerminalesEntre(puertoInicial, segundoPuerto));
		assertEquals(1, circuitoCon4Puertos.cantidadTerminalesEntre(puertoInicial, tercerPuerto));
		assertEquals(2, circuitoCon4Puertos.cantidadTerminalesEntre(puertoInicial, cuartoPuerto));
		assertEquals(0, circuitoCon4Puertos.cantidadTerminalesEntre(puertoInicial, puertoInicial));
		assertEquals(0, circuitoCon4Puertos.cantidadTerminalesEntre(tercerPuerto, tercerPuerto));
		assertEquals(0, circuitoCon4Puertos.cantidadTerminalesEntre(segundoPuerto, tercerPuerto));
		
	}
	
	@Test
	void testDiasDesdeHasta() {
		assertEquals(diasHastaSegundoPuerto, circuitoCon4Puertos.diasDesdeHasta(puertoInicial, segundoPuerto));
		assertEquals(diasHastaSegundoPuerto + diasHastaTercerPuerto, circuitoCon4Puertos.diasDesdeHasta(puertoInicial, tercerPuerto));
		assertEquals(0, circuitoCon4Puertos.diasDesdeHasta(puertoInicial, puertoInicial));
		assertEquals(0, circuitoCon4Puertos.diasDesdeHasta(segundoPuerto, segundoPuerto));

	}
	
}
