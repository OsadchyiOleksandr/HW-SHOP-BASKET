package hillel.hw.repository;

import hillel.hw.model.Product;
import hillel.hw.dataprovider.ProductDataProvider;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository(ProductDataProvider dataProvider) {
        this.products = dataProvider.getProducts();
    }

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
