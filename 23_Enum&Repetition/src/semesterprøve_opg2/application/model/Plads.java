package semesterprøve_opg2.application.model;

import java.util.ArrayList;

public class Plads {
    private int nr;
    private Område område;
    private ArrayList<Reservation> reservationer;
    private static double standardTimePris = 50;

    public Plads(int nr, Område område) {
        this.nr = nr;
        this.område = område;
        reservationer = new ArrayList<>();
    }

    public int getNr() {
        return nr;
    }

    public Område getOmråde() {
        return område;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
            reservation.addPladser(this);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.removePladser(this);
        }
    }

    public static double getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(double standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }

    public double pris(int timer) {
        double pris = standardTimePris;

        switch (område) {
            case VIP: pris *= 1.25;
            case BØRNE: pris *= 0.8;
            case TURNERING: pris *= 1.1;
        }

        return pris;
    }

    public String toString() {
        return "Plads " + nr + ", " + område;
    }
}
