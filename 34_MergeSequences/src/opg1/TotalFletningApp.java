package opg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TotalFletningApp {
    public static void main(String[] args) {
        Customer c1 = new Customer("Soendesrtrup", "Mads", 24);
        Customer c2 = new Customer("Hansen", "Ole", 24);
        Customer c3 = new Customer("Mikkel", "Overgaard", 24);
        Customer c4 = new Customer("Bentsen", "Bent", 24);
        Customer c5 = new Customer("Mellergaard", "Christopher", 24);
        Customer c6 = new Customer("Ågesen", "Åge", 24);
        Customer c7 = new Customer("Yversen", "Yver", 24);
        Customer c8 = new Customer("Hannesen", "Hanne", 24);

        ArrayList<Customer> customers1 = new ArrayList<>();
        ArrayList<Customer> customers2 = new ArrayList<>();

        customers1.add(c1);
        customers1.add(c2);
        customers1.add(c3);
        customers1.add(c4);

        customers2.add(c5);
        customers2.add(c6);
        customers2.add(c7);
        customers2.add(c8);

        Collections.sort(customers1);
        Collections.sort(customers2);

        System.out.println(fletAlleKunder(customers1, customers2));
    }

    public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1,
                                           ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo(l2.get(i2)) <= 0) {
                result.add(l1.get(i1));
                i1++;
            } else {
                result.add(l2.get(i2));
                i2++;
            }
        }

        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }

        return result;
    }
}
