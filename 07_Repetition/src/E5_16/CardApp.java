package E5_16;

public class CardApp {
    public static void main(String[] args) {
        Card sixOfSpades = new Card("6S");
        Card kingOfHearts = new Card("KH");
        Card tooLong = new Card("6SH");
        Card wrongValue = new Card("XH");
        Card wrongSuit = new Card("QV");

        System.out.println(sixOfSpades.getDescription());
        System.out.println(kingOfHearts.getDescription());
        System.out.println(tooLong.getDescription());
        System.out.println(wrongValue.getDescription());
        System.out.println(wrongSuit.getDescription());
    }
}
