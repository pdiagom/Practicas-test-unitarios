package es.iessoterohernandez.daw.endes.BoletinJUnit.boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubscripcionTest {

	Subscripcion subscripcion;
	@Test
	public void precioPorMes() {
		subscripcion = new Subscripcion(1200, 12);
		double precioPorMes = subscripcion.precioPorMes();
		assertEquals(100.0, precioPorMes);
	}

	@Test
	public void testPrecioPorMesPeriodoNegativo() {
		subscripcion = new Subscripcion(1200, -12);
		double precioPorMes = subscripcion.precioPorMes();
		assertEquals(0, precioPorMes);
	}

	@Test
	public void testPrecioPorMesNegativo() {
		subscripcion = new Subscripcion(-1200, 12);
		double precioPorMes = subscripcion.precioPorMes();
		assertEquals(0, precioPorMes);
	}

	@Test
	public void testPrecioPorMesAmbosNegativos() {
		subscripcion = new Subscripcion(-1200, -12);
		double precioPorMes = subscripcion.precioPorMes();
		assertEquals(0, precioPorMes);
	}

	@Test
	public void testPrecioPorMesPeriodoCero() {
		subscripcion = new Subscripcion(1200, 0);
		double precioPorMes = subscripcion.precioPorMes();
		assertEquals(0, precioPorMes);
	}

	@Test
	public void testPrecioPorMesCero() {
		subscripcion = new Subscripcion(0, 12);
		double precioPorMes = subscripcion.precioPorMes();
		assertEquals(0, precioPorMes);
	}

	@Test
	public void testPrecioPorMesAmbos0() {
		subscripcion = new Subscripcion(0, 0);
		double precioPorMes = subscripcion.precioPorMes();
		assertEquals(0, precioPorMes);
	}

	@Test
	public void testCancel() {
		subscripcion = new Subscripcion(1200, 12);
		subscripcion.cancel();
		//assertEquals(0, subscripcion.periodo);
	}

}
