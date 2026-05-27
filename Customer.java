package banking;

import java.util.Scanner;

public class Customer {

    static void run(Bank bank, Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int    customerId;
    private String fullName;
    private String idNumber;
    private String email;
    private String phone;

    public Customer(int customerId, String fullName, String idNumber,
                    String email, String phone) {
        this.customerId = customerId;
        this.fullName   = fullName;
        this.idNumber   = idNumber;
        this.email      = email;
        this.phone      = phone;
    }

    public int    getCustomerId() { return customerId; }
    public String getFullName()   { return fullName;   }
    public String getIdNumber()   { return idNumber;   }
    public String getEmail()      { return email;      }
    public String getPhone()      { return phone;      }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email)       { this.email    = email;    }
    public void setPhone(String phone)       { this.phone    = phone;    }

    @Override
    public String toString() {
        return String.format(
            "| ID: %-4d | Name: %-20s | ID No: %-13s | Email: %-25s | Phone: %s",
            customerId, fullName, idNumber, email, phone
        );
    }
}
