package O_1;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0) {
                System.out.println(i);
            }
        }

        for (int i = 300; i > 0; i--) {
            if(i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
