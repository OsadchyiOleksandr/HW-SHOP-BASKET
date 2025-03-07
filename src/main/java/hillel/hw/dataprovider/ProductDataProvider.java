package hillel.hw.dataprovider;

import hillel.hw.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDataProvider {

    private final List<Product> products = new ArrayList<>(){{
        add(new Product(1, "Product A", 100));
        add(new Product(2, "Product B", 200));
        add(new Product(3, "Product C", 300));
    }};

    public List<Product> getProducts() {
        return products;
    }
}
