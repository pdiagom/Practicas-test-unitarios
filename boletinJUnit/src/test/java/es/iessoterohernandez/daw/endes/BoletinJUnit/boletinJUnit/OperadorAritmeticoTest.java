package es.iessoterohernandez.daw.endes.BoletinJUnit.boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperadorAritmeticoTest {

	@Test
	void testSuma() {
		assertEquals(5, OperadorAritmetico.suma(2, 3));
		assertEquals(-1, OperadorAritmetico.suma(-2, 1));
		assertEquals(10, OperadorAritmetico.suma(10, 0));
		assertEquals(0, OperadorAritmetico.suma(0, 0));
	}

	@Test
	void testDivision() {
		try {
			assertEquals(2, OperadorAritmetico.division(6, 3));
			assertEquals(-2, OperadorAritmetico.division(-6, 3));
			assertEquals(0, OperadorAritmetico.division(0, 6));
			assertEquals(0, OperadorAritmetico.division(0, -6));
			assertEquals(1, OperadorAritmetico.division(6, 6));
		} catch (Exception e) {
			fail("No debería lanzar excepción para estos casos");
		}

		assertThrows(Exception.class, () -> {OperadorAritmetico.division(5, 0);});
	}

}
