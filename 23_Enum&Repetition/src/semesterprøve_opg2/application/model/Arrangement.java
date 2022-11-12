package semesterprøve_opg2.application.model;

import java.util.ArrayList;

public class Arrangement {
    private String navn;
    private boolean offentlig;
    private ArrayList<Reservation> reservationer;

    public Arrangement(String navn, boolean offentlig) {
        this.navn = navn;
        this.offentlig = offentlig;
        reservationer = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
        }
    }

    public int antalReserveredePladser() {
        int antal = 0;

        for (Reservation r : reservationer) {
            antal += r.getPladser().size();
        }

        return antal;
    }
}
