package semesterprøve_opg2.application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDateTime start;
    private LocalDateTime slut;
    private ArrayList<Plads> pladser;

    public Reservation(LocalDateTime start, LocalDateTime slut) {
        this.start = start;
        this.slut = slut;
        pladser = new ArrayList<>();
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getSlut() {
        return slut;
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPladser(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
            plads.addReservation(this);
        }
    }

    public void removePladser(Plads plads) {
        if (pladser.contains(plads)) {
            pladser.add(plads);
            plads.removeReservation(this);
        }
    }
}
