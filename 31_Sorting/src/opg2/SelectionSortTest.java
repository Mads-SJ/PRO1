package opg2;

import measure.SortMethods;
import model.Customer;

import java.util.ArrayList;

public class SelectionSortTest {
    public static void main(String[] args) {
        String[] array = {"C", "A", "B", "E", "D"};

        SortMethods.selectionSort(array);

        for (String s : array) {
            System.out.println(s);
        }
        System.out.println();

        Customer c1 = new Customer("Soendesrtrup", "Mads", 24);
        Customer c2 = new Customer("Hansen", "Ole", 24);
        Customer c3 = new Customer("Mikkel", "Overgaard", 24);
        Customer c4 = new Customer("Bentsen", "Bent", 24);


        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);

        SortMethods.selectionSort(customers);
        System.out.println(customers);
    }
}
