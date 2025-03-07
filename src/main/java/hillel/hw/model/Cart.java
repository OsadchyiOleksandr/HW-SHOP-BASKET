package hillel.hw.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final List<Product> items = new ArrayList<>();

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
        return "Cart{" + "items=" + items + '}';
    }
}
