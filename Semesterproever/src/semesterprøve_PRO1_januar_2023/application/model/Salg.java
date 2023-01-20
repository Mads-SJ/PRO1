package semesterprøve_PRO1_januar_2023.application.model;

import java.util.ArrayList;

public class Salg implements Comparable<Salg> {
    private String køberNavn;
    private int aftaltSamletPris;
    private ArrayList<Vare> varer;

    public Salg(String køberNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        this.køberNavn = køberNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.varer = varer;

        for (Vare v : varer) {
            v.setSolgt(true);
            Salgsannonce salgsannonce = v.getSalgsannonce();
            if (salgsannonce != null) {
                salgsannonce.opdaterAnnonce();;
            }
        }
    }

    public String getKøberNavn() {
        return køberNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    private int rabat() {
        int samletUdbudpris = 0;
        for (Vare v : varer) {
            samletUdbudpris += v.getUdbudspris();
        }
        return samletUdbudpris - aftaltSamletPris;
    }

    public String oversigt() {
        StringBuilder sb = new StringBuilder();
        sb.append(køberNavn + ":\n");
        for (Vare v : varer) {
            sb.append(v.getNavn() + " " + v.getUdbudspris() + "\n");
        }
        sb.append("Aftalt pris: " + aftaltSamletPris + "    rabat er: " + rabat());
        return sb.toString();
    }

    @Override
    public int compareTo(Salg other) {
        return køberNavn.compareTo(other.køberNavn);
    }
}
