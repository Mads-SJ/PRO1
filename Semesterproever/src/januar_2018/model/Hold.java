package januar_2018.model;

import java.util.ArrayList;

public class Hold {
    private String betegnelse;
    private String holdleder;
    private ArrayList<Tutor> tutorere;
    private Uddannelse uddannelse;

    public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
        tutorere = new ArrayList<>();
        this.uddannelse = uddannelse;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public ArrayList<Tutor> getTutorere() {
        return new ArrayList<>(tutorere);
    }

    public void addTutor(Tutor tutor) {
        if (!tutorere.contains(tutor)) {
            tutorere.add(tutor);
            tutor.setHold(this);
        }
    }

    public void removeTutor(Tutor tutor) {
        if (tutorere.contains(tutor)) {
            tutorere.remove(tutor);
            tutor.setHold(null);
        }
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    public double arrangementsPris() {
        double totalPris = 0;
        for (Tutor t : tutorere) {
            totalPris += t.arrangementsPris();
        }
        return totalPris;
    }

    public boolean harTidsOverlap(Arrangement arrangement) {
        boolean harTidsOverlap = false;
        int i = 0;
        while (!harTidsOverlap && i < tutorere.size()) {
            Tutor t = tutorere.get(i);
            if (t.harTidsOverlap(arrangement)) {
                harTidsOverlap = true;
            }
            i++;
        }
        return harTidsOverlap;
    }
}
