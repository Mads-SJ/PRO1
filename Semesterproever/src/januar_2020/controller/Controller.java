package januar_2020.controller;

import januar_2020.model.*;
import januar_2020.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato) {
        Festival festival = new Festival(navn, fraDato, tilDato);
        Storage.addFestival(festival);
        return festival;
    }

    public static Frivillig createFrivillig(String navn, String mobil, int maksAntalTimer) {
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
        Storage.addFrivillig(frivillig);
        return frivillig;
    }

    public static FrivilligForening createFrivilligForening(String navn, String mobil, int maksAntalTimer,
                                                            String foreningNavn, int antalPersoner) {
        FrivilligForening frivilligForening = new FrivilligForening(navn, mobil, maksAntalTimer,
                foreningNavn, antalPersoner);
        Storage.addFrivillig(frivilligForening);
        return frivilligForening;
    }

    public static Job createJobForFestival(String kode, String beskrivelse, LocalDate dato,
                                           int timeHonrar, int antalTimer, Festival festival) {
        return festival.createJob(kode, beskrivelse, dato, timeHonrar, antalTimer);
    }

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) {
        if (frivillig.ledigeTimer() < timer) {
            throw new RuntimeException("Den frivillige har ledige " + frivillig.ledigeTimer() + " timer.");
        } else if (job.ikkeBesatteTimer() < timer) {
            throw new RuntimeException("Jobbet har " + job.ikkeBesatteTimer() + " ledige timer.");
        }

        return job.createVagt(timer, frivillig);
    }

    public static boolean findFrivillig(Festival festival, String navn) {
        ArrayList<String> gaveliste = festival.gaverTilFrivillige();
        boolean found = false;
        int left = 0;
        int right = gaveliste.size() - 1;
        while (!found && left <= right) {
            int middle = (left + right) / 2;
            String s = gaveliste.get(middle).split(" ")[0];
            int comp = s.compareTo(navn);
            if (comp == 0) {
                found = true;
            } else if (comp > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return found;
    }

    public static ArrayList<Festival> getFestivaller() {
        return Storage.getFestivaller();
    }

    public static ArrayList<Frivillig> getFrivillige() {
        return Storage.getFrivillige();
    }

    public static void initStorage() {
        Festival festival = Controller.createFestival("Northside",
                LocalDate.of(2020,6,4),
                LocalDate.of(2020,6,6));

        Frivillig frivillig1 = Controller.createFrivillig("Jane Jensen", "12345677", 20);
        Frivillig frivillig2 = Controller.createFrivillig("Lone Hansen", "78787878", 25);
        Frivillig frivillig3 = Controller.createFrivillig("Anders Mikkelsen", "55555555", 10);

        FrivilligForening frivilligForening = Controller.createFrivilligForening(
                "Christian Madsen",
                "23232323",
                100,
                "Erhvervsakademi Aarhus",
                40
        );

        for (int i = 1; i <= 9; i++) {
            String beskrivelse = "Rengøring af toilet";
            int timeHonorar = 100;
            int antalTimer = 5;
            if (i > 6) {
                Controller.createJobForFestival("T" + i, beskrivelse, LocalDate.of(2020, 6, 6),
                        timeHonorar, antalTimer, festival);
            } else if (i > 3) {
                Controller.createJobForFestival("T" + i, beskrivelse, LocalDate.of(2020, 6, 5),
                        timeHonorar, antalTimer, festival);
            } else {
                Controller.createJobForFestival("T" + i, beskrivelse, LocalDate.of(2020, 6, 4),
                        timeHonorar, antalTimer, festival);
            }
        }
    }
}
