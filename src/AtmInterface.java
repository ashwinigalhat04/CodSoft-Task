import java.util.Scanner;
import java.util.Random;
class BankAccount {
    private String accountNumber;
    private double balance;
    private String pin;

    public BankAccount(String accountNumber ,double balance) {
        this.accountNumber= accountNumber;
        this.balance = balance;
        this.pin = generatePin();
    }
    private String  generatePin(){
        StringBuilder sb=new StringBuilder();
        Random random =new Random();
        for(int i=0;i<4;i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    public double checkBalance(){
        return balance;

    }



    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void start() {
        int option;
        do {
            displayMenu();
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline not consumed by nextInt()

            switch (option) {
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 4);
    }
}
public class AtmInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345678",0.0);
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(account, scanner);
        atm.start();
        System.out.println("Thank You...!!");

    }
}
