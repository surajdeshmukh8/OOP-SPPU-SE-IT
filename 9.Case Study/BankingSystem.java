/**9.Using concepts of Object-Oriented programming java develop solution for  one application 
 Banking system having following operations : 

1. Create an account 
2. Deposit money 
3. Withdraw money 
4. Honor daily withdrawal limit
5. Check the balance 
6. Display Account information.*/




import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private double dailyWithdrawalLimit;
    private double dailyWithdrawnAmount;

    // Constructor to initialize account
    public Account(String accountNumber, String accountHolder, double dailyWithdrawalLimit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0; // Starting with zero balance
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.dailyWithdrawnAmount = 0.0;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New Balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money, honoring daily withdrawal limit
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else if ((dailyWithdrawnAmount + amount) > dailyWithdrawalLimit) {
                System.out.println("Daily withdrawal limit exceeded.");
            } else {
                balance -= amount;
                dailyWithdrawnAmount += amount;
                System.out.println("Withdrawal successful! New Balance: $" + balance);
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }

    // Method to display account information
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Daily Withdrawal Limit: $" + dailyWithdrawalLimit);
        System.out.println("Amount Withdrawn Today: $" + dailyWithdrawnAmount);
    }

    // Method to reset daily withdrawal amount (could be scheduled for daily reset)
    public void resetDailyWithdrawnAmount() {
        dailyWithdrawnAmount = 0.0;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a new account
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter daily withdrawal limit: ");
        double dailyLimit = scanner.nextDouble();

        Account account = new Account(accountNumber, accountHolder, dailyLimit);

        int choice;
        do {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Information");
            System.out.println("5. Reset Daily Withdrawn Amount (Admin)");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 4:
                    account.displayAccountInfo();
                    break;
                case 5:
                    account.resetDailyWithdrawnAmount();
                    System.out.println("Daily withdrawn amount reset.");
                    break;
                case 6:
                    System.out.println("Thank you for using the Banking System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
