package modelarray;

import java.util.Arrays;

public class ArrayApp {

    public static void main(String[] args) {
        ArrayMethods metode = new ArrayMethods();

        int[] tabel = metode.fyldArrayA();
        System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayB();
        System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayC();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayD();
        System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayE();
        System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayF();
        System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayG();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        // int[] tabel2 = { 78, 23, 1, 4, 65, 3, 87, 5, 12 };
        // metode.printArray(tabel2);
        //
        // System.out.println(metode.findMax(tabel2));

        // OPG 2
        int[] t = {4, 6, 7, 2, 3};
        System.out.println("summen af t er " + metode.sum(t));

        // OPG 3
        System.out.println("sum arrayet af t og t er ");
        int[] tSum = metode.makeSum(t, t);
        metode.printArray(tSum);

        // OPG 6
        int[] tEven = {4, 6, 8, 2, 6};
        System.out.println("Expected: true, got: " + metode.hasUneven(t));
        System.out.println("Expected: false, got: " + metode.hasUneven(tEven));

        // OPG 7
        int[] tShort = {1, 2};

        System.out.println("Test at det stadig virker som før med t og t");
        tSum = metode.makeSumOpg7(t, t);
        metode.printArray(tSum);

        System.out.println("sum arrayet af t og tShort er ");
        tSum = metode.makeSumOpg7(t, tShort);
        metode.printArray(tSum);

        System.out.println("Optimized test af t og tShort er");
        tSum = metode.makeSumOpg7Optimized(t, tShort);
        metode.printArray(tSum);

        // LEKTION 13 OPG 4
        t = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("array t:");
        metode.printArray(t);

        // 1
        System.out.println();
        int[] tSwitched = metode.switchFirstAndLast(t);
        metode.printArray(tSwitched);

        // 2
        System.out.println();
        int[] tPushed = metode.pushElements(t);
        metode.printArray(tPushed);

        // 3
        System.out.println();
        int[] tReplaced = metode.replaceEvenWithZero(t);
        metode.printArray(tReplaced);

        // 4
        System.out.println();
        System.out.println(metode.findSecondHighest(t));
        int[] t2 = {1, 2, 3, 4, 6, 5};
        System.out.println(metode.findSecondHighest(t2));
    }
}
