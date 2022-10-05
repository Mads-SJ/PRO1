package P6_4;

public class PrimeGenerator {
    public PrimeGenerator() {}

    private boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void printPrimes(int limit) {
        for (int i = 2; i <= limit; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
