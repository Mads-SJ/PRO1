package dec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dec1p1 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\AdventOfCode\\src\\dec1\\input.txt");
            Scanner scanner = new Scanner(file);

            int highestCalories = 0;
            int elfCalories = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isBlank()) {
                   elfCalories += Integer.parseInt(line);
                } else {
                    if (elfCalories > highestCalories) {
                        highestCalories = elfCalories;
                    }
                    elfCalories = 0;
                }
            }

            System.out.println(highestCalories);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
