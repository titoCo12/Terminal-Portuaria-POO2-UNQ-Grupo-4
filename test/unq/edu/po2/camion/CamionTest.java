package unq.edu.po2.camion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.terminales4.camion.Camion;

class CamionTest {
	Chofer chofer;
	Camion camion;

	@BeforeEach
	void setUp() throws Exception {
		
		chofer = mock(Chofer.class);
		camion = mock(Camion.class);
		
	}

	@Test
	void patenteCamion() {
		when(camion.getPatente()).thenReturn("ABC123");
		
		String patente = camion.getPatente();
		
		verify(camion).getPatente();
		
		assertEquals("ABC123", patente);
	}
	
	@Test 
	void choferEnCamion(){
		when(camion.getChofer()).thenReturn(chofer);
		
		Chofer choferAsignado = camion.getChofer();
		
		verify(camion).getChofer();
		
		assertEquals(chofer, choferAsignado);
	}

}
