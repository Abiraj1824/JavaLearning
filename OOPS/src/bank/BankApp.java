
package bank;

public class BankApp {

    public static void main(String[] args) {

        SavingsAccount asha =
                new SavingsAccount("SAV-001", "Asha", 1000, 0.05);

        CheckingAccount abhi =
                new CheckingAccount("CHK-001", "Abhi", 200, 100, 5);

        SavingsAccount anshu =
                new SavingsAccount("SAV-002", "Anshu", 800);

        System.out.println("========== BANK ACCOUNTS ==========");

        System.out.println(asha);
        System.out.println(abhi);
        System.out.println(anshu);

        System.out.println("\n========== TRANSACTIONS ==========");

        asha.deposit(250);
        asha.withdraw(300);

        System.out.println("Asha deposited and withdrew money.");

        try {
            anshu.withdraw(5000);
        } catch (IllegalArgumentException e) {
            System.out.println("Anshu's transaction rejected: " + e.getMessage());
        }

        try {
            asha.transfer(abhi, 100, "Monthly transfer");
            System.out.println("Asha transferred 100 to Abhi.");
        } catch (InsufficientFundsException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        System.out.println("\n========== MONTH END ==========");

        asha.monthEnd();
        abhi.monthEnd();
        anshu.monthEnd();

        System.out.println(asha);
        System.out.println(abhi);
        System.out.println(anshu);

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        System.out.println("Asha's History:");

        for (String entry : asha.getHistory()) {
            System.out.println(entry);
        }

        System.out.println("\nAbhi's History:");

        for (String entry : abhi.getHistory()) {
            System.out.println(entry);
        }

        System.out.println("\nAnshu's History:");

        for (String entry : anshu.getHistory()) {
            System.out.println(entry);
        }
    }
}
