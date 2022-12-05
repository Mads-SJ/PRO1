package measure;

import java.util.ArrayList;

public class SortTester {

    public static void main(String[] args) {
        testSorting(1000);
        testSorting(5000);
        testSorting(50000);
    }

    public static void testSorting(int testSize) {
        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);

        // System.out.println(bigList);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
        System.out.println(String.format("BubbleSort (%d) -- Total time in milliseconds: %d",
                testSize, Measurer.durationMilliSeconds()));

        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
        System.out.println(String.format("SelectionSort (%d) -- Total time in milliseconds: %d",
                testSize, Measurer.durationMilliSeconds()));

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
        System.out.println(String.format("InsertionSort (%d) -- Total time in milliseconds: %d",
                testSize, Measurer.durationMilliSeconds()));
    }
}
