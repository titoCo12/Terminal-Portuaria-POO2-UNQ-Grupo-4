package unq.edu.po2.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.*;
import unq.edu.po2.servicio.*;


class ContainerTest {
	
	Cliente cliente;
	Producto arroz;
	Producto milanesa;
	Producto metal;
	ContainerDry dry;
	ContainerTanque tanque;
	ContainerReefer reefer;
	Contenedor contenedor;
    
	
	@BeforeEach
	public void setUp() {
		
		cliente = new Cliente("Bruno Diaz");
		arroz = new Producto("Comida", 300);
		milanesa = new Producto("Comida", 100);
		metal = new Producto("Metal", 600);
		dry = new ContainerDry(cliente, 5689400, 6, 6, 6, 500, milanesa);
		tanque = new ContainerTanque(cliente, 5201456, 7, 7, 7, 800, metal);
		reefer = new ContainerReefer(cliente, 2005034, 5, 5, 5, 600, arroz, 15, 
					LocalDateTime.of(2022, 12, 18, 12, 00), 
					LocalDateTime.of(2026, 06, 11, 12, 00));
		contenedor = new Contenedor(List.of(arroz, milanesa));
		
		}
	
	@Test
	public void tanqueTieneMetalConPeso() {
		ContenidoCarga carga = tanque.getBL();
		
		assertEquals(600, carga.getPesoKilos());
	    assertEquals("Metal", carga.getTipoProducto());
	}
	
	@Test
	public void dryTieneElectrodomesticosConPeso() {
		ContenidoCarga carga = dry.getBL();
		
		assertEquals(100, carga.getPesoKilos());
	    assertEquals("Comida", carga.getTipoProducto());
	}
	
	@Test
	public void reeferTieneComidaConPeso() {
		ContenidoCarga carga = reefer.getBL();
		
		assertEquals(300, carga.getPesoKilos());
	    assertEquals("Comida", carga.getTipoProducto());
	}
	
	@Test
	public void identificadorEnDry() {
		String identificador = dry.getIdentificador();
		
	    assertEquals("BRUN5689400", identificador);
	}
	
	@Test 
	public void identificadorEnTanque() {
		String identificador = tanque.getIdentificador();
	    
	    assertEquals("BRUN5201456", identificador);
	}
	
	@Test
	public void identificadorEnReefer() {
		String identificador = reefer.getIdentificador();
		
	    assertEquals("BRUN2005034", identificador);
	}
	
	@Test
	public void consumoReefer() {
		reefer.setConsumo(500.0);
		
		assertEquals(500.0, reefer.getConsumoXHora());
		
		reefer.aumentarConsumo(200.0);
		
		assertEquals(700.0, reefer.getConsumoXHora());
	}
	
	@Test
	public void tiempoDeConexionYDesconexion() {
		LocalDateTime conexion = reefer.getMomentoConexion();
		LocalDateTime desconexion = reefer.getMomentoDesconexion();
		
		assertEquals(LocalDateTime.of(2022, 12, 18, 12, 00), conexion);
		assertEquals(LocalDateTime.of(2026, 06, 11, 12, 00), desconexion);
	}
	
	@Test
	public void tipoYPesoEnProductos() {
		assertEquals("Comida", arroz.getTipoProducto());
		assertEquals(300, arroz.getPesoKilos());
		assertEquals("Metal", metal.getTipoProducto());
		assertEquals(600, metal.getPesoKilos());
	}

	@Test
	public void tipoYPesoEnContenedor() {
		//contenedor = new Contenedor(List.of(arroz, milanesa));
		String tipo = contenedor.getTipoProducto();
		int peso = contenedor.getPesoKilos();
		
		assertEquals("Comida", tipo);
		assertEquals(400, peso);
		
	}
	
	@Test
	void desgloseServiciosDry() {
		Servicio pesado = mock(Servicio.class);
		
		dry.agregarServicio(pesado);
		
		List<Servicio> servicios = dry.getDesgloseServicios();
		
		assertEquals(1, servicios.size());
		assertEquals(pesado, servicios.get(0));
	}

}

