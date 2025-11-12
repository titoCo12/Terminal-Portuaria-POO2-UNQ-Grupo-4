package unq.edu.po2.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.container.*;
import unq.edu.po2.terminales4.orden.Orden;

class ServicioTest {
	Lavado lavado;
	Electricidad electricidad;
	Pesado pesado;
	AlmacenamientoExcedente excedente;
	ContainerReefer reefer;
	Orden orden;

	@BeforeEach
	void setUp() throws Exception {
		lavado = new Lavado(100.0, 200.0);
		electricidad = new Electricidad(3.0);
		pesado = new Pesado(400.0);
		excedente = new AlmacenamientoExcedente(1500.0, 2);
		reefer = mock(ContainerReefer.class);
		orden = mock(Orden.class);
	}

	@Test
	void montoFinalDeLavado() {
		when(reefer.getDimensionesCubicas()).thenReturn(80);
		
		double monto = lavado.getMontoFinal(reefer);
		
		assertEquals(200, monto);
	}
	
	@Test
	void montoFinalDeElectricidad() {
		/*
		 * LocalDateTime.of(2022, 12, 18, 12, 00), 
		 * LocalDateTime.of(2026, 06, 11, 12, 00));
		 */
		when(reefer.getConsumoXHora()).thenReturn(100.0);
		when(reefer.getMomentoConexion()).thenReturn(LocalDateTime.of(2025, 11, 11, 12, 00));
		when(reefer.getMomentoDesconexion()).thenReturn(LocalDateTime.of(2025, 11, 11, 14, 00));
		
		double monto = electricidad.getMontoFinal(reefer);
		
		assertEquals(600.0, monto);
	}
	
	@Test
	void montoFinalDePesado() {
		double monto = pesado.getMontoFinal(reefer); 
		
		assertEquals(400.0, monto);
	}
	
	@Test
	void montoFinalDeAlmacenamientoExcedente() {
		double monto = excedente.getMontoFinal(reefer);
		
		assertEquals(3000.0, monto);
	}

}
