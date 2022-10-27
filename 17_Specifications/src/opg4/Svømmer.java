package opg4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Modellerer en svømmer
 */
public class Svømmer {
    private String navn;
    private String klub;
    private LocalDate fødselsdag;
    private ArrayList<Double> tider;

    /**
     * Initialiserer en ny svømmer med navn, fødselsdag, klub
     *  og tider.
     */
    public Svømmer(String navn, String klub, LocalDate fødselsdag, ArrayList<Double> tider) {
        this.navn = navn;
        this.klub = klub;
        this.fødselsdag = fødselsdag;
        this.tider = tider;
    }

    /**
     * Returnerer svømmerens navn.
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Returnerer svømmerens klub.
     */
    public String getKlub() {
        return klub;
    }

    /**
     * Returnerer svømmerens årgang.
     */
    public LocalDate getFødselsdag() {
        return fødselsdag;
    }

    /**
     * Registrerer svømmerens klub
     * @param klub
     */
    public void setKlub(String klub) {
        this.klub = klub;
    }

    /**
     * Returnerer den hurtigste tid svømmeren har opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double bedsteTid() {
        double bestTime = tider.get(0);

        for (double tid : tider) {
            if (tid < bestTime) {
                bestTime = tid;
            }
        }
        return bestTime;
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double gennemsnitAfTid() {
        double total = 0;

        for (double tid : tider) {
            total += tid;
        }
        return total / tider.size();
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået idet den langsomste tid ikke er medregnet
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double snitUdenDårligste() {
        double total = 0;

        for (double tid : tider) {
            total += tid;
        }
        double worstTime = Collections.max(tider);
        return (total - worstTime) / (tider.size() - 1);
    }

}
