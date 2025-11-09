package unq.edu.po2.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;


class ContainerTest {
	
	Cliente cliente;
	Container container;
	ContainerDry dry;
	ContainerTanque tanque;
	ContainerReefer reefer;
	ContenidoCarga contenido;
	Producto producto;
	Contenedor contenedor;
	
	@BeforeEach
	public void setUp() {
		cliente = mock(Cliente.class);
		container = mock(Container.class);
		dry = mock(ContainerDry.class);
		tanque = mock(ContainerTanque.class);
		reefer = mock(ContainerReefer.class);
		contenido = mock(ContenidoCarga.class);
		producto = mock(Producto.class);
		contenedor = mock(Contenedor.class);
		/*
		when(cliente.getNombre()).thenReturn("Bruno Diaz");
		*/
		}
	
	@Test
	public void tanqueTieneGasoleoConPeso() {
		when(tanque.getBL()).thenReturn(producto);
		when(producto.getPesoKilos()).thenReturn(200);
		when(producto.getTipoProducto()).thenReturn("Gasóleo A");
	    
		ContenidoCarga carga = tanque.getBL();
	    
	    verify(tanque).getBL();
	    
	    assertEquals(200, carga.getPesoKilos());
	    assertEquals("Gasóleo A", carga.getTipoProducto());
	}
	
	@Test
	public void dryTieneElectrodomesticosConPeso() {
		when(contenido.getPesoKilos()).thenReturn(300);
		when(contenido.getTipoProducto()).thenReturn("Electrodomésticos");
		when(dry.getBL()).thenReturn(contenido);
		
		ContenidoCarga carga = dry.getBL();
	    
	    verify(dry).getBL();
	    
	    assertEquals(300, carga.getPesoKilos());
	    assertEquals("Electrodomésticos", carga.getTipoProducto());
		
	}
	
	@Test
	public void reeferTieneComidaConPeso() {
		when(producto.getPesoKilos()).thenReturn(500);
		when(producto.getTipoProducto()).thenReturn("Comida");
		when(reefer.getBL()).thenReturn(producto);
		
		ContenidoCarga carga = reefer.getBL();
	    
	    verify(reefer).getBL();
	    
	    assertEquals(500, carga.getPesoKilos());
	    assertEquals("Comida", carga.getTipoProducto());
	}

}

