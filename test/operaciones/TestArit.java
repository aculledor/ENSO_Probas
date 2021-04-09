package operaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestArit {

	@Test
	void testSuma() {
		Arit ca = new Arit();
		
		assertEquals(11, ca.suma(5, 6), "Fallo al sumar 5 + 6");
	}

	@Test
	void testResta() {
		Arit ca = new Arit();
		
		assertEquals(4, ca.resta(7, 3), "Fallo al restar 7 - 3");
	}

}
