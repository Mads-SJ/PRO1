package opg1;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        opg1.Customer c1 = new opg1.Customer("Børgesen", "Anders", 25);
        opg1.Customer c2 = new opg1.Customer("Andersen", "Anders", 25);
        opg1.Customer c3 = new opg1.Customer("Christensen", "Anders", 25);
        opg1.Customer c4 = new opg1.Customer("Ågesen", "Anders", 25);

        ArrayList<opg1.Customer> customers = new ArrayList<>();
        insertCustomer(customers, c1);
        insertCustomer(customers, c2);
        insertCustomer(customers, c3);
        insertCustomer(customers, c4);

        Customer c5 = new Customer("Børgesen", "Børge", 30);
        insertCustomer(customers, c5);
        System.out.println(customers);

        Customer[] customerArray = new Customer[10];
        customerArray[0] = c2;
        customerArray[1] = c1;
        customerArray[2] = c3;
        customerArray[3] = c4;

        for (Customer c : customers) {
            System.out.println(c);
        }

        insertCustomer(customerArray, c5);

        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public static void insertCustomer(ArrayList<Customer> customers, Customer customer) {
        boolean found = false;
        int i = 0;
        while (!found && i<customers.size()) {
            if (customers.get(i).compareTo(customer) > 0) {
                found = true;
            }
            else {
                i++;
            }
        }
        customers.add(i,customer);
    }

    public static void insertCustomer(Customer[] customers, Customer customer) {
        int j = customers.length - 1;
        while (j >= 0 && customers[j] == null) {
            j--;
        }
        j++;
        boolean found = false;
        while (!found && j > 0) {
            if (customer.compareTo(customers[j - 1]) > 0) {
                found = true;
            } else {
                customers[j] = customers[j - 1];
                j--;
            }
        }
        customers[j] = customer;
    }
}
