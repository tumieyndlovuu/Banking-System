package banking;

import java.sql.SQLException;
import java.util.Scanner;
import javax.lang.model.SourceVersion;

public class Banking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("==========================================");
        System.out.println("       WELCOME TO JAVA BANKING SYSTEM     ");
        System.out.println("==========================================");

        try {
            DatabaseConnection.getConnection();

            int choice;
            do {
                printMenu();
                choice = InputValidator.readInt(scanner, "Enter choice: ");

                switch (choice) {
                    case 1 -> CustomerMenu.run(bank, scanner);
                    case 2 -> AccountMenu.run(bank, scanner);
                    case 3 -> TransactionMenu.run(bank, scanner);
                    case 4 -> bank.printAllAccounts();
                    case 0 -> System.out.println("\nGoodbye!");
                    default -> System.out.println("Invalid option.");
                }
            } while (choice != 0);

            DatabaseConnection.closeConnection();

        } catch (SQLException e) {
            System.out.println("\n  DATABASE ERROR: " + e.getMessage());
            System.out.println("  Make sure XAMPP MySQL is running and banking_db exists.");
        } finally {
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println(" 1. Customer Management");
        System.out.println(" 2. Account Management");
        System.out.println(" 3. Transactions");
        System.out.println(" 4. View All Accounts");
        System.out.println(" 0. Exit");
        System.out.println("================================");
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

}
