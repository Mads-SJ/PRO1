package E5_1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a integer: ");

        int number;
        if(scanner.hasNextInt()) {
            number = scanner.nextInt();
        }
        else {
            number = 0;
        }

        if(number > 0) {
            System.out.println("This integer is positive");
        }
        else if(number < 0) {
            System.out.println("This integer is negative");
        }
        else {
            System.out.println("This integer is zero");
        }
    }

}
