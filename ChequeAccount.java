package banking;

public class ChequeAccount extends Account {

    private double overdraftLimit;

    public ChequeAccount(String accountNumber, Customer owner,
                         double initialDeposit, double overdraftLimit) {
        super(accountNumber, owner, initialDeposit, "Cheque");
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        double balance = 0;
        if (balance - amount < -overdraftLimit)
            throw new IllegalArgumentException(String.format(
                "Exceeds overdraft limit. Available: R%.2f (incl. R%.2f overdraft)",
                balance + overdraftLimit, overdraftLimit));

        balance -= amount;
        System.out.printf("  Withdrew R%.2f. New balance: R%.2f%n", amount, balance);

        if (balance < 0)
            System.out.printf("  Account is in overdraft by R%.2f%n", Math.abs(balance));
    }

    public double getOverdraftLimit() { return overdraftLimit; }

    public void setOverdraftLimit(double limit) {
        if (limit < 0)
            throw new IllegalArgumentException("Overdraft limit cannot be negative.");
        this.overdraftLimit = limit;
    }
}
