package baseball.ui;

import java.util.Scanner;

public class Input {
    public static String receiveNumberInput(Scanner scanner) {
        Output.printRequestNumberInput();

        return scanner.nextLine();
    }

    public static String receiveResumeInput(Scanner scanner) {
        Output.printRequestResumeInput();

        return scanner.nextLine();
    }
}
