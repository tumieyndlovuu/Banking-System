package banking;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.matches("-?\\d+"))
                return Integer.parseInt(input);
            System.out.println("  Invalid — enter a whole number.");
        }
    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+(\\.\\d+)?"))
                return Double.parseDouble(input);
            System.out.println("  Invalid — enter a positive number (e.g. 500.00).");
        }
    }

    public static String readString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String val = scanner.nextLine().trim();
            if (!val.isEmpty()) return val;
            System.out.println("  Input cannot be empty.");
        }
    }
}