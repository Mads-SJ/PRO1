package januar_2021.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String navn;
    private String klasse;
    private ArrayList<Lektion> lektioner;

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
        lektioner = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getKlasse() {
        return klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }

    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion);
        }
    }

    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
        ArrayList<Studerende> sygeStuderende = new ArrayList<>();
        for (Lektion l : lektioner) {
            if (l.getDato().isEqual(dato)) {
                for (Deltagelse d : l.getDeltagelser()) {
                    Studerende s = d.getStuderende();
                    if (d.getStatus() == DeltagerStatus.SYG && !sygeStuderende.contains(s)) {
                        sygeStuderende.add(s);
                    }
                }
            }
        }
        return sygeStuderende;
    }
}
