package opg5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String fileName = "textfiles\\inputTal";

        try(
                Scanner scanner = new Scanner(System.in);
                PrintWriter printWriter = new PrintWriter(fileName)
        ) {
            int n = scanner.nextInt();
            while (n > -1) {
                printWriter.println(n);
                n = scanner.nextInt();
            }
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
