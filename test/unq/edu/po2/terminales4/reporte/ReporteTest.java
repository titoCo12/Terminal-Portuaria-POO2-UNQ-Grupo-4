package unq.edu.po2.terminales4.reporte;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unq.edu.po2.terminales4.buque.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.terminal.*;

class ReporteTest {

	private Reporte reporte;
	private Buque buque;
	private Terminal terminal;
	private Orden o1;
	private Orden o2;
	private Orden o3;
	private Orden o4;
	private List<Orden> ordenes;
	
	
	@BeforeEach
	void setUp() {
		buque = mock(Buque.class);
		terminal = mock(Terminal.class);
		o1 = mock(Orden.class);
		o2 = mock(Orden.class);
		o3 = mock(Orden.class);
		o4 = mock(Orden.class);
		ordenes = new ArrayList<Orden>();
		
	}
	
	@Test
	void reporteDeMuelleTest() {
		
		//setup
		reporte = new ReporteDeMuelle();
		
		ordenes.add(o1);
		ordenes.add(o2);
		
		when(buque.getNombre()).thenReturn("El Stugots");
		when(buque.getOrdenesQueCorrespondenA(terminal)).thenReturn(ordenes);
		when(o1.getFechaLlegada()).thenReturn(LocalDate.of(2000, 2, 2));
		
		when(terminal.getPuerto()).thenReturn(new Puerto("Puerto de Nueva Jersey", mock(Posicion.class)));
		
		//exercise
		reporte.visitBuque(buque, terminal);
		String result = reporte.devolverReporte();
		
		//verify
		assertEquals(result, "buque: El Stugots\n"
				           + "puerto: Puerto de Nueva Jersey\n"
				           + "llegada: 2000-02-02\n"
				           + "salida: 2000-02-02\n"
				           + "containers operados: 2");
		
		
	}
	
	@Test
	void reporteDeMuelleTestSinResultados() {
		
		//setup
		reporte = new ReporteDeMuelle();
		
		when(buque.getNombre()).thenReturn("El Stugots");
		when(buque.getOrdenesQueCorrespondenA(terminal)).thenReturn(ordenes);
		
		when(terminal.getPuerto()).thenReturn(new Puerto("Puerto de Nueva Jersey", mock(Posicion.class)));
		
		//exercise
		reporte.visitBuque(buque, terminal);
		String result = reporte.devolverReporte();
		
		//verify
		//la fecha es nula, ya que por mas que se haga un reporte, si el buque no
		// tiene ninguna orden para esa terminal significa que no va a pasar por la misma
		assertEquals(result, "buque: El Stugots\n"
				           + "puerto: Puerto de Nueva Jersey\n"
				           + "llegada: --/--/--\n"
				           + "salida: --/--/--\n"
				           + "containers operados: 0"); 
		
		
	}

}
 