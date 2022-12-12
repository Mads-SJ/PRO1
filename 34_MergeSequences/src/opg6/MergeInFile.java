package opg6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeInFile {
    public static void main(String[] args) {
        String filePath1 = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg5\\input1.txt";
        String filePath2 = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg5\\input2.txt";
        try {
            fletAlleHeltal(filePath1, filePath2, "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg5\\mergedInputs");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal fra fileName1 og fileName2 (MAX_VALUE skal ikke i
     * resultatet)
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void fletAlleHeltal(String fileName1, String
            fileName2, String fileNameNy) throws IOException {
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        PrintWriter printWriter = new PrintWriter(fileNameNy);
        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);
        int n1 = sc1.nextInt();
        int n2 = sc2.nextInt();

        while (n1 != Integer.MAX_VALUE && n2 != Integer.MAX_VALUE) {
            if (n1 < n2) {
                printWriter.println(n1);
                n1 = sc1.nextInt();
            } else {
                printWriter.println(n2);
                n2 = sc2.nextInt();
            }
        }

        while (n1 != Integer.MAX_VALUE) {
            printWriter.println(n1);
            n1 = sc1.nextInt();
        }
        while (n2 != Integer.MAX_VALUE) {
            printWriter.println(n2);
            n2 = sc2.nextInt();
        }

        sc1.close();
        sc2.close();
        printWriter.close();
    }
}
