package P6_4;

import java.util.Scanner;

public class PrimeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prime Number Generator");
        System.out.print("Generate prime numbers up to: ");
        int number = scanner.nextInt();

        PrimeGenerator primeGenerator = new PrimeGenerator();
        primeGenerator.printPrimes(number);
    }
}
