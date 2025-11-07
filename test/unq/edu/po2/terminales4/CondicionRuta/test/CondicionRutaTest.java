package unq.edu.po2.terminales4.CondicionRuta.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.viajes.*;
import unq.edu.po2.terminales4.condicionesRutas.*;
import unq.edu.po2.terminales4.posicion.*;

class CondicionRutaTest {

	private CondicionRuta condRuta;
	private Viaje viaje;
	private Puerto origen;
	private Puerto destino;
	
	@BeforeEach
	void setUp() {
		viaje = mock(Viaje.class);
		
	}

}
