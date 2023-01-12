package januar_2022.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Løb {
    private LocalDate dato;
    private String sted;
    private int normalPris;
    private LocalDate earlyBirdDate;
    private int earlyBirdPris;
    private ArrayList<Tilmelding> tilmeldinger;
    private ArrayList<Forhindring> forhindringer;

    public Løb(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris) {
        this.dato = dato;
        this.sted = sted;
        this.normalPris = normalPris;
        this.earlyBirdDate = earlyBirdDate;
        this.earlyBirdPris = earlyBirdPris;
        tilmeldinger = new ArrayList<>();
        forhindringer = new ArrayList<>();
    }

    public LocalDate getDato() {
        return dato;
    }

    public String getSted() {
        return sted;
    }

    public int getNormalPris() {
        return normalPris;
    }

    public LocalDate getEarlyBirdDate() {
        return earlyBirdDate;
    }

    public int getEarlyBirdPris() {
        return earlyBirdPris;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Tilmelding createTilmelding(String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer) {
        Tilmelding tilmelding = new Tilmelding(navn, kvinde, tilmeldingsdato, løbeNummer, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public ArrayList<Forhindring> getForhindringer() {
        return new ArrayList<>(forhindringer);
    }

    public void addForhindring(Forhindring forhindring) {
        if (!forhindringer.contains(forhindring)) {
            forhindringer.add(forhindring);
            forhindring.addLøb(this);
        }
    }

    public void removeForhindring(Forhindring forhindring) {
        if (forhindringer.contains(forhindring)) {
            forhindringer.remove(forhindring);
            forhindring.removeLøb(this);
        }
    }

    public int earlyBirdIndtjening() {
        int indtjening = 0;
        for (Tilmelding t : tilmeldinger) {
            if (!t.getTilmeldingsdato().isAfter(earlyBirdDate)) {
                indtjening += earlyBirdPris;
            }
        }
        return indtjening;
    }

    public double gennemsnitStrafSekunder(Forhindring forhindring) {
        int total = 0;
        double avg = 0.0;
        int antalNoter = 0;
        for (Tilmelding t : tilmeldinger) {
            for (Note n : t.getNoter()) {
                if (n.getForhindring().equals(forhindring)) {
                    total += n.getStrafSekunder();
                    antalNoter++;
                }
            }
        }
        if (total > 0) {
            avg = (double) total / antalNoter;
        }
        return avg;
    }

    public String findVinder() {
        int hurtigsteTid = Integer.MAX_VALUE;
        String vinder = "";
        for (Tilmelding t : tilmeldinger) {
            int resultat = t.resultatTid();
            if (resultat < hurtigsteTid) {
                hurtigsteTid = resultat;
                vinder = "" + t;
            }
        }
        return vinder;
    }

    public String findDeltagerVedNavn(String navn) {
        String res = "Deltageren findes ikke";
        int i = 0;
        while (res.equals("Deltageren findes ikke") && i < tilmeldinger.size()) {
            Tilmelding t = tilmeldinger.get(i);
            if (navn.equals(t.getNavn())) {
                res = t + ", antal straf: " + t.getNoter().size();
            }
        }
        return res;
    }
}
