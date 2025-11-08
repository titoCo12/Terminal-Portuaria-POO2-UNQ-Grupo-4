package unq.edu.po2.containerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.ContainerDry;
import unq.edu.po2.container.ContenidoCarga;

class ContainerTest {
	
	Cliente clienteBruno = new Cliente("Bruno Diaz");

	@BeforeEach
	public void setup() {
		
    }
	
	@Test
    public void crearContainerDryConCliente() {
		
        ContainerDry dry = new ContainerDry("ABCD1234567", 2, 2, 2, 100, clienteBruno);

        assertEquals("ABCD1234567", dry.getIdentificador());
        assertEquals("Bruno Diaz", dry.getCliente().getNombre());
    }



}
