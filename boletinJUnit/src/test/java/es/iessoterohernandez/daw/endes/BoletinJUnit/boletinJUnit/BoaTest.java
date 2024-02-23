package es.iessoterohernandez.daw.endes.BoletinJUnit.boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BoaTest {


    @ParameterizedTest
    @CsvSource({
        "Boa1, 5, granola bars, true",  
        "Boa2, 10, mice, false",         
        "Boa3, 15, granola bars, true",  
        "Boa4, 20, granola bars, true"  
    })
   public void testIsHealthy(String name, int length, String favoriteFood, boolean expected) {
        Boa boa = new Boa(name, length, favoriteFood);
        assertEquals(expected, boa.isHealthy());
    }

    @ParameterizedTest
    @CsvSource({
        "Boa1, 5, granola bars, true",  
        "Boa2, 10, mice, false",         
        "Boa3, 15, granola bars, true", 
        "Boa4, 20, granola bars, true"  
    })
    public void testFitsInCage(String name, int length, String favoriteFood, boolean expected) {
        Boa boa = new Boa(name, length, favoriteFood);
        assertTrue(boa.fitsInCage(100)); 
    }
}
