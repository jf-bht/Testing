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
}