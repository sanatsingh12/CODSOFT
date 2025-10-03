import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double initial) {
        balance = initial;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Invalid Deposit!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            System.out.println("Invalid Withdrawal!");
        }
    }
}

class ATM {
    private BankAccount account;

    ATM(BankAccount acc) {
        account = acc;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    account.deposit(d);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    account.withdraw(w);
                    break;
                case 4:
                    System.out.println("Thank You for using ATM!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}

public class ATMInterface {
    public static void main(String args[]) {
        BankAccount acc = new BankAccount(5000); // starting balance
        ATM atm = new ATM(acc);
        atm.menu();
    }
}
