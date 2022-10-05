package E3_8;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addInterest(double rate) {
        balance *= rate / 100 + 1;
    }
}
