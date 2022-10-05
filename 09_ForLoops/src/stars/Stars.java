package stars;

public class Stars {
    final int MAX_ROWS = 10;

    public void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureA() {
        for (int row = MAX_ROWS; row >= 1; row--) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureB() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= MAX_ROWS; star++) {
                if(star > MAX_ROWS - row) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureC() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= MAX_ROWS; star++) {
                if(star > row) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureD() {
        int divider = 1;
        for (int row = 5; row < MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                if (star > 5 - divider) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            divider++;
            System.out.println();
        }
        for (int row = MAX_ROWS - 1; row >= 5; row--) {
            divider--;
            for (int star = 1; star <= row; star++) {
                if (star > 5 - divider) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
