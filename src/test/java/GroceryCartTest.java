import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class GroceryCartTest {

    private GroceryCart cart;
    @BeforeEach
    void setUp() {
        cart = new GroceryCart();
    }

    @Test
    void testAddItemIncreasesSize() {
        GroceryItem item = new GroceryItem("Tomaten", 1.99, 2);
        cart.addItem(item);
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void testGetTotalPrice() {
        cart.addItem(new GroceryItem("Tomaten", 1.99, 2));
        cart.addItem(new GroceryItem("Milch", 0.99, 1));
        assertEquals(4.97, cart.getTotalPrice(), 0.01);
    }
    @Test
    void testRemoveItemDecreasesSize() {
        GroceryItem tomaten = new GroceryItem("Tomaten", 1.99, 2);
        cart.addItem(tomaten);
        cart.removeItem(tomaten);
        assertEquals(0, cart.getItems().size());
    }
}