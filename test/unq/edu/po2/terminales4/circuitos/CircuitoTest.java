package unq.edu.po2.terminales4.circuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;

class CircuitoTest {

	Circuito circuito;
	Puerto puertoInicial, segundoPuerto, tercerPuerto, puertoNoPerteneciente;
	int diasHastaSegundoPuerto, diasHastaTercerPuerto;
	double precioHastaSegundoPuerto, precioHastaTercerPuerto;
	
	@BeforeEach
	void setUp() throws Exception {
		
		puertoInicial = mock(Puerto.class);
		segundoPuerto = mock(Puerto.class);
		tercerPuerto = mock(Puerto.class);
		diasHastaSegundoPuerto = 5;
		precioHastaSegundoPuerto = 1000d;
		diasHastaTercerPuerto = 12;
		precioHastaTercerPuerto = 700d;
		
		circuito = new Circuito("Circuito 1", puertoInicial);
	}

	@Test
	void testConstructorPuertoOrigen() {
		assertEquals(puertoInicial, circuito.getOrigen());
	}
	
	
	@Test
	void testAgregarSegundoPuertoAlCircuitoTiempo5Dias() {
		
		circuito.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		assertEquals(puertoInicial, circuito.getOrigen());
		assertEquals(diasHastaSegundoPuerto, circuito.getDuracion());
	}
	
	@Test
	void testAgregarTercerPuertoAlCircuitoTiempo5Dias() {
		circuito.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		circuito.agregarPuerto(tercerPuerto, diasHastaTercerPuerto, precioHastaTercerPuerto);
		assertEquals(puertoInicial, circuito.getOrigen());
		assertEquals(diasHastaSegundoPuerto + diasHastaTercerPuerto, circuito.getDuracion());
	}
	
	@Test
	void testPasaPorPuertoVerdadero() {
		circuito.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		circuito.agregarPuerto(tercerPuerto, diasHastaTercerPuerto, precioHastaTercerPuerto);
		assertTrue(circuito.pasaPor(segundoPuerto));
	}
	
	@Test
	void testPasaPorPuertoFalso() {
		puertoNoPerteneciente = mock(Puerto.class);
		circuito.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		circuito.agregarPuerto(tercerPuerto, diasHastaTercerPuerto, precioHastaTercerPuerto);
		assertFalse(circuito.pasaPor(puertoNoPerteneciente));
	}
	
	@Test
	void diasHastaSegundoPuertoEs5() {
		circuito.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		circuito.agregarPuerto(tercerPuerto, diasHastaTercerPuerto, precioHastaTercerPuerto);
		assertEquals(diasHastaSegundoPuerto, circuito.diasHasta(segundoPuerto));
	}
	
	@Test
	void diasHastaTercerPuertoEs17() {
		circuito.agregarPuerto(segundoPuerto, diasHastaSegundoPuerto, precioHastaSegundoPuerto);
		circuito.agregarPuerto(tercerPuerto, diasHastaTercerPuerto, precioHastaTercerPuerto);
		assertEquals(diasHastaSegundoPuerto + diasHastaTercerPuerto, circuito.diasHasta(tercerPuerto));
	}
	
}
