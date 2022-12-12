package opg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\input.txt";
        File file = new File(filePath);
        ArrayList<Integer> numbers = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                int n = Integer.parseInt(scanner.nextLine());
                numbers.add(n);
                System.out.println(n * 2);
            }

            System.out.println();
            for (int i = numbers.size() - 1; i > 0; i--) {
                System.out.println(numbers.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
