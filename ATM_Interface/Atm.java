import java.util.*;

public class Atm 
{
    public static void main(String[] args) 
    {
        BankAccount b = new BankAccount();
        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\n---ATM MENU---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = sc.nextDouble();

                    if (b.withdraw(withdrawAmt)) 
                    {
                        System.out.println("Withdrawal Successful!");
                    } 
                    else 
                    {
                        System.out.println("Withdrawal failed. Check amount and balance!");
                    }

                    System.out.println("Balance: Rs." + b.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = sc.nextDouble();

                    if (b.deposit(depositAmt)) 
                    {
                        System.out.println("Deposit Successful!");
                    } 
                    else 
                    {
                        System.out.println("Deposit failed. Enter a valid amount!");
                    }

                    System.out.println("Balance: Rs." + b.getBalance());
                    break;

                case 3:
                    System.out.println("Current Balance: Rs." + b.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Choose a valid one!");
            }
        }
    }
}

class BankAccount 
{
    private double balance;

    public BankAccount() 
    {
        this.balance = 0.0;
    }

    public BankAccount(double initialBal) 
    {
        if (initialBal >= 0) 
        {
            balance = initialBal;
        } 
        else 
        {
            balance = 0;
        }
    }

    public double getBalance() 
    {
        return balance;
    }

    public boolean withdraw(double amt) 
    {
        if (amt > 0 && amt <= balance) 
        {
            balance -= amt;
            return true;
        } 
        else 
        {
            return false;
        }
    }

    public boolean deposit(double amt) 
    {
        if (amt > 0) 
        {
            balance += amt;
            return true;
        } 
        else 
        {
            return false;
        }
    }
}
