package unq.edu.po2.terminales4.reporte;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.*;
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
	void reporteDeMuelleTestConResultados() {
		
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
		when(buque.getOrdenesQueCorrespondenA(terminal)).thenReturn(ordenes); //lista vacia
		
		when(terminal.getPuerto()).thenReturn(new Puerto("Puerto de Nueva Jersey", mock(Posicion.class)));
		
		//exercise
		reporte.visitBuque(buque, terminal);
		String result = reporte.devolverReporte();
		
		//la fecha es nula, ya que por mas que se haga un reporte, si el buque no
		// tiene ninguna orden para esa terminal significa que no va tener que 
		// descargar/cargar en la misma
		assertEquals(result, "buque: El Stugots\n"
				           + "puerto: Puerto de Nueva Jersey\n"
				           + "llegada: --/--/--\n"
				           + "salida: --/--/--\n"
				           + "containers operados: 0");  
		
	}
	
	@Test
	void reporteDeAduanaConResultados() {
		
		//setup
		Cliente cli1 = mock(Cliente.class);
		Cliente cli2 = mock(Cliente.class);
		Cliente cli3 = mock(Cliente.class);
		when(cli1.getNombre()).thenReturn("Matias");
		when(cli2.getNombre()).thenReturn("Diego");
		when(cli3.getNombre()).thenReturn("Fidel");
		
		//preparamos container para los datos que recopila el reporte
		// algunos datos del constructor de container no nos interesan para esta parte
		Container cont1 = new ContainerDry(cli1, 2349504, 0,0,0,0, mock(ContenidoCarga.class));
		//veamos que pasa si le damos un id de mas de 7 caracteres..
		Container cont2 = new ContainerTanque(cli2, 223455161,0,0,0,0, mock(ContenidoCarga.class));
		//veamos que pasa si le damos un id de menos de 7 caracteres..
		Container cont3 = new ContainerReefer(cli3, 2003,0,0,0,0, mock(ContenidoCarga.class), 0, 
				LocalDateTime.of(2000, 1, 1, 10, 10), LocalDateTime.of(2000, 1, 1, 10, 10));
		
		reporte = new ReporteDeAduana();
		ordenes.add(o1);
		ordenes.add(o2);
		ordenes.add(o3);
		
		when(o1.getContainer()).thenReturn(cont1);
		when(o2.getContainer()).thenReturn(cont2);
		when(o3.getContainer()).thenReturn(cont3);
		
		when(buque.getNombre()).thenReturn("El Stugots");
		when(buque.getOrdenesQueCorrespondenA(terminal)).thenReturn(ordenes);
		when(o1.getFechaLlegada()).thenReturn(LocalDate.of(2000, 2, 2));
		
		when(terminal.getPuerto()).thenReturn(new Puerto("Puerto de Nueva Jersey", mock(Posicion.class)));
		
		//exercise
		reporte.visitBuque(buque, terminal);
		String result = reporte.devolverReporte();
		
		//verify
		assertEquals(result, "<!DOCTYPE html>\n" 
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "<title>Reporte de Aduana</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<h1>Puerto de Nueva Jersey</h1>\n"
				+ "<h2> Buque: El Stugots</h2>\n"
				+ "<h2> Llegada: 2000-02-02</h2>\n"
				+ "<h2> Salida: 2000-02-02</h2>\n"
				+ "<ul>\n"
				+ "<li> id:MATI2349504 - tipo: Dry</li>\n"
				+ "<li> id:DIEG2234551 - tipo: Tanque</li>\n"
				+ "<li> id:FIDE0002003 - tipo: Reefer</li>\n"
				+ "</ul>\n"
				+ "</body>\n"
				+ "</html>");  
	}
	
	@Test
	void reporteDeAduanaSinResultados() {
		
		//setup
		
		reporte = new ReporteDeAduana();
		
		when(buque.getNombre()).thenReturn("El Stugots");
		when(buque.getOrdenesQueCorrespondenA(terminal)).thenReturn(ordenes); //lista vacia
		
		when(terminal.getPuerto()).thenReturn(new Puerto("Puerto de Nueva Jersey", mock(Posicion.class)));
		
		//exercise
		reporte.visitBuque(buque, terminal);
		String result = reporte.devolverReporte();
		
		//verify
		//la fecha es nula, ya que por mas que se haga un reporte, si el buque no
		// tiene ninguna orden para esa terminal significa que no va tener que 
		// descargar/cargar en la misma
		assertEquals(result, "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "<title>Reporte de Aduana</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<h1>Puerto de Nueva Jersey</h1>\n"
				+ "<h2> Buque: El Stugots</h2>\n"
				+ "<h2> Llegada: --/--/--</h2>\n"
				+ "<h2> Salida: --/--/--</h2>\n"
				+ "<ul>\n"
				+ "</ul>\n"
				+ "</body>\n"
				+ "</html>");  
	}

	@Test
	void reporteDeBuqueConResultados() {
		
	}
	
	@Test
	void reporteDeBuqueSinResultados() {
		
	}
}
 