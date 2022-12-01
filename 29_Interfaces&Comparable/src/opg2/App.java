package opg2;

public class App {
    public static void main(String[] args) {
        Customer[] customers = new Customer[4];
        customers[0] = new Customer("Adam", "Andersen", 18);
        Customer c = new Customer("Berit", "Christensen", 18);
        customers[1] = c;
        customers[2] = new Customer("Casper", "Christensen", 18);
        customers[3] = new Customer("Casper", "Christensen", 20);

        System.out.println(lastCustomer(customers));

        Customer[] afterCustomer = afterCustomer(customers, c);

        for (Customer customer : afterCustomer) {
            System.out.println(customer);
        }
    }

    public static Customer lastCustomer(Customer[] customers) {
        Customer lastCustomer = customers[0];

        for (Customer c : customers) {
            if (c.compareTo(lastCustomer) > 0) {
                lastCustomer = c;
            }
        }

        return lastCustomer;
    }

    public static Customer[] afterCustomer(Customer[] customers,
                                           Customer customer) {
        Customer[] afterCustomer = new Customer[customers.length];

        for (int i = 0; i < customers.length; i++) {
            Customer c = customers[i];
            if (c.compareTo(customer) > 0) {
                afterCustomer[i] = c;
            }
        }

        return afterCustomer;
    }
}
