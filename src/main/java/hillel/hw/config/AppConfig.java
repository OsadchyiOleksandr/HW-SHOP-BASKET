package hillel.hw.config;

import hillel.hw.dataprovider.ProductDataProvider;
import hillel.hw.controller.CartController;
import hillel.hw.repository.ProductRepository;
import hillel.hw.model.Cart;
import hillel.hw.service.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductDataProvider dataProvider() {
        return new ProductDataProvider();
    }

    @Bean
    public ProductRepository productRepository(ProductDataProvider dataProvider) {
        return new ProductRepository(dataProvider);
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
