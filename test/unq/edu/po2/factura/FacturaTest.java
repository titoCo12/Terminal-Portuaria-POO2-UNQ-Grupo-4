package unq.edu.po2.factura;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.orden.Orden;

class FacturaTest {
	
	Factura factura;
	Orden orden;
	Item itemLavado, itemPesado, itemElectricidad, itemExcedente;

	@BeforeEach
	void setUp() throws Exception {
		
		factura = new Factura();
		orden = mock(Orden.class);
		itemLavado = mock(Item.class);
		itemPesado = mock(Item.class);
		itemElectricidad = mock(Item.class);
		itemExcedente = mock(Item.class);
		
	}

	@Test
	void agregarYGetItems() {
		when(itemLavado.getValor()).thenReturn(200d);
		when(itemPesado.getValor()).thenReturn(300d);
		factura.agregarItem(itemLavado);
		factura.agregarItem(itemPesado);
		
		
	}
	
	@Test
	void montoTotal() {
		when(itemElectricidad.getValor()).thenReturn(500d);
		when(itemExcedente.getValor()).thenReturn(1500d);
		factura.agregarItem(itemElectricidad);
		factura.agregarItem(itemExcedente);
		
		assertEquals(500d + 1500d, factura.montoTotal());
		
	}

}
