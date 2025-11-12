package unq.edu.po2.terminales4.terminal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unq.edu.po2.container.*;
import unq.edu.po2.empresaTransportista.EmpresaTransportista;
import unq.edu.po2.terminales4.posicion.Puerto;

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
	void 

}
