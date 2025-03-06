package hillel.hw;

import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAll() {
        return products;
    }

    public Product getById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}

