package unq.edu.po2.naviera;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.edu.po2.terminales4.viajes.Naviera;

class NavieraTest {
	Naviera jimmy;

	@BeforeEach
	void setUp() throws Exception {
		jimmy = new Naviera("Jimmy");
	}

	@Test
	void nombreDeNaviera() {
		assertEquals("Jimmy", jimmy.getNombre());
	}

}
