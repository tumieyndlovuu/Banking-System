package banking;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerMenu {

    public static void run(Bank bank, Scanner scanner) throws SQLException {
        int choice;
        do {
            System.out.println("\n--- Customer Management ---");
            System.out.println(" 1. Register New Customer");
            System.out.println(" 2. View All Customers");
            System.out.println(" 3. Update Customer Email");
            System.out.println(" 4. Update Customer Phone");
            System.out.println(" 0. Back");
            choice = InputValidator.readInt(scanner, "Choice: ");

            switch (choice) {
                case 1 -> registerCustomer(bank, scanner);
                case 2 -> bank.printAllCustomers();
                case 3 -> updateEmail(bank, scanner);
                case 4 -> updatePhone(bank, scanner);
                case 0 -> {}
                default -> System.out.println("  Invalid option.");
            }
        } while (choice != 0);
    }

    private static void registerCustomer(Bank bank, Scanner scanner) throws SQLException {
        System.out.println("\n-- Register New Customer --");
        String name  = InputValidator.readString(scanner, "Full name:  ");
        String idNum = InputValidator.readString(scanner, "ID number:  ");
        String email = InputValidator.readString(scanner, "Email:      ");
        String phone = InputValidator.readString(scanner, "Phone:      ");
        bank.registerCustomer(name, idNum, email, phone);
    }

    private static void updateEmail(Bank bank, Scanner scanner) throws SQLException {
        int id = InputValidator.readInt(scanner, "Customer ID: ");
        Customer c = bank.findCustomerById(id);
        if (c == null) { System.out.println("  Customer not found."); return; }
        String newEmail = InputValidator.readString(scanner, "New email: ");
        bank.updateCustomerEmail(id, newEmail);
    }

    private static void updatePhone(Bank bank, Scanner scanner) throws SQLException {
        int id = InputValidator.readInt(scanner, "Customer ID: ");
        Customer c = bank.findCustomerById(id);
        if (c == null) { System.out.println("  Customer not found."); return; }
        String newPhone = InputValidator.readString(scanner, "New phone: ");
        bank.updateCustomerPhone(id, newPhone);
    }
}