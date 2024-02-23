package es.iessoterohernandez.daw.endes.BoletinJUnit.boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilaTest {
	private Pila pila;

    @BeforeEach
    void setUp() {
        pila = new Pila();
    }

    @Test
    void testPush() {
        pila.push(5);
        assertEquals(5, pila.pop());
        
        pila.push(1);
        assertNull(pila.pop());
        
        pila.push(25);
        assertNull(pila.pop());
    }

    @Test
    void testPop() {
        assertNull(pila.pop());
        
        pila.push(10);
        assertEquals(10, pila.pop());
    }

    @Test
    void testIsEmpty() {
        assertTrue(pila.isEmpty());
        
        pila.push(15);
        assertFalse(pila.isEmpty());
    }

    @Test
    void testTop() {
        assertNull(pila.top());
        
        pila.push(8);
        assertEquals(8, pila.top());
    }
}
