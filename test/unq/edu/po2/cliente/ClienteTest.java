package unq.edu.po2.cliente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	Cliente cliente;

	@BeforeEach
	void setUp() {
		cliente = new Cliente("Bruno Diaz");
	}

	@Test
	void clienteSabeSuNombre() {
		String nombre = cliente.getNombre();
		
		assertEquals("Bruno Diaz", nombre);
	}

}
