package unq.edu.po2.camion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.terminales4.camion.Camion;
import unq.edu.po2.terminales4.orden.Orden;
import unq.edu.po2.terminales4.terminal.Terminal;

class CamionTest {
	Chofer chofer;
	Camion camion;
	Orden orden;
	Terminal terminal;
//.
	@BeforeEach
	void setUp() throws Exception {
		
		chofer = new Chofer("Manuel Santos", "35.201.151");
		camion = new Camion("ABC123", chofer, orden, terminal);
		orden = mock(Orden.class);
		terminal = mock(Terminal.class);
		
	}

	@Test
	void patenteCamion() {
		String patente = camion.getPatente();
		
		assertEquals("ABC123", patente);
	}
	
	@Test 
	void choferEnCamion(){
		Chofer choferAsignado = camion.getChofer();
		
		assertEquals(chofer, choferAsignado);
	}

}
