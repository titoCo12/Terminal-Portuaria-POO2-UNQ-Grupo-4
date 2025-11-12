package unq.edu.po2.terminales4.terminal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.circuito.CriterioCircuito;
import unq.edu.po2.terminales4.condicionesRutas.CondicionRuta;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.viajes.Ruta;
import unq.edu.po2.terminales4.viajes.Viaje;

class MotorDeBusquedaTest {

	private MotorDeBusqueda motor;
	private Viaje v1;
	private Viaje v2;
	private Circuito c1;
	private Circuito c2;
	private List<Viaje> viajes;
	private List<Circuito> circuitos;
	
	
	@BeforeEach
	void setUp() {
		c1 = mock(Circuito.class);
		c2 = mock(Circuito.class);
		v1 = mock(Viaje.class);
		v2 = mock(Viaje.class);
		
		viajes = new ArrayList<>();
		viajes.add(v1); viajes.add(v2);
		circuitos = new ArrayList<>();
		circuitos.add(c1); circuitos.add(c2);
		motor = new MotorDeBusqueda(viajes, circuitos);
	} 
	
	@Test
	void agregarViajesYCircuitos() {
		
		//el motor tiene 2 viajes y 2 circuitos
		assertEquals(2, motor.cantViajes());
		assertEquals(2, motor.cantCircuitos());
		
		//al agregarle 1 y 1, ahora tiene 3 en ambos :P
		motor.agregarCircuito(mock(Circuito.class));
		motor.agregarViaje(mock(Viaje.class));
		
		assertEquals(3, motor.cantViajes());
		assertEquals(3, motor.cantCircuitos());
	}

	@Test
	void busquedaDeRutas() {
		Puerto origen = mock(Puerto.class);
		CondicionRuta cond = mock(CondicionRuta.class);
		Ruta r1 = mock(Ruta.class);
		Ruta r2 = mock(Ruta.class);
		Ruta r3 = mock(Ruta.class);
		Ruta r4 = mock(Ruta.class);
		
		List<Ruta> resultado = new ArrayList<Ruta>();
		resultado.add(r1);
		resultado.add(r2);
		resultado.add(r3);
		resultado.add(r4);
		
		when(cond.validarViajes(viajes, origen)).thenReturn(resultado);
		
		List<Ruta> ret = motor.busquedaRutas(origen, cond);
		
		verify(cond, times(1)).validarViajes(viajes, origen); 
		assertTrue(ret.size() == 4);
	}
	
	@Test
	void mejorCircuito() {
		//Setup
		Puerto origen = mock(Puerto.class);
		Puerto destino = mock(Puerto.class);
		CriterioCircuito criterio = mock(CriterioCircuito.class);
		List<Circuito> filtrados = new ArrayList<>();
		filtrados.add(c1);
		
		when(c1.contieneRuta(origen, destino)).thenReturn(true);
		when(c2.contieneRuta(origen, destino)).thenReturn(false);
		
		when(criterio.mejorCircuito(filtrados, origen, destino)).thenReturn(Optional.of(c1));
		
		//exercise
		Optional<Circuito> ret = motor.mejorCircuito(origen, destino, criterio);
		
		//verify
		//verificamos que el motor cambio su "strategy" de criterioCircuito
		assertEquals(criterio ,motor.getCriterio());
		
		assertEquals(ret.get(), c1);
		
	}
	
	
}
