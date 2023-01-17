package januar_2018.storage;

import januar_2018.model.Arrangement;
import januar_2018.model.Tutor;
import januar_2018.model.Uddannelse;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static ArrayList<Tutor> tutorere = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public static ArrayList<Uddannelse> getUddannelser() {
        return new ArrayList<>(uddannelser);
    }

    public static ArrayList<Tutor> getTutorere() {
        return new ArrayList<>(tutorere);
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static void addUddannelse(Uddannelse uddannelse) {
        uddannelser.add(uddannelse);
    }

    public static void addTutor(Tutor tutor) {
        tutorere.add(tutor);
    }

    public static void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }
}
