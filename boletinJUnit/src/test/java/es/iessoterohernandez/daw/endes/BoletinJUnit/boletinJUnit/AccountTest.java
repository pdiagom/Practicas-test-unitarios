package es.iessoterohernandez.daw.endes.BoletinJUnit.boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void testAccount() {
	     Account account = new Account("Paco Martinez", 123456789, 1000.00f);
	        assertEquals("Paco Martinez", account.name);
	        assertEquals(123456789, account.getAccountNumber());
	        assertEquals(1000.00f, account.getBalance());
	}

	@Test
    void testDeposit() {
        Account account = new Account("Paco Martinez", 123456789, 1000);
        

        assertTrue(account.deposit(500));
        assertEquals(1500, account.getBalance());
        

        assertFalse(account.deposit(-200));
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() {
        Account account = new Account("Maria Garcia", 987654321, 2000);
        

        assertTrue(account.withdraw(1000, 0));
        assertEquals(1000, account.getBalance());
        

        assertFalse(account.withdraw(-200, 0));
        assertEquals(1000, account.getBalance());
        

        assertFalse(account.withdraw(500, -50));
        assertEquals(1000, account.getBalance());
        
 
        assertFalse(account.withdraw(1000, 10));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testAddInterest() {
        Account account = new Account("Manoli Jimenez", 123456789, 3000);
        
        account.addInterest();
        

        assertEquals(3000 + (3000 * 0.045), account.getBalance());
    }

    @Test
    void testGetBalance() {
        Account account = new Account("Juan Rodriguez", 1357924680, 4000);
        

        assertEquals(4000, account.getBalance());
        

        account.deposit(1000);
        assertEquals(5000, account.getBalance());
    }

    @Test
    void testGetAccountNumber() {
        Account account = new Account("Eva Torrado", 1122334455, 5000);
        
        assertEquals(1122334455, account.getAccountNumber());
    }

    @Test
    void testToString() {
        Account account = new Account("Antonio Blanco", 314159265, 6000);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        assertEquals("314159265 Antonio Blanco "+fmt.format(6000), account.toString());

    }

}
