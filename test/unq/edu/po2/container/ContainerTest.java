package unq.edu.po2.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

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
		
		}
	
	@Test
	public void containerTieneContenidoYPeso() {
		when(contenido.getPesoKilos()).thenReturn(3000);
		when(contenido.getTipoProducto()).thenReturn("Madera");
		when(container.getBL()).thenReturn(contenido);
		
		ContenidoCarga carga = container.getBL();
	    
	    verify(container).getBL();
	    
	    assertEquals(3000, carga.getPesoKilos());
	    assertEquals("Madera", carga.getTipoProducto());
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
	
	@Test
	public void identificadorEnDry() {
		when(cliente.getNombre()).thenReturn("Bruno Diaz");
		
	    ContainerDry Cdry = new ContainerDry(cliente, 1234567, 6, 6, 12, 100, contenido);
	    
	    String identificador = Cdry.getIdentificador();
	    assertEquals("BRUN1234567", identificador);
	}
	
	@Test 
	public void identificadorEnTanque() {
		when(cliente.getNombre()).thenReturn("Ricardo Tapia");
		
	    ContainerTanque cTanque = new ContainerTanque(cliente, 567, 6, 6, 12, 100, contenido);
	    
	    String identificador = cTanque.getIdentificador();
	    assertEquals("RICA0000567", identificador);
	}
	
	@Test
	public void identificadorEnReefer() {
		when(cliente.getNombre()).thenReturn("Homero Simpson");
		
		ContainerReefer cReefer = new ContainerReefer(cliente, 2025119, 6, 6, 12, 100, contenido, 0, LocalDateTime.of(2022, 12, 18, 12, 00), LocalDateTime.of(2026, 06, 11, 12, 00));
		
	    String identificador = cReefer.getIdentificador();
	    assertEquals("HOME2025119", identificador);
	}
	/*
	- consumo de reefer
	- local date time en reefer
	- probar getTipoProducto y getPesoKilos en producto, contenedor y contenido
	
	*/
	
	@Test
	public void conumoReefer() {
		when(reefer.getConsumoXHora()).thenReturn(500.0);
		
		double consumoXHora = reefer.getConsumoXHora();
		
		verify(reefer).getConsumoXHora();
		
		assertEquals(500.0, consumoXHora);
	}
	

}

