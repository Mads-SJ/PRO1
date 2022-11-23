package semesterprøve_opg2.application.controller;

import semesterprøve_opg2.application.model.Arrangement;
import semesterprøve_opg2.application.model.Område;
import semesterprøve_opg2.application.model.Plads;
import semesterprøve_opg2.application.model.Reservation;
import semesterprøve_opg2.storage.Storage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {
    public static Arrangement createArrangement(String navn, boolean offentlig) {
        Arrangement arrangement = new Arrangement(navn, offentlig);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void addReservationToArrangement(Reservation reservation, Arrangement arrangement) {
        arrangement.addReservation(reservation);
    }

    public static Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
        Reservation reservation = new Reservation(start, slut);
        Storage.addReservation(reservation);
        return reservation;
    }

    public static void addPladsToReservation(Plads plads, Reservation reservation) {
        reservation.addPladser(plads);
    }

    public static Plads createPlads(int nr, Område område) {
        Plads plads = new Plads(nr, område);
        Storage.addPlads(plads);
        return plads;
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

    public static void initStorage() {
        Plads p1 = Controller.createPlads(1, Område.TURNERING);
        Plads p2 = Controller.createPlads(2, Område.TURNERING);
        Plads p3 = Controller.createPlads(3, Område.STANDARD);
        Plads p4 = Controller.createPlads(4, Område.STANDARD);
        Plads p5 = Controller.createPlads(5, Område.BØRNE);
        Plads p6 = Controller.createPlads(6, Område.VIP);

        Arrangement a1 = Controller.createArrangement("Dota 2 tournament", true);
        Arrangement a2 = Controller.createArrangement("CS GO tournament", false);

        Reservation r1 = Controller.createReservation(
                LocalDateTime.of(2019,8,12,20, 0),
                LocalDateTime.of(2019, 8, 12, 23, 0)
        );

        Reservation r2 = Controller.createReservation(
                LocalDateTime.of(2019,8,13,19, 0),
                LocalDateTime.of(2019, 8, 14, 6, 0)
        );

        Reservation r3 = Controller.createReservation(
                LocalDateTime.of(2019,8,13,19, 0),
                LocalDateTime.of(2019, 8, 14, 6, 0)
        );

        Controller.addPladsToReservation(p1, r1);
        Controller.addPladsToReservation(p2, r1);
        Controller.addPladsToReservation(p3, r2);
        Controller.addPladsToReservation(p4, r2);
        Controller.addPladsToReservation(p6, r3);

        Controller.addReservationToArrangement(r1,a1);
    }
}
