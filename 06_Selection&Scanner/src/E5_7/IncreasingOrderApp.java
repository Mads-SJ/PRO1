package E5_7;

import java.util.Scanner;

public class IncreasingOrderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This program determines whether three integers are in increasing order.");
        System.out.print("Please write three integers on the same line with space in between: ");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();

        if(firstNumber < secondNumber && secondNumber < thirdNumber) {
            System.out.println("increasing");
        }
        else if(firstNumber > secondNumber && secondNumber > thirdNumber) {
            System.out.println("decreasing");
        }
        else {
            System.out.println("neither");
        }
    }
}
