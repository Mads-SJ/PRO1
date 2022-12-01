package opg5;

public class App {
    public static void main(String[] args) {
        Indkøbsvogn indkøbsvogn = new Indkøbsvogn();

        Vare v1 = new ElArtikel(1, "V", "hej", 10.0);
        Vare v2 = new Fødevare(1, "V", "hej", 3);
        Vare v3 = new Spiritus(1, "V", "hej", 100);

        indkøbsvogn.addVare(v1);
        indkøbsvogn.addVare(v2);
        indkøbsvogn.addVare(v3);

        indkøbsvogn.printBon();
    }
}
