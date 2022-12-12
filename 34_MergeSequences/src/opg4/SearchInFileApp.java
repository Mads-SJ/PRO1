package opg4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchInFileApp {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg4\\talfil.txt";
        System.out.println(linFileSearch(filePath, 1));
    }

    public static boolean linFileSearch(String filePath, int target) {
        File file = new File(filePath);
        boolean found = false;

        try(Scanner scanner = new Scanner(file)) {
            while (!found && scanner.hasNextLine()) {
                int n = Integer.parseInt(scanner.nextLine());
                if (n == target) {
                    found = true;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return found;
    }
}
