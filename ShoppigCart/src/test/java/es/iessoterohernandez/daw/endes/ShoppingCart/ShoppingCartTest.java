

package es.iessoterohernandez.daw.endes.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart carro;
    private Product producto1;
    private Product producto2;
    
    @BeforeEach
   public void setUp() {
        carro = new ShoppingCart();
        producto1 = new Product("Producto 1", 10.00);
        producto2 = new Product("Producto 2", 20.00);
    }
    
    @Test
   public void testNewCart() {
        assertEquals(0, carro.getItemCount());
    }
    
    @Test
    public void testEmptyCart() {
        assertEquals(0, carro.getItemCount());
    }
    
    @Test
   public  void testAddProduct() {
    	int elementos=0;
        carro.addItem(producto1);
        assertEquals(elementos+1, carro.getItemCount());
    }
    
    @Test
    void testAddProductBalance() {
        carro.addItem(producto1);
        double balance=carro.getBalance();
        assertEquals(10.00, carro.getBalance());
        carro.addItem(producto2);
        assertEquals(balance+20.00,carro.getBalance());
    }
    
    @Test
    void testRemoveProduct() {
        carro.addItem(producto1);
        try {
			carro.removeItem(producto1);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
        assertEquals(0, carro.getItemCount());
    }
    
    @Test
    void testProductNotFound() {
    	try {
    		carro.removeItem(producto1);
    		fail("No se lanzara la excepcion");
    	} catch(ProductNotFoundException e){
    		System.err.println("No se ha encontrado el producto: "+e.getMessage());
    		//e.printStackTrace();
    	}
    }
}
