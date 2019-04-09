import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    private ShoppingCart testCart = new ShoppingCart();
    private Product soda = new Product("Coca Cola", 2.50);

    //Tests to see if the initial cart has 0 items
    @Test
    public void testInitialCart() throws Exception {
        assertEquals(0, testCart.getItemCount());
    }

    //Tests to see if the empty method empties the shopping cart properly.
    //This is done by adding an item to the cart, invoke the empty method, then testing.
    @Test
    public void testEmptyCart() throws Exception {
        testCart.addItem(soda);
        testCart.empty();
        assertEquals(0, testCart.getItemCount());
    }



}