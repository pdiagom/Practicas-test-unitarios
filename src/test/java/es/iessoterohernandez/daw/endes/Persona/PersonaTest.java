package es.iessoterohernandez.daw.endes.Persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */



public class PersonaTest {

	@Test
	public void testCalcularIMC() {
		Persona persona1 = new Persona("Alejandro", 30, 'H',90 , 1.85);
		assertEquals(Persona.SOBREPESO, persona1.calcularIMC(), "El IMC debería ser 1");

		Persona persona2 = new Persona("Carlos", 25, 'M', 100, 2);
		assertEquals(Persona.PESO_IDEAL, persona2.calcularIMC(), "El IMC debería ser 0");

		Persona persona3 = new Persona("Antonio", 40, 'H', 70, 1.90);
		assertEquals(Persona.INFRAPESO, persona3.calcularIMC(), "El IMC debería ser -1");
	}

	@Test
	public void testEsMayorDeEdad() {
		Persona persona1 = new Persona("Juan", 30, 'H', 70, 1.75);
		assertTrue(persona1.esMayorDeEdad(), "Juan debería ser mayor de edad");

		Persona persona2 = new Persona("Ana", 17, 'M', 55, 1.65);
		assertFalse(persona2.esMayorDeEdad(), "Ana no debería ser mayor de edad");
	}

	@Test
	public void testToString() {
		Persona persona = new Persona("Paco", 30, 'H', 70, 1.75);
		String salida = "Informacion de la persona:\n" + "Nombre: Paco\n" + "Sexo: hombre\n" + "Edad: 30 años\n"
				+ "DNI: \\d{8}[A-Z]\n"+
				"Peso: 70.0 kg\n" + "Altura: 1.75 metros\n";
		assertTrue(persona.toString().matches(salida), "El toString() no coincide con el formato esperado");
	}
}
