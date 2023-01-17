package januar_2018.model;

import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;
    private ArrayList<Arrangement> arrangementer;
    private Hold hold;

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
        arrangementer = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public void addArrangement(Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

    public void removeArrangement(Arrangement arrangement) {
        if (arrangementer.contains(arrangement)) {
            arrangementer.remove(arrangement);
        }
    }

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        if (this.hold != hold) {
            Hold oldHold = this.hold;
            if (oldHold != null) {
                oldHold.removeTutor(this);
            }
            this.hold = hold;
            if (hold != null) {
                hold.addTutor(this);
            }
        }
    }

    public double arrangementsPris() {
        double totalPris = 0;
        for (Arrangement a : arrangementer) {
            totalPris += a.getPris();
        }
        return totalPris;
    }

    public boolean harTidsOverlap(Arrangement arrangement) {
        boolean harTidsOverlap = false;
        int i = 0;
        while (!harTidsOverlap && i < arrangementer.size()) {
            Arrangement andetArrangement = arrangementer.get(i);
            if (overlapperArrangementer(arrangement, andetArrangement)) {
               harTidsOverlap = true;
            }
            i++;
        }
        return harTidsOverlap;
    }

    private boolean overlapperArrangementer(Arrangement a1, Arrangement a2) {
       return a1.getDate().isEqual(a2.getDate())
               && a2.getStartTid().isBefore(a1.getSlutTid())
               && a1.getStartTid().isBefore(a2.getSlutTid());
    }
}