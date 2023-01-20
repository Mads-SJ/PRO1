package semesterprøve_PRO1_januar_2023.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnoncer = 0;
    private int annonceNummer;
    private boolean aktiv;
    private LocalDate udløbsdato;
    private Sælger sælger;
    private ArrayList<Vare> varer;

    public Salgsannonce(Sælger sælger) {
        antalAnnoncer++;
        annonceNummer = antalAnnoncer;
        aktiv = true;
        udløbsdato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
        sælger.addSalgsAnnonce(this);
        varer = new ArrayList<>();
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsdato() {
        return udløbsdato;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public Sælger getSælger() {
        return sælger;
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public void addVare(Vare vare) {
        if (!varer.contains(vare)) {
            varer.add(vare);
            vare.setSalgsannonce(this);
        }
    }

    public void removeVare(Vare vare) {
        if (varer.contains(vare)) {
            varer.remove(vare);
            vare.setSalgsannonce(null);
        }
    }

    public int samletAnnonceUdbud() {
        int samletAnnonceUdbud = 0;
        for (Vare v : varer) {
            samletAnnonceUdbud += v.getUdbudspris();
        }
        return samletAnnonceUdbud;
    }

    private boolean erAlleVarerSolgt() {
        boolean alleVarerSolgt = true;
        int i = 0;
        while (alleVarerSolgt && i < varer.size()) {
            Vare v = varer.get(i);
            if (!v.isSolgt()) {
                alleVarerSolgt = false;
            } else {
                i++;
            }
        }
        return alleVarerSolgt;
    }

    public void opdaterAnnonce() {
        if (LocalDate.now().isAfter(udløbsdato) || erAlleVarerSolgt()) {
            aktiv = false;
        }
    }

    @Override
    public String toString() {
        return annonceNummer + " " + sælger.getNavn() + " " + udløbsdato;
    }
}
