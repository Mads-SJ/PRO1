package opg5;

import java.util.ArrayList;

public class Indkøbsvogn {
    private ArrayList<Vare> varer;

    public Indkøbsvogn() {
        varer = new ArrayList<>();
    }

    public void addVare(Vare vare) {
        varer.add(vare);
    }

    public void printBon() {
        for (Vare v : varer) {
            System.out.println(v);
        }
    }
}
