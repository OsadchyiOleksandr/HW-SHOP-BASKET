package hillel.hw.repository;

import hillel.hw.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>() {{
        add(new Product(1, "Product A", 100));
        add(new Product(2, "Product B", 200));
        add(new Product(3, "Product C", 300));
    }};

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}

