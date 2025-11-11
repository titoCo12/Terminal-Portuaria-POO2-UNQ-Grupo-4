package unq.edu.po2.empresaTransporista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.chofer.Chofer;
import unq.edu.po2.empresaTransportista.EmpresaTransportista;
import unq.edu.po2.terminales4.camion.Camion;

class EmpresaTransportistaTest {
	
	Chofer chofer;
	Camion camion;
	EmpresaTransportista empresa;

	@BeforeEach
	void setUp() throws Exception {
		
		chofer = mock(Chofer.class);
		camion = mock(Camion.class);
		empresa = new EmpresaTransportista("OCA");
		
	}

	@Test
	void choferHabilitado() {
		when(chofer.getDni()).thenReturn("55.684.937");
		empresa.agregarChofer(chofer);
		
		boolean esChoferHabilitado = empresa.esChoferHabilitado(chofer);
		
		assertEquals(true, esChoferHabilitado);
	}
	
	@Test
	void camionHabilitado() {
		when(camion.getPatente()).thenReturn("ABC123");
		empresa.agregarCamion(camion);
		
		boolean esCamionHabilitado = empresa.esCamionHabilitado(camion);
		
		assertEquals(true, esCamionHabilitado);
	}
	
	@Test 
	void noEsChoferHabilitado(){
		when(chofer.getDni()).thenReturn("55.684.937");
		
		boolean esChoferHabilitado = empresa.esChoferHabilitado(chofer);
		
		assertEquals(false, esChoferHabilitado);
	}
	
	@Test 
	void noEsCamionHabilitado(){
		when(camion.getPatente()).thenReturn("ABC123");
		
		boolean esCamionHabilitado = empresa.esCamionHabilitado(camion);
		
		assertEquals(false, esCamionHabilitado);
	}

}
