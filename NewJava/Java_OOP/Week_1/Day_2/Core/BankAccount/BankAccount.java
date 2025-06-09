import java.util.Random;

public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    private static int accounts = 0;
    private static double totalMoney = 0.0;

    // CONSTRUCTOR
    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = generateAccountNumber();
        accounts++;
    }

    // PRIVATE METHOD (Ninja Bonus)
    private String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder accNum = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accNum.append(rand.nextInt(10)); // generates digit 0-9
        }
        return accNum.toString();
    }

    // GETTERS
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // DEPOSIT METHOD
    public void deposit(String accountType, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit must be positive.");
            return;
        }

        if (accountType.equalsIgnoreCase("checking")) {
            checkingBalance += amount;
        } else if (accountType.equalsIgnoreCase("savings")) {
            savingsBalance += amount;
        } else {
            System.out.println("Invalid account type.");
            return;
        }
        totalMoney += amount;
    }

    // WITHDRAW METHOD
    public void withdraw(String accountType, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be positive.");
            return;
        }

        if (accountType.equalsIgnoreCase("checking")) {
            if (checkingBalance >= amount) {
                checkingBalance -= amount;
                totalMoney -= amount;
            } else {
                System.out.println("Insufficient funds in checking.");
            }
        } else if (accountType.equalsIgnoreCase("savings")) {
            if (savingsBalance >= amount) {
                savingsBalance -= amount;
                totalMoney -= amount;
            } else {
                System.out.println("Insufficient funds in savings.");
            }
        } else {
            System.out.println("Invalid account type.");
        }
    }

    // BALANCE METHOD
    public void displayBalance() {
        System.out.printf("Account %s | Checking: $%.2f | Savings: $%.2f | Total: $%.2f\n", 
                        accountNumber, checkingBalance, savingsBalance, checkingBalance + savingsBalance);
    }
}
