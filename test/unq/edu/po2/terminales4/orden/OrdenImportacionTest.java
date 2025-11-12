package unq.edu.po2.terminales4.orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.factura.Factura;
import unq.edu.po2.factura.Item;
import unq.edu.po2.servicio.AlmacenamientoExcedente;
import unq.edu.po2.servicio.Pesado;
import unq.edu.po2.servicio.Servicio;
import unq.edu.po2.terminales4.camion.Camion;
import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;
import unq.edu.po2.terminales4.viajes.Viaje;

class OrdenImportacionTest {

	OrdenImportacion ordenImportacion, ordenImportacionSinExcesoDeDias;
	LocalDate fechaTurnoExcedidoEn2Dias, fechaLlegada, fechaSalida, fechaTurnoSinExcesoDeDias;
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
	Chofer chofer;
	Servicio pesado, lavado;
	
	@BeforeEach
	void setUp() throws Exception {
		
		fechaTurnoExcedidoEn2Dias = LocalDate.now().plusDays(2);
		fechaTurnoSinExcesoDeDias = LocalDate.now(); 
		fechaLlegada = LocalDate.now();
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
		chofer = mock(Chofer.class);
		pesado = mock(Servicio.class);
		lavado = mock(Servicio.class);

		patenteCamion = "AZ401FR";
		dniChofer = "12345678";
		container.agregarServicio(pesado);
		container.agregarServicio(lavado);
		
		
		
		ordenImportacion = new OrdenImportacion(dniChofer, patenteCamion, fechaTurnoExcedidoEn2Dias, fechaLlegada, puertoOrigen, puertoDestinoEnOrden, container, cliente, viaje);
		when(circuito.precioDesdeHasta(puertoOrigen, puertoDestinoEnOrden)).thenReturn(1400d);
		when(viaje.getCircuito()).thenReturn(circuito);
		when(camion.getPatente()).thenReturn(patenteCamion);
		when(chofer.getDni()).thenReturn(dniChofer);
		when(camion.getChofer()).thenReturn(chofer);
		
		ordenImportacionSinExcesoDeDias = new OrdenImportacion(dniChofer, patenteCamion, fechaTurnoSinExcesoDeDias, fechaLlegada, puertoOrigen, puertoDestinoEnOrden, container, cliente, viaje);

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
		assertEquals(fechaTurnoExcedidoEn2Dias, turnoEnOrden);
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
		when(viaje.getCircuito()).thenReturn(circuito);
		ordenImportacion.agregarItems(factura);
		verify(factura, times(1)).agregarItem(any(Item.class));
		
	}
	
	@Test
	void testAgregar3ServiciosAFactura() {
		List<Servicio> s = new ArrayList<Servicio>();
		s.add(pesado);
		s.add(lavado);
		when(container.getServicios()).thenReturn(s);
		ordenImportacion.agregarItems(factura);
		verify(container, times(1)).getServicios();
		verify(factura, times(3)).agregarItem(any(Item.class));
	}
	
	@Test
	void testEnviarFacturaCliente() {
		when(circuito.precioDesdeHasta(puertoOrigen, puertoDestinoEnOrden)).thenReturn(1400d);
		when(viaje.getCircuito()).thenReturn(circuito);
		ordenImportacion.enviarFactura();
		verify(cliente, times(1)).recibirFactura(any(Factura.class));
	}
	
	@Test
	void testCamionYChoferCoincideConOrden() {
		
		ordenImportacion.manejarLlegada(terminalGestionada, camion);

		verify(container, times(1)).agregarServicio(any(AlmacenamientoExcedente.class));
	}
	
	@Test
	void testCamionYChoferEnOrden_NoCoincideChofer_NoSeEjecutaAlmacenamientoNiHook() {
		
		when(chofer.getDni()).thenReturn("OTRO_DNI");
		ordenImportacion.manejarLlegada(terminalGestionada, camion);
		
		verify(container, never()).agregarServicio(any(AlmacenamientoExcedente.class));
	}
	
	@Test
	void testCamionYChoferEnOrden_NoCoincidePatente_NoSeEjecutaAlmacenamientoNiHook() {
		
		when(camion.getPatente()).thenReturn("OTRAPATENTE");
		ordenImportacion.manejarLlegada(terminalGestionada, camion);
		
		verify(container, never()).agregarServicio(any(AlmacenamientoExcedente.class));
	}
	
	@Test
	void testNoHayAlmacenamientoExcedente_NOHayExcesoDeDias() {
		
		ordenImportacionSinExcesoDeDias.manejarLlegada(terminalGestionada, camion);

		verify(container, never()).agregarServicio(any(AlmacenamientoExcedente.class));
	}
	

}
