package unq.edu.po2.terminales4.orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.terminales4.camion.Camion;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;

class OrdenImportacionTest {

	OrdenImportacion ordenImportacion;
	LocalDate fechaTurno, fechaLlegada, fechaSalida;
	Puerto puertoOrigen, puertoDestinoEnOrden;
	String idContainer;
	Cliente cliente;
	String patenteCamion, dniChofer;
	Camion camion;
	Terminal terminalGestionada;
	
	@BeforeEach
	void setUp() throws Exception {
		
		fechaTurno = LocalDate.now().plusDays(2);
		fechaLlegada = LocalDate.now().plusDays(30);
		idContainer = "merk1234567";
		puertoOrigen = mock(Puerto.class);
		puertoDestinoEnOrden = mock(Puerto.class);
		cliente = mock(Cliente.class);
		camion = mock(Camion.class);
		terminalGestionada = mock(Terminal.class);
		patenteCamion = "AZ401FR";
		dniChofer = "12345678";
		
		ordenImportacion = new OrdenImportacion(dniChofer, patenteCamion, fechaTurno, fechaLlegada, idContainer, puertoOrigen, puertoDestinoEnOrden, cliente);
		
	}

//	@Test
//	void testOrdenPerteneceATreminalGestionada() {
//		when(puertoDestinoEnOrden.getNombre()).thenReturn("Pto BsAs");
//		when(terminalGestionada.getPuerto().getNombre()).thenReturn("Pto BsAs");
//		boolean corresponde = ordenImportacion.correspondeATerminal(terminalGestionada);
//		
//		assertTrue(corresponde);
//		
//	}
	@Test
	void testTitulo() {
		String titulo = ordenImportacion.getTitulo();
		
		assertEquals("import", titulo);
	}
	
	@Test
	void testdniChofer() {
		String dniEnOrden = ordenImportacion.getDniChofer();
		
		assertEquals(dniChofer, dniEnOrden);
	}
	
	@Test 
	void testPatenteCamion() {
		String patenteEnOrden = ordenImportacion.getPatenteCamion();
		assertEquals(patenteCamion, patenteEnOrden);
	}
	
	@Test 
	void testFechaTurno() {
		LocalDate turnoEnOrden = ordenImportacion.getFechaTurno();
		assertEquals(fechaTurno, turnoEnOrden);
	}
	
	
	
	@Test 
	void testFechaLlegada() {
		LocalDate fechaLlegadaEnOrden = ordenImportacion.getFechaLLegada();
		assertEquals(fechaLlegada, fechaLlegadaEnOrden);
	}
	
	
	@Test 
	void testIdContainer() {
		String idContainerEnOrden = ordenImportacion.getIdContainer();
		assertEquals(idContainer, idContainerEnOrden);
	}
	
	@Test
	void testPuertoOrigen() {
		Puerto origenEnOrden = ordenImportacion.getPuertoOrigen();
		assertEquals(puertoOrigen, origenEnOrden);
	}
	
	@Test
	void testPuertoDestino() {
		Puerto destinoEnOrden = ordenImportacion.getPuertoDestino();
		assertEquals(puertoDestinoEnOrden, destinoEnOrden);
	}
	
	@Test
	void testCliente() {
		Cliente clienteEnOrden = ordenImportacion.getCliente();
		assertEquals(cliente, clienteEnOrden);
	}

	
	
}
