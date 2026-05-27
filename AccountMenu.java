package banking;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountMenu {

    public static void run(Bank bank, Scanner scanner) throws SQLException {
        int choice;
        do {
            System.out.println("\n--- Account Management ---");
            System.out.println(" 1. Open New Account");
            System.out.println(" 2. View Accounts for Customer");
            System.out.println(" 3. Balance Enquiry");
            System.out.println(" 4. Close Account");
            System.out.println(" 0. Back");
            choice = InputValidator.readInt(scanner, "Choice: ");

            switch (choice) {
                case 1 -> openAccount(bank, scanner);
                case 2 -> viewAccounts(bank, scanner);
                case 3 -> balanceEnquiry(bank, scanner);
                case 4 -> closeAccount(bank, scanner);
                case 0 -> {}
                default -> System.out.println("  Invalid option.");
            }
        } while (choice != 0);
    }

    private static void openAccount(Bank bank, Scanner scanner) throws SQLException {
        int id = InputValidator.readInt(scanner, "Customer ID: ");
        Customer c = bank.findCustomerById(id);
        if (c == null) { System.out.println("  Customer not found."); return; }

        System.out.println("  Account type: 1 = Savings   2 = Cheque");
        int t = InputValidator.readInt(scanner, "  Select: ");
        String type = switch (t) {
            case 1 -> "Savings";
            case 2 -> "Cheque";
            default -> "";
        };
        if (type.isEmpty()) { System.out.println("  Invalid type."); return; }

        double deposit = InputValidator.readDouble(scanner, "  Initial deposit (R): ");
        bank.openAccount(id, type, deposit);
    }

    private static void viewAccounts(Bank bank, Scanner scanner) throws SQLException {
        int id = InputValidator.readInt(scanner, "Customer ID: ");
        bank.printAccountsForCustomer(id);
    }

    private static void balanceEnquiry(Bank bank, Scanner scanner) throws SQLException {
        String accNum = InputValidator.readString(scanner, "Account number: ");
        double balance = bank.getBalance(accNum);
        if (balance >= 0)
            System.out.printf("  Balance [%s]: R%.2f%n", accNum, balance);
    }

    private static void closeAccount(Bank bank, Scanner scanner) throws SQLException {
        String accNum = InputValidator.readString(scanner, "Account number to close: ");
        bank.closeAccount(accNum);
    }
}