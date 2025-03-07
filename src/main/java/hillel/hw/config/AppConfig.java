package hillel.hw.config;

import hillel.hw.controller.CartController;
import hillel.hw.repository.ProductRepository;
import hillel.hw.model.Cart;
import hillel.hw.service.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public Cart cart() {
        return new Cart();
    }

    @Bean
    public CartService cartService(ProductRepository productRepository, Cart cart) {
        return new CartService(productRepository, cart);
    }

    @Bean
    public CartController cartController(CartService cartService) {
        return new CartController(cartService);
    }
}
