package hillel.hw.controller;

import hillel.hw.dataprovider.ProductDataProvider;
import hillel.hw.service.CartService;
import hillel.hw.repository.ProductRepository;

import java.util.Scanner;

public class CartController {
    private CartService cartService;
    private ProductRepository productRepository;
    private Scanner scanner;

    public CartController(CartService cartService) {
        this.cartService = cartService;
        this.productRepository = new ProductRepository(new ProductDataProvider());
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показати всі товари");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Видалити товар з кошика");
            System.out.println("4. Показати кошик");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Список всіх товарів:");
                    productRepository.getAllProducts().forEach(System.out::println);
                    break;
                }
                case 2: {
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    cartService.addProductToCart(id);
                    break;
                }
                case 3: {
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int id = scanner.nextInt();
                    cartService.removeProductFromCart(id);
                    break;
                }
                case 4: {
                    System.out.println("Вміст кошика:");
                    cartService.getCart().getItems().forEach(System.out::println);
                    break;
                }
                case 5: {
                    System.out.println("Вихід...");
                    return;
                }
                default:
                    System.out.println("Невірний вибір.");
            }
        }
    }
}
