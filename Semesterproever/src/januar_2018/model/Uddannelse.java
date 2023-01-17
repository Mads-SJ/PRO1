package januar_2018.model;

import java.util.ArrayList;

public class Uddannelse {
    private String navn;
    private ArrayList<Hold> hold;

    public Uddannelse(String navn) {
        this.navn = navn;
        hold = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Hold> getHold() {
        return new ArrayList<>(hold);
    }

    public Hold createHold(String betegnelse, String holdleder) {
        Hold hold = new Hold(betegnelse, holdleder, this);
        this.hold.add(hold);
        return hold;
    }

    public ArrayList<String> tutorOversigt() {
        ArrayList<String> tutorOversigt = new ArrayList<>();
        for (Hold h : hold) {
            for (Tutor t : h.getTutorere()) {
                String s = t.getNavn() + " " + navn + " " + h.getBetegnelse() + " " + t.getEmail() + " " + h.getHoldleder();
                tutorOversigt.add(s);
            }
        }
        return tutorOversigt;
    }
}
