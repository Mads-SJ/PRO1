package januar_2021.controller;

import januar_2021.model.Deltagelse;
import januar_2021.model.Fag;
import januar_2021.model.Lektion;
import januar_2021.model.Studerende;
import januar_2021.storage.Storage;
import januar_2022.model.Tilmelding;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    public static Studerende createStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.addStuderende(studerende);
        return studerende;
    }

    public static Fag createFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.addFag(fag);
        return fag;
    }

    public static Lektion createLektionForFag(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        Lektion lektion = new Lektion(dato, startTid, lokale, fag);
        return lektion;
    }

    public static Deltagelse createDeltagelseForLektion(Lektion lektion, Studerende studerende) {
        return lektion.createDeltagelse(studerende);
    }

    public static void opretDeltagelser(Fag fag, Studerende studerende) {
        for (Lektion l : fag.getLektioner()) {
            Controller.createDeltagelseForLektion(l, studerende);
        }
    }

    public static ArrayList<Studerende> studerendeTilObservation(int grænse) {
        ArrayList<Studerende> tilObservation = new ArrayList<>();
        for (Studerende s : Storage.getStuderende()) {
            if (s.antalFraværsLektioner() > grænse) {
                tilObservation.add(s);
            }
        }
        Collections.sort(tilObservation);
        return tilObservation;
    }

    public static void fraværOmgængere(String[] omgængere, ArrayList<Studerende> megetFravær, String filnavn) {
        try(PrintWriter printWriter = new PrintWriter(filnavn)) {
            for (int i = 0; i < omgængere.length; i++) {
                String navn = omgængere[i];
                for (Studerende s : megetFravær) {
                    if (navn.equals(s.getNavn())) {
                        printWriter.println(navn + " " + s.antalFraværsLektioner());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initStorage() {
        Studerende s1 = Controller.createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende s2 = Controller.createStuderende("Tina Jensen", "tj@stud.dk");
        Studerende s3 = Controller.createStuderende("Sascha Petersen", "sp@stud.dk");

        Fag f1 = Controller.createFag("PRO1", "20S");
        Fag f2 = Controller.createFag("PRO1", "20T");
        Fag f3 = Controller.createFag("SU1", "20S");

        Controller.createLektionForFag(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30), "A1.32", f1);
        Controller.createLektionForFag(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30), "A1.32", f1);
        Controller.createLektionForFag(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30), "A1.32", f1);
        Controller.createLektionForFag(LocalDate.of(2021, 2, 3), LocalTime.of(10, 30), "A1.32", f1);

        Controller.opretDeltagelser(f1, s1);
        Controller.opretDeltagelser(f1, s2);
        Controller.opretDeltagelser(f1, s3);
    }
}
