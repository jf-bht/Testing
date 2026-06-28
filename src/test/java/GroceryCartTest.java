import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class GroceryCartTest {

    @Test
    void testAddItemIncreasesSize() {
        GroceryCart cart = new GroceryCart();
        GroceryItem item = new GroceryItem("Tomaten", 1.99, 2);
        cart.addItem(item);
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void testGetTotalPrice() {
        GroceryCart cart = new GroceryCart();
        cart.addItem(new GroceryItem("Tomaten", 1.99, 2));
        cart.addItem(new GroceryItem("Milch", 0.99, 1));
        assertEquals(4.97, cart.getTotalPrice(), 0.01);
    }
}