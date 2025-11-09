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

class OrdenExportacionTest {

	OrdenExportacion ordenExportacion;
	LocalDate fechaTurno, fechaLlegada, fechaSalida;
	Puerto puertoOrigen, puertoDestino;
	String idContainer;
	Cliente cliente;
	String patenteCamion, dniChofer;
	Camion camion;
	
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
		patenteCamion = "AZ401FR";
		dniChofer = "12345678";
		
		
		ordenExportacion = new OrdenExportacion(dniChofer, patenteCamion, fechaTurno, fechaLlegada, idContainer, puertoOrigen, puertoDestino, cliente, fechaSalida);
		
		
		
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
	
	
}
