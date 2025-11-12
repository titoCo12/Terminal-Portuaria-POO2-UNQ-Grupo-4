package unq.edu.po2.terminales4.orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.Container;
import unq.edu.po2.terminales4.camion.Camion;
import unq.edu.po2.terminales4.posicion.Puerto;
import unq.edu.po2.terminales4.terminal.Terminal;
import unq.edu.po2.terminales4.viajes.Viaje;

class OrdenExportacionTest {

	OrdenExportacion ordenExportacion;
	LocalDate fechaTurno, fechaLlegada, fechaSalida;
	Puerto puertoOrigen, puertoDestino;
	String idContainer;
	Cliente cliente;
	String patenteCamion, dniChofer;
	Camion camion;
	Container container;
	Viaje viaje;
	Terminal terminal;
	
	@BeforeEach
	void setUp() throws Exception {
		fechaTurno = LocalDate.now().plusDays(2);
		fechaSalida = LocalDate.now().plusDays(3);
		fechaLlegada = LocalDate.now().plusDays(30);
		idContainer = "merk1234567";
		puertoOrigen = mock(Puerto.class);
		puertoDestino = mock(Puerto.class);
		cliente = mock(Cliente.class);
		camion = mock(Camion.class);
		container = mock(Container.class);
		viaje = mock(Viaje.class);
		terminal = mock(Terminal.class);
		patenteCamion = "AZ401FR";
		dniChofer = "12345678";
		
		
		
		ordenExportacion = new OrdenExportacion(dniChofer, patenteCamion, fechaTurno, fechaLlegada, puertoOrigen, puertoDestino, container, cliente, fechaSalida, viaje);
		
		
		
	}

	@Test 
	void testFechaSalida() {
		LocalDate fechaSalidaEnOrden = ordenExportacion.getFechaSalida();
		assertEquals(fechaSalida, fechaSalidaEnOrden);
	}

	@Test
	void testTitulo() {
		String titulo = ordenExportacion.getTitulo();
		
		assertEquals("export", titulo);
	} 
	
	@Test
	void testAccionContainerAlmacenarEnTerminal() {
		ordenExportacion.accionContainer(terminal);
		verify(terminal, times(1)).almacenarContainer(container);
		
	}
}
