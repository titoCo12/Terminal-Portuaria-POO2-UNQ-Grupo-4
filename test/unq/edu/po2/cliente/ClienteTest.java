package unq.edu.po2.cliente;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;

//import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	Cliente cliente = new Cliente("Bruno Diaz");
	/*
	 * No puedo testear lo que no hace nada
	 * Facura factura = mock(Factura.class);
	 * LocalDateTime momento = LocalDateTime.of(2025, 11, 13, 17, 00);
	*/

	@BeforeEach
	void setUp() {
		
	}

	@Test
	void clienteSabeSuNombre() {
		assertEquals("Bruno Diaz", cliente.getNombre());
	}

}
