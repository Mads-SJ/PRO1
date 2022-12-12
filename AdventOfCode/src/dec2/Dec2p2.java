package dec2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dec2p2 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\AdventOfCode\\src\\dec2\\input.txt");
            Scanner scanner = new Scanner(file);

            int points = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] instructions = line.toCharArray();
                char o = instructions[0];
                char outcome = instructions[2];
                char r = 'M';

                switch(outcome) {
                    case 'Z':
                        if (o == 'A')
                            r = 'P';
                        else if (o == 'B')
                            r = 'S';
                        else
                            r = 'R';
                        break;
                    case 'Y':
                        if (o == 'A')
                            r = 'R';
                        else if (o == 'B')
                            r = 'P';
                        else
                            r = 'S';
                        break;
                    case 'X':
                        if (o == 'A')
                            r = 'S';
                        else if (o == 'B')
                            r = 'R';
                        else
                            r = 'P';
                        break;
                }

                switch (outcome) {
                    case 'Z' -> points += 6;
                    case 'Y' -> points += 3;
                }

                switch (r) {
                    case 'R' -> points += 1;
                    case 'P' -> points += 2;
                    case 'S' -> points += 3;
                }
            }

            System.out.println(points);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
