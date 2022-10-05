package model;

public class E1_4 {
    public static void main(String[] args) {
        double total = 1000;
        total *= 1.05;
        System.out.println("First year: " + total);
        total *= 1.05;
        System.out.println("Second year: " + total);
        total *= 1.05;
        System.out.println("Third year: " + total);

        /*double total = 1000;
        for (int i = 1; i <= 3; i++) {
            total *= 1.05;
            System.out.println("Year " + i + ": " + total);
        }*/
    }
}
