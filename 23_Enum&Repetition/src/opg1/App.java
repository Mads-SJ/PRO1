package opg1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Hund h1 = new Hund("Fiddo", true, 300, Race.BOKSER);
        Hund h2 = new Hund("Fiddo", true, 350, Race.TERRIER);
        Hund h3 = new Hund("Fiddo", true, 200, Race.PUDDEL);
        Hund h4 = new Hund("Fiddo", true, 250, Race.BOKSER);
        Hund h5 = new Hund("Fiddo", true, 1000, Race.PUDDEL);

        ArrayList<Hund> hunde = new ArrayList<>();
        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);

        System.out.println("Samlet pris for " + Race.PUDDEL + ": " + samletPris(hunde, Race.PUDDEL));
    }

    public static int samletPris(ArrayList<Hund> hunde, Race race) {
        int samletPris = 0;

        for (Hund h : hunde) {
            if (h.getRace() == race) {
                samletPris += h.getPris();
            }
        }

        return samletPris;
    }
}
