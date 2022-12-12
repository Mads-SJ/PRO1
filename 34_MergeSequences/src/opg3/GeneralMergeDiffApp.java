package opg3;

import opg1.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class GeneralMergeDiffApp {
    public static void main(String[] args) {
        Customer c1 = new Customer("Soendesrtrup", "Mads", 24);
        Customer c2 = new Customer("Hansen", "Ole", 24);
        Customer c3 = new Customer("Mikkel", "Overgaard", 24);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        Collections.sort(customers);

        Customer[] badCustomers = {c3};

        ArrayList<Customer> goodCustomers = goodCustomers(customers, badCustomers);

        System.out.println(goodCustomers);
    }

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * customers fra l1 der ikke er i l2
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static ArrayList goodCustomers(ArrayList<Customer> l1,
                                          Customer[] l2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) < 0) {
                result.add(l1.get(i1));
                i1++;
            } else if (l1.get(i1).compareTo(l2[i2]) == 0) {
                i1++;
                i2++;
            } else {
                i2++;
            }
        }

        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        return result;
    }
}
