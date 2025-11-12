package unq.edu.po2.chofer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChoferTest {
	Chofer chofer;

	@BeforeEach
	void setUp() throws Exception {
		chofer = new Chofer("Juan Pérez", "15.657.429");
	}

	@Test
	void nombreDeChofer() {
		String nombreChofer = chofer.getnNyap();
		
		assertEquals("Juan Pérez", nombreChofer);
	}
	
	@Test
	void dniDeChofer() {
		String dniChofer = chofer.getDni();
		
		assertEquals("15.657.429", dniChofer);
	}

}
