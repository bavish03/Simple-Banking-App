import java.util.Scanner;
class Account {
    private double balance;
    private int accountNumber;
    

    public Account(int accNum, double initialDeposit) {
        this.accountNumber = accNum;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f. New balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f\n", amount, balance);
            return true;
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        } else {
            System.out.println("Withdrawal failed: Insufficient balance.");
            return false;
        }
    }

    public void checkBalance() {
        System.out.printf("Current Balance for Account %d: $%.2f\n", accountNumber, balance);
    }
}

public class SimpleBankingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account userAccount = new Account(123456, 500.00); 

        boolean running = true;
        while (running) {
            System.out.println("\n-------------------------------------");
            System.out.println("      Welcome to Simple Bank");
            System.out.println("-------------------------------------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                double amount;

                switch (choice) {
                    case 1:
                        userAccount.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        amount = scanner.nextDouble();
                        userAccount.deposit(amount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        amount = scanner.nextDouble();
                        userAccount.withdraw(amount);
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thank you for using Simple Bank. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
    }
}