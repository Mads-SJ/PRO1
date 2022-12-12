package opg2;

public class GenerelMergeIntersectionApp {
    public static void main(String[] args) {
        int[] l1 = {2, 4, 6, 8, 10, 12, 14};
        int[] l2 = {1, 2, 4, 5, 6, 9, 12, 17};

        int[] intersection = fællesTal(l1, l2);

        for (int n : intersection) {
            System.out.println(n);
        }
    }

    /**
     * Returnerer et sorteret array der indeholder alle
     * elementer l1 og l2 har til fælles
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static int[] fællesTal(int[] l1, int[] l2) {
        int[] result = new int[l1.length];
        int size = 0;
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            } else if (l1[i1] > l2[i2]) {
                i2++;
            } else {
                result[size] = l1[i1];
                i1++;
                i2++;
                size++;
            }
        }
        return result;
    }
}
