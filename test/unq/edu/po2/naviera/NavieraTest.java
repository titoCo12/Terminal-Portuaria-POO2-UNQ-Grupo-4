package unq.edu.po2.naviera;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.circuito.Circuito;
import unq.edu.po2.terminales4.viajes.Naviera;

class NavieraTest {
	Naviera naviera;
	Circuito circuito;
	List<Circuito> circuitos;
	
	@BeforeEach
	void setUp() throws Exception {
		naviera = new Naviera("ABC");
		circuito = mock(Circuito.class);
		circuitos = new ArrayList<>();
	}
	
	@Test
	void getCircuitos() {
	    naviera.agregarCircuito(circuito);
	    
	    assertEquals(1, naviera.getCircuitos().size());
	    assertTrue(naviera.getCircuitos().contains(circuito));
	}


}
