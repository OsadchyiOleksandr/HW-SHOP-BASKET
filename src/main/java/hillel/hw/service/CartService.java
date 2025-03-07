package hillel.hw.service;

import hillel.hw.model.Cart;
import hillel.hw.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final ProductRepository productRepository;
    private final Cart cart;

    @Autowired
    public CartService(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public void addProductToCart(int productId) {
        productRepository.getProductById(productId).ifPresent(cart::addItem);
    }

    public void removeProductFromCart(int productId) {
        cart.removeItemById(productId);
    }

    public Cart getCart() {
        return cart;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
