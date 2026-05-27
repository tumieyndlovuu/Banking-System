package banking;

public class SavingsAccount extends Account {

    private static final int MAX_WITHDRAWALS = 3;
    private int    withdrawalCount = 0;
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer owner,
                          double initialDeposit, double interestRate) {
        super(accountNumber, owner, initialDeposit, "Savings");
        this.interestRate = interestRate;
    }

    /**
     *
     * @param amount
     */
    @Override
    public void withdraw(double amount) {
        if (withdrawalCount >= MAX_WITHDRAWALS)
            throw new IllegalStateException(
                "Monthly withdrawal limit reached (" + MAX_WITHDRAWALS + " max).");
        super.withdraw(amount);
        withdrawalCount++;
        System.out.println("  Withdrawals this month: "
                           + withdrawalCount + "/" + MAX_WITHDRAWALS);
    }

    public void applyInterest() {
        double balance = 0;
        double interest = balance * (interestRate / 100.0);
        balance += interest;
        System.out.printf("  Interest applied (%.1f%%): +R%.2f. New balance: R%.2f%n",
                          interestRate, interest, balance);
    }

    public void resetWithdrawalCount() {
        withdrawalCount = 0;
        System.out.println("  Monthly withdrawal count reset.");
    }

    public double getInterestRate()    { return interestRate;    }
    public int    getWithdrawalCount() { return withdrawalCount; }
}