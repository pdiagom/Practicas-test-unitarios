package es.iessoterohernandez.daw.endes.Banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {
	private Cuenta cuenta;
	@BeforeEach
	void setUp() {
		cuenta = new Cuenta("1234567890", "Juan");
	}
    @Test
    void testIngresar() {
        double saldoInicial = cuenta.getSaldo();
        double cantidad = 100.0;
        try {
            cuenta.ingresar(cantidad);
        } catch (Exception e) {
            fail("Se lanzó una excepción al ingresar una cantidad positiva: " + e.getMessage());
        }
        double saldoDespuesDeIngresar = cuenta.getSaldo();
        assertEquals(saldoInicial + cantidad, saldoDespuesDeIngresar, 0.001,
                "El saldo después de ingresar no es el esperado");
    }

    @Test
    void testRetirar() throws Exception {
    	cuenta.ingresar(100);
        double saldoInicial = cuenta.getSaldo();
        double cantidad = 50.0;
        try {
            cuenta.retirar(cantidad);
        } catch (Exception e) {
            fail("Se lanzó una excepción al retirar una cantidad positiva: " + e.getMessage());
        }
        double saldoDespuesDeRetirar = cuenta.getSaldo();
        assertEquals(saldoInicial - cantidad, saldoDespuesDeRetirar, 0.001,
                "El saldo después de retirar no es el esperado");
    }

    @Test
    void testIngresarNegativo() {
        assertThrows(Exception.class, () -> {
            cuenta.ingresar(-100.0);
        });
    }

    @Test
    void testRetirarNegativo() {
        assertThrows(Exception.class, () -> {
            cuenta.retirar(-50.0);
        });
    }

    @Test
    void testSaldoInsuficiente() {
        assertThrows(Exception.class, () -> {
            cuenta.retirar(1000.0);
        });
    }

    @Test
    void testIngresarConcepto() {
        double saldoInicial = cuenta.getSaldo();
        double cantidad = 200.0;
        String concepto = "Ingreso de nómina";
        try {
            cuenta.ingresar(concepto, cantidad);
        } catch (Exception e) {
            fail("Se lanzó una excepción al ingresar una cantidad con concepto: " + e.getMessage());
        }
        double saldoDespuesDeIngresar = cuenta.getSaldo();
        assertEquals(saldoInicial + cantidad, saldoDespuesDeIngresar, 0.001,
                "El saldo después de ingresar con concepto no es el esperado");
    }

    @Test
    void testRetirarConcepto() throws Exception {
    	cuenta.ingresar(100);
        double saldoInicial = cuenta.getSaldo();
        double cantidad = 100.0;
        String concepto = "Retirada de cajero";
        try {
            cuenta.retirar(concepto, cantidad);
        } catch (Exception e) {
            fail("Se lanzó una excepción al retirar una cantidad con concepto: " + e.getMessage());
        }
        double saldoDespuesDeRetirar = cuenta.getSaldo();
        assertEquals(saldoInicial - cantidad, saldoDespuesDeRetirar, 0.001,
                "El saldo después de retirar con concepto no es el esperado");
    }
}
