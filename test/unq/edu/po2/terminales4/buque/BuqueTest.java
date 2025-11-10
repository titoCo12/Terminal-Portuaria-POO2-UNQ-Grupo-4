package unq.edu.po2.terminales4.buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.orden.Orden;
import unq.edu.po2.terminales4.posicion.Posicion;
import unq.edu.po2.terminales4.terminal.Terminal;

class BuqueTest {
	
	Buque buque;
	Terminal terminalDestino;
	Posicion posicionBuque, posicionTerminal;
	List<Orden> ordenes;
	Orden orden;
	
	@BeforeEach
	void setUp() throws Exception {
		orden = mock(Orden.class);
		ordenes = new ArrayList<Orden>();
		terminalDestino = mock(Terminal.class);
		posicionBuque = mock(Posicion.class);
		posicionTerminal = mock(Posicion.class);
		ordenes.add(mock(Orden.class));
		buque = new Buque("Gran Buque");
		buque.terminalDestino(terminalDestino);
		ordenes.add(orden);
	}

	@Test
	void testPasoDeOutbounAInboundMandarAvisoATerminal() {
		when(terminalDestino.posicion()).thenReturn(posicionTerminal);
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(30);
		
		buque.actualizarPosicion(posicionBuque);
		
		verify(terminalDestino).preavisoBuque(ordenes);
	}
	
	@Test
	void testPasoDeInboundAArrived() {
		when(terminalDestino.posicion()).thenReturn(posicionTerminal);
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(30);
		
		//paso a inbound
		buque.actualizarPosicion(posicionBuque);
		
		//me acerco para evaluar la otra rama del if , si llego a terminal
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(10);
		buque.actualizarPosicion(posicionBuque);
		
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(0);
		//paso a arrived
		buque.actualizarPosicion(posicionBuque);
				
		verify(terminalDestino, times(1)).preavisoBuque();
		
		
	}

	@Test
	void testPasoDeArrivedAWorking() {
		when(terminalDestino.posicion()).thenReturn(posicionTerminal);
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(30);
		
		//paso a inbound
		buque.actualizarPosicion(posicionBuque);
		
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(0);
		//paso a arrived
		buque.actualizarPosicion(posicionBuque);
		
		//iniciar trabajo ahora cambia de fase a working
		buque.iniciarTrabajo();
		//enviar mensaje a buque que puse salir
		buque.depart();
		verify(terminalDestino, times(1)).preavisoBuque(ordenes);
		verify(terminalDestino, never()).buqueSaliendo(buque);
		
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(3);
		//buque saliendo esta a mas de 1km , debe comunicar a la terminal
		buque.actualizarPosicion(posicionBuque);
		verify(terminalDestino, times(1)).buqueSaliendo(buque);
		
	}
	
	@Test
	void testNoSeDebeInvocarBuqueSaliendoEnFaseInbound() {
		when(terminalDestino.posicion()).thenReturn(posicionTerminal);
		when(posicionBuque.distanciaEnKmA(posicionTerminal)).thenReturn(30);
		verify(terminalDestino, never()).buqueSaliendo(buque);
		
		
	}
	
}
