package E3_8;

public class BackAccountTester {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        bankAccount.addInterest(10);
        System.out.println("Expected: 1100, got: " + bankAccount.getBalance());
    }
}
