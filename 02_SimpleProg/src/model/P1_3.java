package model;

public class P1_3 {
    public static void main(String[] args) {
        System.out.println(computePi(1000000));
    }

    public static double computePi(int iterations) {
        double quarterPi = 1;
        boolean positive = false;
        double bottom = 3;

        for(int i = 0; i < iterations; i++) {
            System.out.println(bottom);
            if(positive) {
                quarterPi += 1 / bottom;
                positive = false;
            }
            else {
                quarterPi -= 1 / bottom;
                positive = true;
            }
            bottom += 2;
        }

        return quarterPi * 4;
    }
}