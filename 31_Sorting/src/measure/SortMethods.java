package measure;

import model.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class SortMethods {

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    public static void bubbleSort(String[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    public static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String next = array[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(array[j - 1]) >= 0) {
                    found = true;
                } else {
                    array[j] = array[j - 1];
                    j--;
                }
            }
            array[j] = next;
        }
    }
    
    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minPos]) < 0) {
                    minPos = j;
                }
            }
            swap(array, i, minPos);
        }
    }

    public static void selectionSort(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minPos)) < 0) {
                    minPos = j;
                }
            }
            Collections.swap(list, i, minPos);
        }
    }

}
