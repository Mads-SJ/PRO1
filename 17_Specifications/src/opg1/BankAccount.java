package opg1;

/**
 * Models a bank account.
 */
public class BankAccount {
    private double balance;
    private final int id;
    private static int noOfAccounts = 0;

    /**
     * Initializes a new bank account with an initial balance and a unique id.
     * @param initialBalance is the initial balance.
     * Pre: initialBalance >= 0
     */
    public BankAccount(double initialBalance) {
        noOfAccounts++;
        id = BankAccount.noOfAccounts;
        balance = initialBalance;
    }

    /**
     * Deposits an amount to the current balance.
     * @param amount is the amount of money to deposit.
     * Pre: amount >= 0
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw an amount from the current balance.
     * @param amount s the amount of money to withdraw.
     * Pre: amount >= 0
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Returns the current balance of the account.
     * @return the current balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return the id of the account.
     */
    public int getId() {
        return id;
    }

    /**
     * @return the number of overall bank accounts.
     */
    public static int numberOfBankAccounts() {
        return BankAccount.noOfAccounts;
    }
}
