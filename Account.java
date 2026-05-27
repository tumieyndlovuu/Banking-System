package banking;

public abstract class Account {

    protected String   accountNumber;
    protected Customer owner;
    protected double   balance;
    protected String   accountType;

    public Account(String accountNumber, Customer owner,
                   double initialDeposit, String accountType) {
        this.accountNumber = accountNumber;
        this.owner         = owner;
        this.balance       = initialDeposit;
        this.accountType   = accountType;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
        System.out.printf("  Deposited R%.2f. New balance: R%.2f%n", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient funds.");
        balance -= amount;
        System.out.printf("  Withdrew R%.2f. New balance: R%.2f%n", amount, balance);
    }

    public double   getBalance()       { return balance;       }
    public String   getAccountNumber() { return accountNumber; }
    public Customer getOwner()         { return owner;         }
    public String   getAccountType()   { return accountType;   }

    @Override
    public String toString() {
        return String.format(
            "| Acc: %-12s | Type: %-10s | Owner: %-20s | Balance: R%.2f",
            accountNumber, accountType, owner.getFullName(), balance
        );
    }
}