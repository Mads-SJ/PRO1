package parkeringshus_test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Parkeringsplads {
    private int nummer;
    private LocalTime ankomst;
    private Parkeringshus parkeringshus;
    private Bil bil;

    Parkeringsplads(int nummer, Parkeringshus parkeringshus) {
        this.nummer = nummer;
        this.ankomst = null;
        this.parkeringshus = parkeringshus;
        this.bil = null;
    }

    public int getNummer() {
        return nummer;
    }

    public LocalTime getAnkomst() {
        return ankomst;
    }

    public Parkeringshus getParkeringshus() {
        return parkeringshus;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
        if (bil != null) {
            this.ankomst = LocalTime.now();
        } else {
            this.ankomst = null;
        }
    }

    public int pris(LocalTime afgang) {
        int minutes = (int) ChronoUnit.MINUTES.between(ankomst, afgang);
        int prisPr10Minutter = 6;
        return (minutes / 10 + 1) * prisPr10Minutter;
    }

    public void hentBil(LocalTime afgang) {
        parkeringshus.addToSaldo(pris(afgang));
        setBil(null);
    }
}
