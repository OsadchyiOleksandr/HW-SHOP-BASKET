package hillel.hw;

import java.util.List;
import java.util.Scanner;

public class ShoppingBasket {

    public void startApp() {
        ProductDataProvider productsDP = new ProductDataProvider();
        List<Product> products = productsDP.getProducts();
        ProductRepository productRepo = new ProductRepository(products);
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показати всі товари");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Видалити товар з кошика");
            System.out.println("4. Показати кошик");
            System.out.println("5. Вийти");

            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Товари доступні для покупки:");
                    for (Product product : productRepo.getAll()) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Введіть id товару для додавання: ");
                    int productIdToAdd = scanner.nextInt();
                    scanner.nextLine();
                    Product productToAdd = productRepo.getById(productIdToAdd);
                    if (productToAdd != null) {
                        cart.addToCart(productToAdd);
                        System.out.println("Товар " + productToAdd.getName() + " додано до кошика.");
                    } else {
                        System.out.println("Товар з таким id не знайдено.");
                    }
                    break;
                case 3:
                    System.out.print("Введіть id товару для видалення: ");
                    int productIdToRemove = scanner.nextInt();
                    scanner.nextLine();
                    Product productToRemove = cart.removeFromCart(productIdToRemove);
                    if (productToRemove != null) {
                        System.out.println("Товар " + productToRemove.getName() + " видалено з кошика.");
                    } else {
                        System.out.println("Товар з таким id не знайдено в кошику.");
                    }
                    break;

                case 4:
                    System.out.println("Ваш кошик:");
                    System.out.println(cart);
                    System.out.println("Загальна сума: " + cart.getTotalPrice());
                    break;

                case 5:
                    System.out.println("Вихід з програми.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}

