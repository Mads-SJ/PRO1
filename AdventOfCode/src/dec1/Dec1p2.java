package dec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dec1p2 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\AdventOfCode\\src\\dec1\\input.txt");
            Scanner scanner = new Scanner(file);

            ArrayList<Integer> elfsCalories = new ArrayList<>();
            int elfCalories = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isBlank()) {
                   elfCalories += Integer.parseInt(line);
                } else {
                    elfsCalories.add(elfCalories);
                    elfCalories = 0;
                }
            }

            elfsCalories.sort(Collections.reverseOrder());
            System.out.println(elfsCalories.get(0) + elfsCalories.get(1) + elfsCalories.get(2));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
