package modelarray;

import java.util.HashSet;
import java.util.Set;

public class ArrayMethods {
    public void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            } else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    public int sum(int[] t) {
        int sum = 0;

        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum;
    }

    public double sum(double[] t) {
        double sum = 0;

        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum;
    }

    public int[] makeSum(int[] a, int[] b) {
        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }

        return c;
    }

    public int[] makeSumOpg7(int[] a, int[] b) {
        int shortest = Math.min(a.length, b.length);
        int longest = Math.max(a.length, b.length);
        int[] c = new int[longest];

        for (int i = 0; i < longest; i++) {
            if (i < shortest) {
                c[i] = a[i] + b[i];
            } else {
                if (a.length == longest) {
                    c[i] = a[i];
                } else {
                    c[i] = b[i];
                }
            }
        }

        return c;
    }

    public int[] makeSumOpg7Optimized(int[] a, int[] b) {
        int longest = Math.max(a.length, b.length);
        int[] c = new int[longest];

        for (int i = 0; i < longest; i++) {
            if (i < a.length) {
                c[i] += a[i];
            }
            if (i < b.length) {
                c[i] += b[i];
            }
        }
        return c;
    }

    public boolean hasUneven(int[] t) {
        for (int n : t) {
            if (n % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public int[] switchFirstAndLast(int[] t) {
        if (t.length < 2) {
            return t;
        }

        int[] r = t.clone();
        int first = r[0];
        r[0] = r[r.length - 1];
        r[r.length - 1] = first;

        return r;
    }

    public int[] pushElements(int[] t) {
        int[] r = t.clone();
        int last = t[t.length - 1];
        for (int i = t.length - 1; i > 0; i--) {
            r[i] = r[i - 1];
        }
        r[0] = last;
        return r;
    }

    public int[] replaceEvenWithZero(int[] t) {
        int[] r = t.clone();

        for (int i = 0; i < r.length; i++) {
            int n = r[i];
            if (n % 2 == 0) {
                r[i] = 0;
            }
        }
        return r;
    }

    public int findSecondHighest(int[] t) {
        int highest = 0;
        int secondHighest = 0;

        for (int n : t) {
            if (n > highest) {
                secondHighest = highest;
                highest = n;
            } else if (n < highest && n > secondHighest) {
                secondHighest = n;
            }
        }
        return secondHighest;
    }

    public boolean isArrayIncreasing(int[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i] > t[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean hasDuplicates(int[] t) {
        Set<Integer> set = new HashSet<>();

        for (int n : t) {
            boolean isDuplicate = !set.add(n);
            if (isDuplicate) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }

    /**
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public int[] fyldArrayB() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public int[] fyldArrayC() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public int[] fyldArrayD() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public int[] fyldArrayE() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public int[] fyldArrayF() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public int[] fyldArrayG() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    public int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }
}
