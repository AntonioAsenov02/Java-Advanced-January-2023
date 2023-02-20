package Lab_6DefiningClasses.P03BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int accountsCount = 0;
    private int id;
    private double balance;

    public BankAccount(){
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }
    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static int getAccountsCount() {
        return accountsCount;
    }

    public static void setAccountsCount(int accountsCount) {
        BankAccount.accountsCount = accountsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(Double money){
        this.balance += money;
    }

    public double getInterest(int years){
        return years * interestRate * this.balance;
    }


}