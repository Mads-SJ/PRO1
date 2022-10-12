package opgave4barchart;

import java.util.ArrayList;
import java.util.Scanner;

public class BarChart {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<String> headers = new ArrayList<>();

    public ArrayList<Integer> readValues() {
        System.out.println("Indtast nogle positive tal.  " + "Indtast et negativt tal for at afslutte: ");

        Scanner in = new Scanner(System.in);
        String[] inputs = in.nextLine().split(" ");

        for (int i = 0; i < inputs.length; i += 2) {
            String s = inputs[i];
            int n = Integer.parseInt(inputs[i + 1]);
            headers.add(s);
            numbers.add(n);
        }
        return numbers;
    }

    /**
     * Finds and returns the max value in the list.
     *
     * @param list
     *            the list with values.
     * @return the max value found.
     */
    public int findMax(ArrayList<Integer> list) {
        int max = 0;
        for (int n : list) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public int longestHeader(ArrayList<String> list) {
        int max = 0;
        for (String s : list) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    /**
     * Prints out a BarChart of the values using the System.out.println method.
     */
    public void printBarChart() {
        int max = findMax(this.numbers);
        double ratio = (double) 40 / max;

        for (int i = 0; i < numbers.size(); i++) {
            int n = numbers.get(i);
            int noOfStars = (int) Math.round(n * ratio);
            String header = headers.get(i);

            String bar = header +
                    " ".repeat(longestHeader(headers) - header.length() + 5) +
                    "*".repeat(noOfStars);

            System.out.println(bar);
        }

//        for (int n : list) {
//            for (int i = 0; i < n; i++) {
//                if (i == n - 1) {
//                    System.out.println("*");
//                } else {
//                System.out.print("*");
//                }
//            }
//        }
    }
}
