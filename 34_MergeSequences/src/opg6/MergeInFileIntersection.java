package opg6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeInFileIntersection {
    public static void main(String[] args) {
        String filePath1 = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg6\\input1.txt";
        String filePath2 = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg6\\input2.txt";
        String filePathNew = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg6\\mergedInputs";
        try {
            findFællesHeltal(filePath1, filePath2, filePathNew);
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
    public static void findFællesHeltal(String fileName1, String
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
                n1 = sc1.nextInt();
            } else if (n1 > n2) {
                n2 = sc2.nextInt();
            }else {
                printWriter.println(n1);
                n1 = sc1.nextInt();
                n2 = sc2.nextInt();
            }
        }

        sc1.close();
        sc2.close();
        printWriter.close();
    }
}
