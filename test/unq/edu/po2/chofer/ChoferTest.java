package unq.edu.po2.chofer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChoferTest {
	Chofer chofer;

	@BeforeEach
	void setUp() throws Exception {
		chofer = mock(Chofer.class);
	}

	@Test
	void nombreDeChofer() {
		when(chofer.getnNyap()).thenReturn("Juan Pérez");
		
		String nombreChofer = chofer.getnNyap();
		
		verify(chofer).getnNyap();
		
		assertEquals("Juan Pérez", nombreChofer);
	}
	
	@Test
	void dniDeChofer() {
		when(chofer.getDni()).thenReturn("55.368.859");
		
		String dniChofer = chofer.getDni();
		
		verify(chofer).getDni();
		
		assertEquals("55.368.859", dniChofer);
	}

}
