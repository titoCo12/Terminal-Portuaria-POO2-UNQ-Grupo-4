package unq.edu.po2.terminales4.condicionesRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.viajes.*;
import unq.edu.po2.terminales4.posicion.*;

class CondicionRutaTest {

	private CondicionRuta condRuta;
	private Viaje viaje1;
	private Viaje viaje2;
	private Viaje viaje3;
	private Puerto origen;
	private Puerto destino;
	private List<Viaje> listado;
	
	@BeforeEach
	void setUp() {
		viaje1 = mock(Viaje.class);
		viaje2 = mock(Viaje.class);
		viaje3 = mock(Viaje.class);
		origen = mock(Puerto.class);
		destino = mock(Puerto.class);
		listado = new ArrayList<>();
		listado.add(viaje1);
		listado.add(viaje2);
		listado.add(viaje3);
	}
	
	/* Validar de CondicionDestino verifica que el viaje pase por un
	 *   puerto especifico
	 * */
	
	@Test
	void CondicionDestinoAcertado() {
	
		//setup
		condRuta = new CondicionDestino(destino);
		
		//viaje 1 cumple.
		when(viaje1.pasaPor(destino)).thenReturn(true);
		when(viaje1.pasaPor(origen)).thenReturn(true);
		when(viaje1.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2022, 10, 10)));
		when(viaje1.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 7)));
		
		//viaje 2 no cumple, pasa por origen despues de pasar por destino.
		when(viaje2.pasaPor(destino)).thenReturn(true);
		when(viaje2.pasaPor(origen)).thenReturn(true);
		when(viaje2.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2022, 10, 10)));
		when(viaje2.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 11)));
		
		//viaje3 no cumple, no pasa por el puerto destino.
		when(viaje3.pasaPor(destino)).thenReturn(false);
		when(viaje3.pasaPor(origen)).thenReturn(true);
		when(viaje3.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2022, 10, 9)));
		when(viaje3.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 5)));
		
		// Exercise
		List<Ruta> result = condRuta.validarViajes(listado, origen);
		
		
		//Verify
		// Solo debe haber una ruta resultante en este validar de condicion, siendo la ruta que encuentre de viaje1
		assertTrue(result.size() == 1);
		assertTrue(result.getFirst().getViaje() == viaje1);
		
	}
	
	@Test
	void CondicionDestinoSinResultados() {
	
		//setup
		condRuta = new CondicionDestino(destino);
		
		//viaje 1 no cumple, no pasa por el puerto origen
		when(viaje1.pasaPor(destino)).thenReturn(true);
		when(viaje1.pasaPor(origen)).thenReturn(false);
		when(viaje1.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2022, 10, 10)));
		when(viaje1.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 7)));
		
		//viaje 2 no cumple, pasa por origen despues de pasar por destino.
		when(viaje2.pasaPor(destino)).thenReturn(true);
		when(viaje2.pasaPor(origen)).thenReturn(true);
		when(viaje2.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2022, 10, 10)));
		when(viaje2.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 11)));
		
		//viaje3 no cumple, no pasa por el puerto destino.
		when(viaje3.pasaPor(destino)).thenReturn(false);
		when(viaje3.pasaPor(origen)).thenReturn(true);
		when(viaje3.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2022, 10, 9)));
		when(viaje3.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 5)));
		
		// Exercise
		List<Ruta> result = condRuta.validarViajes(listado, origen);
		
		
		//Verify
		// No hay ninguna ruta resultante.
		assertTrue(result.isEmpty());
	}

}
