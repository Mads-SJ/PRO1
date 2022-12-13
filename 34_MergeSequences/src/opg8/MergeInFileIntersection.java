package opg8;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeInFileIntersection {
    public static void main(String[] args) {
        String filePath1 = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg6\\input1.txt";
        String filePath2 = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg6\\input2.txt";
        String filePathNew = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\34_MergeSequences\\src\\opg8\\mergedInputs";
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
        boolean done = false;
        int n1 = 0;
        int n2 = 0;
        if (sc1.hasNextInt() && sc2.hasNextInt()) {
            n1 = sc1.nextInt();
            n2 = sc2.nextInt();
        } else {
            done = true;
        }

        while (!done) {
            if (n1 < n2) {
                if (sc1.hasNextInt()) {
                    n1 = sc1.nextInt();
                } else {
                    done = true;
                }
            } else if (n1 > n2) {
                if (sc2.hasNextInt()) {
                    n2 = sc2.nextInt();
                } else {
                    done = true;
                }
            }else {
                printWriter.println(n1);
                if (sc1.hasNextInt() && sc2.hasNextInt()) {
                    n1 = sc1.nextInt();
                    n2 = sc2.nextInt();
                } else {
                    done = true;
                }
            }
        }

        sc1.close();
        sc2.close();
        printWriter.close();
    }
}
