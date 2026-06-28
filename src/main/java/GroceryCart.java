import java.util.List;
import java.util.ArrayList;
public class GroceryCart {
    private final List<GroceryItem> items = new ArrayList<>();

    public void addItem(GroceryItem item) {
        items.add(item);
    }

    public List<GroceryItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return 0;
    }
}