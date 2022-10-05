package P5_13;

import java.util.Scanner;

public class PIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTries = 0;
        String correctPin = "1234";

        while(noOfTries < 3) {
            System.out.print("Enter PIN: ");
           String pinEntry = scanner.next();

           if(pinEntry.equals(correctPin)) {
               System.out.println("Your PIN is correct");
               System.exit(0);
           }
           else {
               System.out.println("Your PIN is incorrect");
           }
           noOfTries++;
        }

        System.out.println("Your bank cars is blocked");
    }
}
