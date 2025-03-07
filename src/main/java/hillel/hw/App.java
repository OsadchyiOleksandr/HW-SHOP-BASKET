package hillel.hw;

import hillel.hw.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hillel.hw.controller.CartController;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CartController cartController = context.getBean(CartController.class);
        cartController.showMenu();
        context.close();
    }
}
