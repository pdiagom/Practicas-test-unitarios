package es.iessoterohernandez.daw.endes.Banco;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class DebitoTest {
    private Debito debito;
    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        cuenta = new Cuenta("12345", "Paco Martin");
        debito = new Debito("12345", "Paco Martin", new Date());
        debito.setCuenta(cuenta);
    }

    @Test
    void testRetirar() throws Exception {
        cuenta.ingresar(500);
        debito.retirar(200);
        assertEquals(300, cuenta.getSaldo(), 0.01);
    }

    @Test
    void testIngresar() throws Exception {
        debito.ingresar(300);
        assertEquals(300, cuenta.getSaldo(), 0.01);
    }

    @Test
    void testPagoEnEstablecimiento() throws Exception {
        cuenta.ingresar(1000);
        debito.pagoEnEstablecimiento("Supermercado", 300);
        assertEquals(700, cuenta.getSaldo(), 0.01);
    }

    @Test
    void testGetSaldo() {
        assertEquals(0, debito.getSaldo(), 0.01);
    }
}
