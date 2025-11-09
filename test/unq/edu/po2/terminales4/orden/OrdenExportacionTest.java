package unq.edu.po2.terminales4.orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.terminales4.posicion.Puerto;

class OrdenExportacionTest {

	Orden ordenExportacion;
	LocalDate fechaTurno, fechaLlegada, fechaSalida;
	Puerto puertoOrigen, puertoDestino;
	String idContainer;
	Cliente cliente;
	@BeforeEach
	void setUp() throws Exception {
		fechaSalida = LocalDate.now().plusDays(3);
		fechaLlegada = LocalDate.now().plusDays(30);
		idContainer = "merk1234567";
		puertoOrigen = mock(Puerto.class);
		puertoDestino = mock(Puerto.class);
		cliente = mock(Cliente.class);
		
		ordenExportacion = new OrdenExportacion("Juan", "AZ401FR", fechaSalida, fechaLlegada, idContainer, puertoOrigen, puertoDestino, cliente);
		
		
		
	}

	@Test
	void testTitulo() {
		String titulo = ordenExportacion.getTitulo();
		
		assertEquals("export", titulo);
	}

}
