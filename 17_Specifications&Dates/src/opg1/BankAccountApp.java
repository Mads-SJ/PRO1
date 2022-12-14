package opg1;

public class BankAccountApp {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1000.0);
        BankAccount b2 = new BankAccount(2000.0);

        System.out.println(b1.getId());
        System.out.println(b2.getId());
    }
}
