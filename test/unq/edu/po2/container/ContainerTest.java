package unq.edu.po2.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.*;


class ContainerTest {
	
	Cliente cliente = mock(Cliente.class);
	Container container = mock(Container.class);
	ContainerDry dry = mock(ContainerDry.class);
	ContainerTanque tanque = mock(ContainerTanque.class);
	ContainerReefer reefer = mock(ContainerReefer.class);
	ContenidoCarga contenido = mock(ContenidoCarga.class);
	Producto producto = mock(Producto.class);
	Contenedor contenedor = mock(Contenedor.class);
	Producto productoNuevo = mock(Producto.class);
	
	/*@BeforeEach
	public void setUp() {
		when(cliente.getNombre()).thenReturn("Bruno Diaz");
		
		when(producto.getPesoKilos()).thenReturn(500);
		when(producto.getTipoProducto()).thenReturn("Comida");
		when(productoNuevo.getPesoKilos()).thenReturn(200);
		when(productoNuevo.getTipoProducto()).thenReturn("Gasóleo A");
		
		when(contenido.getPesoKilos()).thenReturn(300);
		when(contenido.getTipoProducto()).thenReturn("Electrodomésticos");
		
		when(dry.getBL()).thenReturn(contenido);
		when(tanque.getBL()).thenReturn(productoNuevo);
		when(reefer.getBL()).thenReturn(producto);
		}*/
	
	@Test
	public void tanqueTieneProductoNuevo() {
		
	    when(productoNuevo.getPesoKilos()).thenReturn(200);
	    when(productoNuevo.getTipoProducto()).thenReturn("Gasóleo A");
	    
	    when(tanque.getBL()).thenReturn(productoNuevo);
	    
	    ContenidoCarga carga = tanque.getBL();
	    
	    verify(tanque).getBL();
	    
	    assertEquals(200, carga.getPesoKilos());
	    assertEquals("Gasóleo A", carga.getTipoProducto());
	}

}

