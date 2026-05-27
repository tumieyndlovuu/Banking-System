package banking;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            Bank bank = new Bank();
            
            System.out.println("==========================================");
            System.out.println("       WELCOME TO JAVA BANKING SYSTEM     ");
            System.out.println("==========================================");
            
            DatabaseConnection.getConnection();
            int choice;
            do {
                printMenu();
                choice = InputValidator.readInt(scanner, "Enter choice: ");
                
                switch (choice) {
                    case 1 -> Customer.run(bank, scanner);
                    case 2 -> AccountMenu.run(bank, scanner);
                    case 3 -> TransactionMenu.run(bank, scanner);
                    case 4 -> bank.printAllAccounts();
                    case 0 -> System.out.println("\nGoodbye!");
                    default -> System.out.println("Invalid option.");
                }
            } while (choice != 0);
            DatabaseConnection.closeConnection();
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
}
