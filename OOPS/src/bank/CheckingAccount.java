
package bank;

public class CheckingAccount extends Account {

    private final double overdraftLimit;
    private final double monthlyFee;

    public CheckingAccount(String number, String owner,
                           double opening, double overdraftLimit,
                           double monthlyFee) {

        super(number, owner, opening);

        if (overdraftLimit < 0 || monthlyFee < 0) {
            throw new IllegalArgumentException("Invalid account charges");
        }

        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return amount <= getBalance() + overdraftLimit;
    }

    @Override
    public void monthEnd() {

        if (monthlyFee > 0) {
            withdraw(monthlyFee);
            addHistory("MONTHLY FEE", monthlyFee);
        }
    }
}
