
package bank;

public class SavingsAccount extends Account {

    private final double interestRate;

    public SavingsAccount(String number, String owner,
                          double opening, double interestRate) {

        super(number, owner, opening);

        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }

        this.interestRate = interestRate;
    }

    public SavingsAccount(String number, String owner, double opening) {
        this(number, owner, opening, 0.03);
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return amount <= getBalance();
    }

    @Override
    public void monthEnd() {

        double interest = getBalance() * interestRate;

        if (interest > 0) {
            deposit(interest);
            addHistory("INTEREST", interest);
        }
    }
}
