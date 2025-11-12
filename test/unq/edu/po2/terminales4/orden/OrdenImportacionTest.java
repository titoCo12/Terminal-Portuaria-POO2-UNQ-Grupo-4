package unq.edu.po2.terminales4.orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.factura.Factura;
import unq.edu.po2.factura.Item;
import unq.edu.po2.terminales4.camion.Camion;
import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;
import unq.edu.po2.terminales4.viajes.Viaje;

class OrdenImportacionTest {

	OrdenImportacion ordenImportacion;
	LocalDate fechaTurno, fechaLlegada, fechaSalida;
	Puerto puertoOrigen, puertoDestinoEnOrden, puertoBsAs;
	Cliente cliente;
	String patenteCamion, dniChofer;
	Camion camion;
	Terminal terminalGestionada;
	Container container;
	Viaje viaje;
	Terminal terminal;
	Factura factura;
	Circuito circuito;
	
	@BeforeEach
	void setUp() throws Exception {
		
		fechaTurno = LocalDate.now().plusDays(2);
		fechaLlegada = LocalDate.now().plusDays(30);
		puertoOrigen = mock(Puerto.class);
		puertoBsAs = mock(Puerto.class);
		puertoDestinoEnOrden = mock(Puerto.class);
		cliente = mock(Cliente.class);
		camion = mock(Camion.class);
		container = mock(Container.class);
		terminalGestionada = mock(Terminal.class);
		viaje = mock(Viaje.class);
		terminal = mock(Terminal.class);
		factura = mock(Factura.class);
		circuito = mock(Circuito.class);
		patenteCamion = "AZ401FR";
		dniChofer = "12345678";
		
		ordenImportacion = new OrdenImportacion(dniChofer, patenteCamion, fechaTurno, fechaLlegada, puertoOrigen, puertoDestinoEnOrden, container, cliente, viaje);
		
	}

	@Test
	void testOrdenPerteneceATreminalGestionada() {
		when(puertoDestinoEnOrden.getNombre()).thenReturn("Pto BsAs");
		when(terminalGestionada.getPuerto()).thenReturn(puertoBsAs);
		when(puertoBsAs.getNombre()).thenReturn("Pto BsAs");
		boolean corresponde = ordenImportacion.correspondeATerminal(terminalGestionada);
		
		assertTrue(corresponde);
		
	}
	
	@Test
	void testOrdenNoPerteneceATreminalGestionada() {
		when(puertoDestinoEnOrden.getNombre()).thenReturn("Pto Rosario");
		when(terminalGestionada.getPuerto()).thenReturn(puertoBsAs);
		when(puertoBsAs.getNombre()).thenReturn("Pto BsAs");
		boolean corresponde = ordenImportacion.correspondeATerminal(terminalGestionada);
		
		assertFalse(corresponde);
		
	}
	
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
		LocalDate fechaLlegadaEnOrden = ordenImportacion.getFechaLlegada();
		assertEquals(fechaLlegada, fechaLlegadaEnOrden);
	}
	
	
	@Test 
	void testContainer() {
		Container containerEnOrden = ordenImportacion.getContainer();
		assertEquals(container, containerEnOrden);
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

	@Test
	void testAccionContainerBorrarDeTerminal() {
		ordenImportacion.accionContainer(terminal);
		verify(terminal, times(1)).removerContainer(container);
		
	}
	
	@Test
	void testAgregarItemsDeOrdenEnFactura() {
		when(circuito.precioDesdeHasta(puertoOrigen, puertoDestinoEnOrden)).thenReturn(1400d);
		when(viaje.getCircuito()).thenReturn(circuito);
		ordenImportacion.agregarItems(factura);
		verify(factura, times(1)).agregarItem(any(Item.class));
		
	}
	
}
