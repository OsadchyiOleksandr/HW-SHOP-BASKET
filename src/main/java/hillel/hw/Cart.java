package hillel.hw;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addToCart(Product product) {
        items.add(product);
    }

    public Product removeFromCart(int productId) {
        for (Product product : items) {
            if (product.getId() == productId) {
                items.remove(product);
                return product;
            }
        }
        return null;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        int id = 0;
        String basket = "Cart:\n";
        for(Product product: this.items){
            id++;
            basket += id + ". " + product.toString() + "\n";
        }
        return basket;
    }
}

