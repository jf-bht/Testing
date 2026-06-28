import java.util.List;
import java.util.ArrayList;
public class GroceryCart {
    private final List<GroceryItem> items = new ArrayList<>();

    public void addItem(GroceryItem item) {
        items.add(item);
    }
    public void removeItem(GroceryItem item) {
        if (!items.remove(item)) {
            throw new IllegalArgumentException("Item nicht im Warenkorb: " + item.name());
        }
    }

    public List<GroceryItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.price() * item.quantity())
                .sum();
    }
}