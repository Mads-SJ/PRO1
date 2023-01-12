package januar_2021.storage;

import januar_2021.model.Fag;
import januar_2021.model.Studerende;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Fag> fag = new ArrayList<>();
    private static ArrayList<Studerende> studerende = new ArrayList<>();

    public static ArrayList<Fag> getFag() {
        return new ArrayList<>(fag);
    }

    public static ArrayList<Studerende> getStuderende() {
        return new ArrayList<>(studerende);
    }

    public static void addFag(Fag fag) {
        Storage.fag.add(fag);
    }

    public static void addStuderende(Studerende studerende) {
        Storage.studerende.add(studerende);
    }
}
