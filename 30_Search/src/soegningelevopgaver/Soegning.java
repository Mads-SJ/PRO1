package soegningelevopgaver;

import java.util.ArrayList;
import java.util.Collections;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        boolean uneven = false;
        int i = 0;

        while (i < tabel.length && !uneven) {
            if (tabel[i] % 2 != 0) {
                uneven = true;
            }
            i++;
        }
        return uneven;
    }

    public int findFirstInInterval(int[] tabel) {
        int number = -1;
        int i = 0;

        while (i < tabel.length && number == -1) {
            int k = tabel[i];
            if (10 <= k && k <= 15) {
                number = k;
            }
            i++;
        }

        return number;
    }

    public boolean isTwoSameNumbersNextToEachOther(int[] tabel) {
        boolean isTwoSameNumbersNextToEachOther = false;
        int i = 1;
        while (i < tabel.length && !isTwoSameNumbersNextToEachOther) {
            int k = tabel[i];
            if (tabel[i - 1] == k) {
                isTwoSameNumbersNextToEachOther = true;
            }
            i++;
        }
        return isTwoSameNumbersNextToEachOther;
    }

    public int findIntSqrtLinear(int n) {
        int r = 0;
        while(r * r > n || n >= (r + 1) * (r + 1)) {
            r++;
        }
        return r;
    }

    public int findIntSqrtBinary(int n) {
        int r = -1;
        int left = 0;
        int right = n;
        while (r == -1 && left <= right) {
            int m = (left + right) / 2;
            if (m * m <= n && n < (m + 1) * (m + 1)) {
                r = m;
            } else if (m * m > n) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return r;
    }

    public int find(ArrayList<Integer> list, int n) {
        int index = -1;
        int i = 0;
        while(index == -1 && i < list.size()) {
            int k = list.get(i);
            if (k == n && i > 0) {
                index = i - 1;
                Collections.swap(list, index, index + 1);
            }
            i++;
        }

        return index;
    }
}
