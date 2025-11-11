package unq.edu.po2.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
		lavado = mock(Lavado.class);
		electricidad = mock(Electricidad.class);
		pesado = mock(Pesado.class);
		excedente = mock(AlmacenamientoExcedente.class);
		reefer = mock(ContainerReefer.class);
		orden = mock(Orden.class);
	}

	@Test
	void montoFinalDeLavado() {
		
		when(lavado.getMontoFinal(reefer)).thenReturn(600.0);
		
		double monto = lavado.getMontoFinal(reefer);
		
		verify(lavado).getMontoFinal(reefer);
		
		assertEquals(600.0, monto);
	}
	
	@Test
	void montoFinalDeElectricidad() {
		when(electricidad.getMontoFinal(reefer)).thenReturn(500.0);
		
		double monto = electricidad.getMontoFinal(reefer);
		
		verify(electricidad).getMontoFinal(reefer);
		
		assertEquals(500.0, monto);
	}
	
	@Test
	void montoFinalDePesado() {
		when(pesado.getMontoFinal(reefer)).thenReturn(200.0);
		
		double monto = pesado.getMontoFinal(reefer);
		
		verify(pesado).getMontoFinal(reefer);
		
		assertEquals(200.0, monto);
	}
	
	@Test
	void montoFinalDeAlmacenamientoExcedente() {
		when(excedente.getMontoFinal(orden)).thenReturn(1500.0);
		
		double monto = excedente.getMontoFinal(orden);
		
		verify(excedente).getMontoFinal(orden);
		
		assertEquals(1500.0, monto);
	}

}
