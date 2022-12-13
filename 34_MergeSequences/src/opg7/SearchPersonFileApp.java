package opg7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchPersonFileApp {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg7\\persons.txt";

        try {
            System.out.println("Person with last name 'Madsen': " + linFileSearchPerson(filePath, "Madsen"));
            System.out.println("Person with last name 'Hansen': " + linFileSearchPerson(filePath, "Hansen"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String linFileSearchPerson(String fileName, String
            target) throws FileNotFoundException {
        String name = "";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (name.isBlank() && scanner.hasNextLine()) {
            scanner.next();
            String firstName = scanner.next();
            String lastName = scanner.next();
            if (lastName.equals(target)) {
                name = firstName + " " + lastName;
            }
        }
        return name;
    }
}
