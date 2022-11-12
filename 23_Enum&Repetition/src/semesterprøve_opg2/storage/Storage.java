package semesterprøve_opg2.storage;

import semesterprøve_opg2.application.model.Arrangement;
import semesterprøve_opg2.application.model.Plads;
import semesterprøve_opg2.application.model.Reservation;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static final ArrayList<Reservation> reservationer = new ArrayList<>();
    private static final ArrayList<Plads> pladser = new ArrayList<>();

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public static ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public static void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public static void addPlads(Plads plads) {
        pladser.add(plads);
    }
}
