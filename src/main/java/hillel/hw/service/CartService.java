package hillel.hw.service;

import hillel.hw.model.Cart;
import hillel.hw.model.Product;
import hillel.hw.repository.ProductRepository;

public class CartService {
    private ProductRepository productRepository;
    private Cart cart;

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
}
