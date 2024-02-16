package es.iessoterohernandez.daw.endes.Videojuego;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideojuegoTest {

    private Videojuego videojuego;

    @BeforeEach
    public void setUp() {
        videojuego = new Videojuego("The Legend of Zelda", 50, "Aventura", "Nintendo");
    }

    @Test
    public void testEntregar() {
        assertFalse(videojuego.isEntregado());
        videojuego.entregar();
        assertTrue(videojuego.isEntregado());
    }

    @Test
    public void testDevolver() {
        videojuego.entregar();
        assertTrue(videojuego.isEntregado());
        videojuego.devolver();
        assertFalse(videojuego.isEntregado());
    }

    @Test
    public void testCompareTo() {
        Videojuego otroVideojuego = new Videojuego("Super Mario Bros", 30, "Plataforma", "Nintendo");
        assertEquals(Videojuego.MAYOR, videojuego.compareTo(otroVideojuego));
        Videojuego otroVideojuego2 = new Videojuego("The Legend of Zelda", 50, "Aventura", "Nintendo");
        assertEquals(Videojuego.IGUAL, videojuego.compareTo(otroVideojuego2));
        Videojuego otroVideojuego3 = new Videojuego("Final Fantasy VII", 80, "RPG", "Square Enix");
        assertEquals(Videojuego.MENOR, videojuego.compareTo(otroVideojuego3));
    }

    @Test
    public void testEqualsTrue() {
        Videojuego otroVideojuego = new Videojuego("The Legend of Zelda", 50, "Aventura", "Nintendo");
        assertTrue(videojuego.equals(otroVideojuego));
        Videojuego otroVideojuego2 = new Videojuego("Super Mario Bros", 30, "Plataforma", "Nintendo");
        assertFalse(videojuego.equals(otroVideojuego2));
    }

    @Test
    public void testToString() {
        String expected = "Informacion del videojuego: \n" +
                "\tTitulo: The Legend of Zelda\n" +
                "\tHoras estimadas: 50\n" +
                "\tGenero: Aventura\n" +
                "\tcompañia: Nintendo";
        assertEquals(expected, videojuego.toString());
    }
}
