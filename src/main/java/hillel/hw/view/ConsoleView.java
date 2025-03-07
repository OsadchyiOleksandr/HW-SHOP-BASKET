package hillel.hw.view;

import org.springframework.stereotype.Component;

@Component
public class ConsoleView {
    public void printMessage(String message) {
        System.out.println(message);
    }
}

