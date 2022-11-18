package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {

    private String navn;
    private double pris;
    private LocalDateTime dato;
    private boolean inklFrokost;
    private ArrayList<Ledsager> ledsagere;


    public Udflugt (String navn, double pris, LocalDateTime dato, boolean inklFrokost) {
        this.navn = navn;
        this.pris = pris;
        this.dato = dato;
        this.inklFrokost = inklFrokost;
        ledsagere = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public LocalDateTime getDato() {
        return dato;
    }

    public boolean isInklFrokost() {
        return inklFrokost;
    }

    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
            ledsager.addUdflugt(this);
        }
    }

    public String toString() {
        return navn + " " + "(" + pris + " kr. - Afgang:  " + dato + " - Inkl. Frokost: " + (inklFrokost ? "Ja" : "Nej") + " " + ")";
    }
}
