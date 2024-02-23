package es.iessoterohernandez.daw.endes.BoletinJUnit.boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FridgeTest {
	private Fridge fridge;
	 @BeforeEach
	    void setUp() throws Exception {
	        fridge = new Fridge();
	    }

	    @ParameterizedTest
	    @ValueSource(strings = { "macarrones", "tortilla", "puchero" })
	    void testPut(String item) {
	        assertTrue(fridge.put(item));
	        assertTrue(fridge.contains(item));
	    }

	    @ParameterizedTest
	    @ValueSource(strings = { "macarrones", "tortilla", "puchero" })
	    void testTake(String item) throws NoSuchItemException {
	        fridge.put(item);
	        assertTrue(fridge.contains(item));
	        assertThrows(NoSuchItemException.class, () -> fridge.take("nonexistent"));
	        fridge.take(item);
	        assertTrue(!fridge.contains(item));
	    }
	    @ParameterizedTest
	    @ValueSource(strings = { "macarrones", "tortilla", "puchero" })
	    void testPutAndContains(String item) {
	        fridge.put(item);
	        assertTrue(fridge.contains(item));
	    }

	    @ParameterizedTest
	    @ValueSource(strings = { "macarrones", "tortilla", "puchero" })
	    void testContainsNonexistent(String item) {
	        assertFalse(fridge.contains(item));
	    }
}
