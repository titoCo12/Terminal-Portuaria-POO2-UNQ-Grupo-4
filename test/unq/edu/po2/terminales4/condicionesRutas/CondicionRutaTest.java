package unq.edu.po2.terminales4.condicionesRutas;

import static org.junit.Assert.assertThat;
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
	void condicionDestinoUnResultado() {
	
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
	void condicionDestinoSinResultados() {
	
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
	
	@Test
	void condicionSalidaVariosResultados() {
		
		//SetUp
		Puerto pA = mock(Puerto.class);
		Puerto pC = mock(Puerto.class);
		Puerto pD = mock(Puerto.class);
		Puerto pE = mock(Puerto.class);
		
		LocalDate fechaSalida = LocalDate.of(2025, 11, 8);
		condRuta = new CondicionSalida(fechaSalida);
		
		//viaje 1 cumple
		when(viaje1.pasaPor(origen)).thenReturn(true);
		when(viaje1.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2025, 11, 8)));
		when(viaje1.getPuertos()).thenReturn(new ArrayList<>(Arrays.asList(pA, origen, pC, pD, pE)));
		when(viaje1.fechaLlegadaA(pA)).thenReturn(Optional.of(LocalDate.of(2025, 11, 7)));
		when(viaje1.fechaLlegadaA(pC)).thenReturn(Optional.of(LocalDate.of(2025, 11, 9)));
		when(viaje1.fechaLlegadaA(pD)).thenReturn(Optional.of(LocalDate.of(2025, 11, 10)));
		when(viaje1.fechaLlegadaA(pE)).thenReturn(Optional.of(LocalDate.of(2025, 11, 11)));
		
		//viaje 2 no cumple, sale del origen en otra fecha.
		when(viaje2.pasaPor(origen)).thenReturn(true);
		when(viaje2.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 11)));
		
		//viaje3 no cumple, no pasa por el origen.
		when(viaje3.pasaPor(origen)).thenReturn(false);
		
		//Exercise
		List<Ruta> result = condRuta.validarViajes(listado, origen);
		
		//Verify
		// Hay 3 rutas, todas pertenecen al viaje 1
		/* 
		 	ruta1 = origen -> pC
			ruta2 = origen -> pC -> pD
			ruta3 = origen -> pC -> pD -> pE
		*/
		assertTrue(result.size() == 3);
		assertTrue(result.stream().allMatch(r -> r.getViaje() == viaje1));
		assertTrue(result.get(0).getDestino() == pC);
		assertTrue(result.get(1).getDestino() == pD);
		assertTrue(result.get(2).getDestino() == pE);
		
	}
	
	@Test
	void condicionSalidaSinResultados() {
		
		//SetUp
		
		LocalDate fechaSalida = LocalDate.of(2025, 11, 8);
		condRuta = new CondicionSalida(fechaSalida);
		
		//viaje 1 no cumple, no pasa por el origen
		when(viaje1.pasaPor(origen)).thenReturn(false);
		
		//viaje 2 no cumple, sale del origen en otra fecha.
		when(viaje2.pasaPor(origen)).thenReturn(true);
		when(viaje2.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2022, 10, 11)));
		
		//viaje3 no cumple, no pasa por el origen.
		when(viaje3.pasaPor(origen)).thenReturn(false);
		
		//Exercise
		List<Ruta> result = condRuta.validarViajes(listado, origen);
		
		//Verify
		// Hay 0 rutas
		assertTrue(result.size() == 0);
	}
	
	
	@Test
	void condicionLlegadaConResultados() {
		
		//SetUp
		LocalDate fechaLlegada = LocalDate.of(2025, 11, 8);
		condRuta = new CondicionLlegada(fechaLlegada);
		
		//viaje1 cumple
		when(viaje1.pasaPor(origen)).thenReturn(true);
		when(viaje1.pasaEnFecha(fechaLlegada)).thenReturn(true);
		when(viaje1.puertoEnFecha(fechaLlegada)).thenReturn(Optional.of(destino));
		when(viaje1.fechaLlegadaA(origen)).thenReturn(Optional.of(LocalDate.of(2025, 11, 5)));
		
		//viaje2 no cumple, no pasa por ningun puerto en esa fecha
		when(viaje2.pasaPor(origen)).thenReturn(true);
		when(viaje2.pasaEnFecha(fechaLlegada)).thenReturn(false);
		
		//viaje3 no cumple, no pasa por el origen
		when(viaje3.pasaPor(origen)).thenReturn(false);
		
		//Exercise
		List<Ruta> result = condRuta.validarViajes(listado, origen);
		
		//Verify
		// Solo viaje1 cumple la condicion, de este viaje debe salir una sola ruta
		assertTrue(result.size() == 1);
		assertTrue(result.getFirst().getViaje() == viaje1);
	}
	
	
	@Test
	void condicionLlegadaSinResultados() {
		
		//SetUp
		LocalDate fechaLlegada = LocalDate.of(2025, 11, 8);
		condRuta = new CondicionLlegada(fechaLlegada);
		
		//viaje1 cumple, no pasa por el origen
		when(viaje1.pasaPor(origen)).thenReturn(false);
		
		//viaje2 no cumple, no pasa por ningun puerto en esa fecha
		when(viaje2.pasaPor(origen)).thenReturn(true);
		when(viaje2.pasaEnFecha(fechaLlegada)).thenReturn(false);
		
		//viaje3 no cumple, no pasa por el origen
		when(viaje3.pasaPor(origen)).thenReturn(false);
		
		//Exercise
		List<Ruta> result = condRuta.validarViajes(listado, origen);
		
		//Verify
		// Solo viaje1 cumple la condicion, de este viaje debe salir una sola ruta
		assertTrue(result.size() == 0);
	}

}
