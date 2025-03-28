public class BankTest {
    public static void main(String[] args) {
        // Create 3 bank accounts
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();
        BankAccount acc3 = new BankAccount();

        // Deposit Test
        acc1.deposit("checking", 1000);
        acc1.deposit("savings", 500);
        acc1.displayBalance();

        acc2.deposit("checking", 1200);
        acc2.deposit("savings", 800);
        acc2.displayBalance();

        acc3.deposit("savings", 1500);
        acc3.displayBalance();

        // Withdrawal Test
        acc1.withdraw("checking", 200);
        acc1.withdraw("savings", 600); // should fail
        acc1.displayBalance();

        acc2.withdraw("savings", 300);
        acc2.displayBalance();

        // Static Test
        System.out.println("\n==== Static Test ====");
        System.out.println("Total accounts: " + BankAccount.getAccounts());
        System.out.printf("Total money in system: $%.2f\n", BankAccount.getTotalMoney());
    }
}
