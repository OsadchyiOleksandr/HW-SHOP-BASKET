package hillel.hw.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItemById(int id) {
        items.removeIf(product -> product.getId() == id);
    }

    public List<Product> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
