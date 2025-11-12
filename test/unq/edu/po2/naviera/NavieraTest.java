package unq.edu.po2.naviera;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.viajes.Naviera;

class NavieraTest {
	Naviera jimmy;
	Circuito circuito1;
	Circuito circuito2;
	List<Circuito> circuitos;

	@BeforeEach
	void setUp() throws Exception {
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuitos = Arrays.asList(circuito1, circuito2);
		jimmy = new Naviera("Jimmy", circuitos);
	}

	@Test
	void nombreDeNaviera() {
		assertEquals("Jimmy", jimmy.getNombre());
	}

}
