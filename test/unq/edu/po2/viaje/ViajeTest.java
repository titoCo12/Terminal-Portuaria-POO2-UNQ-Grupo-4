package unq.edu.po2.viaje;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.buque.Buque;
import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.viajes.Naviera;
import unq.edu.po2.terminales4.viajes.Viaje;

class ViajeTest {
	
	Viaje viaje;
	LocalDate fechaInicio;
	Circuito circuito;
	Buque buque;
	Naviera naviera;
	List<Puerto> puertosDelCircuito;
	Puerto puerto1, puerto2, puerto3, puertoQueNoPasa;
	int diasHastaPuerto1, diasHastaPuerto2, diasHastaPuerto3;
	
	@BeforeEach
	void setUp() throws Exception {
		circuito = mock(Circuito.class);
		buque =  mock(Buque.class);
		naviera = mock(Naviera.class);
		puerto1 = mock(Puerto.class);
		puerto2 = mock(Puerto.class);
		puerto3 = mock(Puerto.class);
		puertoQueNoPasa = mock(Puerto.class); 
		fechaInicio = LocalDate.now();
		diasHastaPuerto1 = 5;
		diasHastaPuerto2 = 9;
		diasHastaPuerto3 = 10;
		
		puertosDelCircuito = new ArrayList<Puerto>(Arrays.asList(puerto1, puerto2, puerto3));
		when(circuito.puertosDelCircuito()).thenReturn(puertosDelCircuito);
		when(circuito.diasHasta(puerto1)).thenReturn(diasHastaPuerto1);
		when(circuito.diasHasta(puerto2)).thenReturn(diasHastaPuerto2);
		when(circuito.diasHasta(puerto3)).thenReturn(diasHastaPuerto3);
		viaje = new Viaje(fechaInicio, circuito, buque, naviera);
	}

	@Test
	void testConstructor() {
		verify(circuito, times(1)).puertosDelCircuito();
		verify(circuito, atLeastOnce()).diasHasta(any(Puerto.class));
	}
	
	@Test
	void testPasaPorPuerto() {
		assertTrue(viaje.pasaPor(puerto1));
		assertTrue(viaje.pasaPor(puerto2));
		assertTrue(viaje.pasaPor(puerto3));
	}

	@Test
	void testNoPasaPorPuerto() {
		assertFalse(viaje.pasaPor(puertoQueNoPasa));
	}
	
	@Test
	void testPasaEnFechaLas3FechasQueSeAgregaron_Verdadero() {
		assertTrue(viaje.pasaEnFecha(fechaInicio.plusDays(diasHastaPuerto1)));
		assertTrue(viaje.pasaEnFecha(fechaInicio.plusDays(diasHastaPuerto1+diasHastaPuerto2)));
		assertTrue(viaje.pasaEnFecha(fechaInicio.plusDays(diasHastaPuerto1+diasHastaPuerto2+diasHastaPuerto3)));
	}
	
	@Test
	void testNoPasaEnFechaQueSeAgregaron_Falso() {
		int diasQueNoEstaEnViaje = 100;
		assertFalse(viaje.pasaEnFecha(fechaInicio.plusDays(diasQueNoEstaEnViaje)));
	}
	
	@Test
	void testPuertosDelViaje() {
		assertEquals(puertosDelCircuito, viaje.getPuertos());
	}
	
}
