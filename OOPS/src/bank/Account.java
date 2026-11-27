
package bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account implements Transactable {

    private final String accountNumber;
    private final String owner;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public Account(String accountNumber, String owner, double openingBalance) {

        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = openingBalance;

        history.add("OPEN " + openingBalance + " -> balance " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }

        balance += amount;

        history.add("DEPOSIT " + amount + " -> balance " + balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }

        if (!canWithdraw(amount)) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance -= amount;

        history.add("WITHDRAW " + amount + " -> balance " + balance);
    }

    protected abstract boolean canWithdraw(double amount);

    public abstract void monthEnd();

    public void transfer(Account target, double amount)
            throws InsufficientFundsException {

        if (target == null || target == this) {
            throw new IllegalArgumentException("Invalid target account");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        if (!canWithdraw(amount)) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        withdraw(amount);
        target.deposit(amount);
    }

    public void transfer(Account target, double amount, String note)
            throws InsufficientFundsException {

        transfer(target, amount);
        history.add("TRANSFER NOTE: " + note);
    }

    protected void addHistory(String type, double amount) {
        history.add(type + " " + amount + " -> balance " + balance);
    }

    @Override
    public String toString() {

        return getClass().getSimpleName()
                + " [" + accountNumber + "]"
                + " owner=" + owner
                + " balance=" + String.format("%.2f", balance);
    }
}
