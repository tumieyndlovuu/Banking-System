package banking;

import java.sql.SQLException;
import java.util.Scanner;

public class TransactionMenu {

    public static void run(Bank bank, Scanner scanner) throws SQLException {
        int choice;
        do {
            System.out.println("\n--- Transactions ---");
            System.out.println(" 1. Deposit");
            System.out.println(" 2. Withdraw");
            System.out.println(" 3. Transfer");
            System.out.println(" 0. Back");
            choice = InputValidator.readInt(scanner, "Choice: ");

            switch (choice) {
                case 1 -> deposit(bank, scanner);
                case 2 -> withdraw(bank, scanner);
                case 3 -> transfer(bank, scanner);
                case 0 -> {}
                default -> System.out.println("  Invalid option.");
            }
        } while (choice != 0);
    }

    private static void deposit(Bank bank, Scanner scanner) throws SQLException {
        String accNum = InputValidator.readString(scanner, "Account number: ");
        double amount = InputValidator.readDouble(scanner, "Amount (R): ");
        bank.deposit(accNum, amount);
    }

    private static void withdraw(Bank bank, Scanner scanner) throws SQLException {
        String accNum = InputValidator.readString(scanner, "Account number: ");
        double amount = InputValidator.readDouble(scanner, "Amount (R): ");
        bank.withdraw(accNum, amount);
    }

    private static void transfer(Bank bank, Scanner scanner) throws SQLException {
        String from   = InputValidator.readString(scanner, "From account: ");
        String to     = InputValidator.readString(scanner, "To account:   ");
        double amount = InputValidator.readDouble(scanner, "Amount (R):   ");
        bank.transfer(from, to, amount);
    }
}
