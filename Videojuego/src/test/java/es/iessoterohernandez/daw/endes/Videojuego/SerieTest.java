package es.iessoterohernandez.daw.endes.Videojuego;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SerieTest {
	static Serie serie1;
	static Serie serie2;
	static Serie serie3;

	@BeforeAll
	public static void init() {
		serie1 = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
		serie2 = new Serie("Breaking Bad", 3, "Thriller", "Vince Gilligan");
		serie3 = new Serie("Game of Thrones", 8, "Fantasía", "David Benioff");
	}

	@Test
	public void testEntregarYDevolver() {
		assertFalse(serie1.isEntregado(), "La serie no debería estar entregada inicialmente");

		serie1.entregar();
		assertTrue(serie1.isEntregado(), "La serie debería estar entregada después de llamar a entregar()");
		
		serie1.devolver();
		assertFalse(serie1.isEntregado(), "La serie no debería estar entregada después de llamar a devolver()");
	}

	@Test
	public void testEquals() {

		assertTrue(serie1.equals(serie2), "Las series deberían ser iguales por tener el mismo título y creador");
		assertFalse(serie1.equals(serie3),
				"Las series no deberían ser iguales por tener títulos y creadores diferentes");
	}

	@Test
	public void testCompareTo() {
		serie3.setnumeroTemporadas(5);
		assertEquals(-1, serie2.compareTo(serie1), "The Office debería tener más temporadas que Breaking Bad");
		assertEquals(1, serie3.compareTo(serie2), "Game of Thrones debería tener menos temporadas que The Office");
		assertEquals(0, serie1.compareTo(serie3),"Breaking Bad y Game of Thrones deberían tener el mismo número de temporadas");
	}

	@Test
	public void testToString() {
		String salida = "Informacion de la Serie: \n" + "\tTitulo: Breaking Bad\n" + "\tNumero de temporadas: 5\n"
				+ "\tGenero: Drama\n" + "\tCreador: Vince Gilligan";
		assertEquals(salida, serie1.toString(), "El toString() no coincide con el formato esperado");
	}
}
