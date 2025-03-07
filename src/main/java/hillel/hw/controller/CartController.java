package hillel.hw.controller;

import hillel.hw.service.CartService;
import hillel.hw.view.ConsoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class CartController {
    ConsoleView view = new ConsoleView();
    private final CartService cartService;
    private final Scanner scanner;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            view.printMessage("\nМеню:" +
                    "\n1. Показати всі товари" +
                    "\n2. Додати товар до кошика" +
                    "\n3. Видалити товар з кошика" +
                    "\n4. Показати кошик" +
                    "\n5. Вийти");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    view.printMessage("Список всіх товарів:");
                    cartService.getProductRepository().getAllProducts().forEach(System.out::println);
                    break;
                }
                case 2: {
                    view.printMessage("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    cartService.addProductToCart(id);
                    break;
                }
                case 3: {
                    view.printMessage("Введіть ID товару для видалення з кошика:");
                    int id = scanner.nextInt();
                    cartService.removeProductFromCart(id);
                    break;
                }
                case 4: {
                    view.printMessage("Вміст кошика:");
                    cartService.getCart().getItems().forEach(System.out::println);
                    break;
                }
                case 5: {
                    view.printMessage("Вихід...");
                    return;
                }
                default:
                    view.printMessage("Невірний вибір.");
            }
        }
    }
}
