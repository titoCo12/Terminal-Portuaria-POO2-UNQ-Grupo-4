package unq.edu.po2.terminales4.terminal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.cliente.Cliente;
import unq.edu.po2.container.*;
import unq.edu.po2.empresaTransportista.*;
import unq.edu.po2.terminales4.camion.*;
import unq.edu.po2.terminales4.orden.*;
import unq.edu.po2.terminales4.posicion.*;
import unq.edu.po2.terminales4.viajes.Viaje;

class TerminalTest {

	private Terminal terminal;
	private MotorDeBusqueda motor;
	private Puerto ubicacion;
	private EmpresaTransportista emp1;
	private EmpresaTransportista emp2;
	private List<EmpresaTransportista> emps;
	
	@BeforeEach
	void setUp() {
		motor = mock(MotorDeBusqueda.class);
		ubicacion = mock(Puerto.class);
		emp1 = mock(EmpresaTransportista.class);
		emp2 = mock(EmpresaTransportista.class);
		emps = new ArrayList<>();
		emps.add(emp1); emps.add(emp2);
		
		terminal = new Terminal(motor, ubicacion, emps);
	}
	
	@Test
	void manipularContainersTest() {
		//setup
		Container cont = mock(Container.class);
		
		//la terminal en un principio no tiene containers
		assertEquals(0, terminal.getContainersAlmacenados().size());
		
		//al agregar un container ahora tiene uno..
		terminal.almacenarContainer(cont);
		assertEquals(1, terminal.getContainersAlmacenados().size());
	
		//al remover ese container ya no tiene ninguno :P ...
		terminal.removerContainer(cont);
		assertEquals(0, terminal.getContainersAlmacenados().size());
	}
	
	@Test
	void llegadaDeCamionHabilitadoTest() {
		//setup 
		Orden orden = mock(Orden.class);
		Camion cam = mock(Camion.class);
		Chofer chof = mock(Chofer.class);
		
		
		when(cam.getChofer()).thenReturn(chof);
		when(emp1.esCamionHabilitado(cam)).thenReturn(true);
		when(emp2.esCamionHabilitado(cam)).thenReturn(false);
		when(emp1.esChoferHabilitado(chof)).thenReturn(false);
		when(emp2.esChoferHabilitado(chof)).thenReturn(true);
		
		//exercise
		terminal.llegadaDeCamion(orden, cam);
		
		//Verify
		//si el camion y el chofer estan habilitados por alguna de las empresas,
		// entonces la terminal llama a la orden a manejar la llegada del camion
		verify(orden, times(1)).manejarLlegada(terminal, cam);
		
	}
	
	@Test
	void llegadaDeCamionNoHabilitadoTest() {
		//setup 
		Orden orden = mock(Orden.class);
		Camion cam = mock(Camion.class);
		Chofer chof = mock(Chofer.class);
		
		
		when(cam.getChofer()).thenReturn(chof);
		when(emp1.esCamionHabilitado(cam)).thenReturn(false);
		when(emp2.esCamionHabilitado(cam)).thenReturn(false);
		when(emp1.esChoferHabilitado(chof)).thenReturn(false);
		when(emp2.esChoferHabilitado(chof)).thenReturn(true);
		
		//exercise
		terminal.llegadaDeCamion(orden, cam);
		
		//Verify
		//si el chofer esta habilitado, pero el camion no, el camion no puede pasar,
		// por ende la terminal no llama a la orden a encargarse del resto.
		verify(orden, never()).manejarLlegada(terminal, cam);
		
	}
	
	@Test
	void registrarExportacionValida() throws Exception {
		
		//setup
		String patente = "GOB549";
		String dni = "41825277";
		Cliente cli = mock(Cliente.class);
		Container cont = mock(Container.class);
		Puerto destino = mock(Puerto.class);
		Viaje viaje = mock(Viaje.class);
		
		//pasa por el origen antes de pasar por el destino
		when(viaje.pasaPor(ubicacion)).thenReturn(true);
		when(viaje.pasaPor(destino)).thenReturn(true);
		when(viaje.fechaLlegadaA(ubicacion)).thenReturn(Optional.of(LocalDate.of(2025, 10, 20)));
		when(viaje.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2025, 10, 25)));
		
		//Exercise
		OrdenExportacion result = terminal.registrarExportacion(patente, dni, cli, cont, destino, viaje);
		
		//Verify
		//Orden generada con todos los datos correspondientes
		assertEquals(dni, result.getDniChofer());
		assertEquals(patente, result.getPatenteCamion());
		assertEquals(LocalDate.now().plusDays(1), result.getFechaTurno());
		assertEquals(LocalDate.of(2025, 10, 25), result.getFechaLlegada());
		assertEquals(ubicacion, result.getPuertoOrigen());
		assertEquals(destino, result.getPuertoDestino());
		assertEquals(cont, result.getContainer());
		assertEquals(cli, result.getCliente());
		assertEquals(LocalDate.of(2025, 10, 20), result.getFechaSalida());
		
	}
	
	@Test
	void registrarExportacionNoPasa() throws Exception {
		
		//setup
		String patente = "GOB549";
		String dni = "41825277";
		Cliente cli = mock(Cliente.class);
		Container cont = mock(Container.class);
		Puerto destino = mock(Puerto.class);
		Viaje viaje = mock(Viaje.class);
		
		//NO pasa por el destino
		when(viaje.pasaPor(ubicacion)).thenReturn(true);
		when(viaje.pasaPor(destino)).thenReturn(false);
		
		//Exercise
		Exception exception = assertThrows(Exception.class, () -> {
		    terminal.registrarExportacion(patente, dni, cli, cont, destino, viaje);
		});

		//verify
		assertEquals("Viaje no pasa por los puertos origen y destino", exception.getMessage());
		
	}
	
	@Test
	void registrarExportacionPasaAntes() throws Exception {
		
		//setup
		String patente = "GOB549";
		String dni = "41825277";
		Cliente cli = mock(Cliente.class);
		Container cont = mock(Container.class);
		Puerto destino = mock(Puerto.class);
		Viaje viaje = mock(Viaje.class);
		
		//Pasa por el destino ANTES de pasar por el origen
		when(viaje.pasaPor(ubicacion)).thenReturn(true);
		when(viaje.pasaPor(destino)).thenReturn(true);
		when(viaje.fechaLlegadaA(ubicacion)).thenReturn(Optional.of(LocalDate.of(2025, 10, 25)));
		when(viaje.fechaLlegadaA(destino)).thenReturn(Optional.of(LocalDate.of(2025, 10, 20)));
		
		//Exercise
		Exception exception = assertThrows(Exception.class, () -> {
		    terminal.registrarExportacion(patente, dni, cli, cont, destino, viaje);
		});

		//verify
		assertEquals("Viaje pasa por puerto destino antes de pasar por puerto origen (esta terminal)", exception.getMessage());
		
	}
	
	@Test
	void preavisoDeBuqueInformaAClientes() {
		
		//setup
		
		Orden o1 = mock(Orden.class);
		Orden o2 = mock(Orden.class);
		Orden o3 = mock(Orden.class);
		Cliente cli1 = mock(Cliente.class);
		Cliente cli2 = mock(Cliente.class);
		Cliente cli3 = mock(Cliente.class);
		LocalDate llegada = LocalDate.of(2025, 10, 20);
		List<Orden> ordenes = new ArrayList<Orden>();
		ordenes.add(o1); ordenes.add(o2); ordenes.add(o3);
		
		when(o1.getCliente()).thenReturn(cli1);
		when(o1.getFechaLlegada()).thenReturn(llegada);
		when(o2.getCliente()).thenReturn(cli2);
		when(o2.getFechaLlegada()).thenReturn(llegada);
		when(o3.getCliente()).thenReturn(cli3);
		when(o3.getFechaLlegada()).thenReturn(llegada);
	
		//exercise
		terminal.preavisoBuque(ordenes);
		
		//verify
		verify(cli1, times(1)).recibirNotificacion(llegada);
		verify(cli2, times(1)).recibirNotificacion(llegada);
		verify(cli3, times(1)).recibirNotificacion(llegada);
	
	}
	

}
