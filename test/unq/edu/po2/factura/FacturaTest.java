package unq.edu.po2.factura;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.orden.Orden;

class FacturaTest {
	
	Factura factura;
	Orden orden;

	@BeforeEach
	void setUp() throws Exception {
		
		factura = new Factura(orden);
		orden = mock(Orden.class);
		
	}

	@Test
	void agregarYGetItems() {
		factura.agregarItem("Lavado", 200.0);
		factura.agregarItem("Pesado", 300.0);
		
		Map<String, Double> items = factura.getItems();
		
		assertEquals(2, items.size());
		assertEquals(200.0, items.get("Lavado"));
		assertEquals(300.0, items.get("Pesado"));
		
	}
	
	@Test
	void montoTotal() {
		
		factura.agregarItem("Electricidad", 500.0);
		factura.agregarItem("Excedente", 1500.0);
		
		assertEquals(2000.0, factura.montoTotal());
		
	}

}
