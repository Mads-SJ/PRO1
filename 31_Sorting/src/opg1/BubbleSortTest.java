package opg1;

import measure.SortMethods;

public class BubbleSortTest {
    public static void main(String[] args) {
        String[] array = {"E", "F", "A", "D", "B"};

        SortMethods.bubbleSort(array);

        for (String s : array) {
            System.out.println(s);
        }
    }
}
