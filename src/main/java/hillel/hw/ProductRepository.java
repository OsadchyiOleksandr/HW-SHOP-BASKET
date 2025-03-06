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

    public void addProduct(Product product) {
        if (getById(product.getId()) == null) {
            products.add(product);
        }
    }

    public Product updateProduct(int productId, String name, double price) {
        Product product = getById(productId);
        if (product != null) {
            if (name != null) {
                product = new Product(productId, name, price);
            }
            return product;
        }
        return null;
    }

    public Product deleteProduct(int productId) {
        Product product = getById(productId);
        if (product != null) {
            products.remove(product);
            return product;
        }
        return null;
    }
}

