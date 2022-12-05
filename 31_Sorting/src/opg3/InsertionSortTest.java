package opg3;

import measure.SortMethods;

public class InsertionSortTest {
    public static void main(String[] args) {
        String[] array = {"C", "A", "B", "E", "D"};

        SortMethods.insertionSort(array);

        for (String s : array) {
            System.out.println(s);
        }
        System.out.println();
    }
}
