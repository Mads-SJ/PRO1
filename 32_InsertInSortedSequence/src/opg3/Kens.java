package opg3;

public class Kens {
    public static void main(String[] args) {
        String s = "Jubiiii";
        System.out.println(s + " har 3 ens: " + kens(s, 3));
        System.out.println(s + " har 4 ens: " + kens(s, 4));
        System.out.println(s + " har 5 ens: " + kens(s, 5));
    }

    public static boolean kens(String s, int k) {
        boolean found = false;
        int i = 0;
        while (!found && i <= s.length() - k) {
            if (match(s, i, k)) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    public static boolean match(String s, int i, int k) {
        boolean foundDiff = false;
        int j = 0;
        while (!foundDiff && j < k) {
            if (s.charAt(i + j) != s.charAt(i)) {
                foundDiff = true;
            } else {
                j++;
            }
        }

        return !foundDiff;
    }
}
