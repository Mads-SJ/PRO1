package opg4;

import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        String fileName = "textfiles\\uligetal100";

        try(PrintWriter printWriter = new PrintWriter(fileName)) {

            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0) {
                    printWriter.println(i);
                }
            }
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
