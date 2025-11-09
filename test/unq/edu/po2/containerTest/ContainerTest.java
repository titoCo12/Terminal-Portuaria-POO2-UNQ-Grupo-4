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
	Producto productoNuevo = mock(Producto.class);
	
	@BeforeEach
	public void setUp() {
		when(producto.getPesoKilos()).thenReturn(500);
		when(producto.getTipoProducto()).thenReturn("Comida");
		when(productoNuevo.getPesoKilos()).thenReturn(200);
		when(productoNuevo.getTipoProducto()).thenReturn("Gasóleo A");
		
		when(contenido.getPesoKilos()).thenReturn(300);
		when(contenido.getTipoProducto()).thenReturn("Cucharas");
		
		when(dry.getBL()).thenReturn(contenido);
		when(reefer.getBL()).thenReturn(producto);
		when(tanque.getBL()).thenReturn(productoNuevo);
		
		}
	
	@Test
    public void test() {
        
        
    }



}
