package dec2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dec2p1 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\AdventOfCode\\src\\dec2\\input.txt");
            Scanner scanner = new Scanner(file);

            int points = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] instructions = line.toCharArray();
                char o = instructions[0];
                char r = instructions[2];

                if (o == 'A' && r == 'Y' || o == 'B' && r == 'Z' || o == 'C' && r == 'X') {
                    points += 6;
                } else if (o == 'A' && r == 'X' || o == 'B' && r == 'Y' || o == 'C' && r == 'Z') {
                    points += 3;
                }

                switch (r) {
                    case 'X' -> points += 1;
                    case 'Y' -> points += 2;
                    case 'Z' -> points += 3;
                }
            }

            System.out.println(points);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
