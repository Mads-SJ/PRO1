package januar_2018.controller;

import januar_2018.model.Arrangement;
import januar_2018.model.Hold;
import januar_2018.model.Tutor;
import januar_2018.model.Uddannelse;
import januar_2018.storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    public static ArrayList<Uddannelse> getUddannelser() {
        return Storage.getUddannelser();
    }

    public static ArrayList<Tutor> getTutorere() {
        return Storage.getTutorere();
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return Storage.getArrangementer();
    }
    public static Uddannelse createUddannelse(String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.addUddannelse(uddannelse);
        return uddannelse;
    }

    public static Hold createHoldForUddannelse(String betegnelse, String holdleder, Uddannelse uddannelse) {
        return uddannelse.createHold(betegnelse, holdleder);
    }

    public static Tutor createTutor(String navn, String email) {
        Tutor tutor = new Tutor(navn, email);
        Storage.addTutor(tutor);
        return tutor;
    }

    public static Arrangement createArrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
        Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void addTutorToHold(Tutor tutor, Hold hold) {
        hold.addTutor(tutor);
    }

    public static void addArrangementToTutor(Arrangement arrangement, Tutor tutor) {
        if (tutor.harTidsOverlap(arrangement)) {
            throw new RuntimeException("Overlappende arrangementer!");
        } else {
            tutor.addArrangement(arrangement);
        }
    }

    public static ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> holdUdenTutorer = new ArrayList<>();
        for (Uddannelse u : Storage.getUddannelser()) {
            for (Hold h : u.getHold()) {
                if (h.getTutorere().isEmpty()) {
                    holdUdenTutorer.add(h);
                }
            }
        }
        return holdUdenTutorer;
    }

    public static void initStorage() {
        Uddannelse u1 = Controller.createUddannelse("DMU");
        Uddannelse u2 = Controller.createUddannelse("FINØ");

        Hold h1 = Controller.createHoldForUddannelse("1dmE17S", "Margrethe Dybdal", u1);
        Hold h2 = Controller.createHoldForUddannelse("1dmE17T", "Kristian Dorland", u1);
        Hold h3 = Controller.createHoldForUddannelse("1dmE17U", "Kell Ørhøj", u1);
        Hold h4 = Controller.createHoldForUddannelse("1fiE17B", "Karen Jensen", u2);

        Tutor t1 = Controller.createTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor t2 = Controller.createTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor t3 = Controller.createTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor t4 = Controller.createTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor t5 = Controller.createTutor("Mads Miller", "mmm@students.eaaa.dk");

        Arrangement a1 = Controller.createArrangement("Rusfest",
                LocalDate.of(2017, 8, 31),
                LocalTime.of(18, 0),
                LocalTime.of(23, 30), 250);

        Arrangement a2 = Controller.createArrangement("Fodbold",
                LocalDate.of(2017, 8, 30),
                LocalTime.of(14, 0),
                LocalTime.of(17, 30), 100);

        Arrangement a3 = Controller.createArrangement("Brætspil",
                LocalDate.of(2017, 8, 29),
                LocalTime.of(12, 0),
                LocalTime.of(16, 30), 25);

        Arrangement a4 = Controller.createArrangement("Mindeparken",
                LocalDate.of(2017, 8, 30),
                LocalTime.of(18, 0),
                LocalTime.of(22, 0), 25);

        Controller.addTutorToHold(t1, h1);
        Controller.addTutorToHold(t4, h1);
        Controller.addTutorToHold(t2, h3);
        Controller.addTutorToHold(t3, h3);
        Controller.addTutorToHold(t5, h4);

        Controller.addArrangementToTutor(a1, t1);
        Controller.addArrangementToTutor(a1, t2);
        Controller.addArrangementToTutor(a1, t5);

        Controller.addArrangementToTutor(a2, t3);

        Controller.addArrangementToTutor(a3, t3);
        Controller.addArrangementToTutor(a3, t4);

        Controller.addArrangementToTutor(a4, t1);
        Controller.addArrangementToTutor(a4, t5);
    }
}
