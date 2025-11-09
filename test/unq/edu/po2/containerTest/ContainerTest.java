package unq.edu.po2.containerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.*;


class ContainerTest {
	/*
	Cliente clienteBruno = new Cliente("Bruno Diaz");
	Producto arroz = new Producto("Arroz", 40);
	Producto fideos = new Producto("Fideos", 50);
	*/
	Cliente cliente = mock(Cliente.class);
	Container container = mock(Container.class);
	ContainerDry dry = mock(ContainerDry.class);
	ContainerTanque tanque = mock(ContainerTanque.class);
	ContainerReefer reefer = mock(ContainerReefer.class);
	ContenidoCarga contenido = mock(ContenidoCarga.class);
	Producto producto = mock(Producto.class);
	Contenedor contenedor = mock(Contenedor.class);
	
	@BeforeEach
	public void setUp() {
		
	}
	
	
	@Test
    public void test() {
        
        
    }



}
