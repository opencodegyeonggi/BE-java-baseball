package baseball.ui;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    public static void initializeScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    public static String receiveNumberInput() {
        Output.printRequestNumberInput();

        return scanner.nextLine();
    }

    public static String receiveResumeInput() {
        Output.printRequestResumeInput();

        return scanner.nextLine();
    }
}
