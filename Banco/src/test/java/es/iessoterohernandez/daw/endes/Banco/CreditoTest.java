package es.iessoterohernandez.daw.endes.Banco;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditoTest {
    private Credito credito;
    private Cuenta cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new Cuenta("11111", "Paco Perez");
        credito = new Credito("1111111", "Paco Perez", new Date(), 1000);
        credito.setCuenta(cuenta);
    }

    @Test
    public void testRetirar() throws Exception {
        credito.retirar(500);
        assertEquals(475, credito.getCreditoDisponible()); // 5% de comisión
        assertThrows(Exception.class, () -> credito.retirar(600)); // Crédito insuficiente
    }

    @Test
    public void testIngresar() throws Exception {
        credito.ingresar(200);
        assertEquals(1200, credito.getCreditoDisponible());
    }

    @Test
    public void testPagoEnEstablecimiento() throws Exception {
        credito.pagoEnEstablecimiento("Tienda", 300);
        assertEquals(700, credito.getCreditoDisponible());
    }

    @Test
    public void testGetSaldo() throws Exception {
        credito.ingresar(200);
        credito.pagoEnEstablecimiento("Tienda", 300);
        assertEquals(300, credito.getSaldo());
    }

    @Test
    public void testGetCreditoDisponible() throws Exception {
        credito.ingresar(200);
        credito.pagoEnEstablecimiento("Tienda", 300);
        assertEquals(900, credito.getCreditoDisponible());
    }

    @Test
    public void testLiquidar() throws Exception {
        credito.ingresar(200);
        credito.pagoEnEstablecimiento("Tienda", 300);
        credito.liquidar(03, 2024);
        assertEquals(0,credito.getSaldo());
    }
}
