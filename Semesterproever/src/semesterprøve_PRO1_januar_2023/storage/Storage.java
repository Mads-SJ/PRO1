package semesterprøve_PRO1_januar_2023.storage;

import semesterprøve_PRO1_januar_2023.application.model.Salg;
import semesterprøve_PRO1_januar_2023.application.model.Sælger;
import semesterprøve_PRO1_januar_2023.application.model.Vare;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Sælger> sælgere = new ArrayList<>();
    private static ArrayList<Vare> varer = new ArrayList<>();
    private static ArrayList<Salg> salg = new ArrayList<>();

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }

    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<>(salg);
    }

    public static void addSælger(Sælger sælger) {
        sælgere.add(sælger);
    }
    public static void addVare(Vare vare) {
        varer.add(vare);
    }
    public static void addSalg(Salg salg) {
        Storage.salg.add(salg);
    }
}
