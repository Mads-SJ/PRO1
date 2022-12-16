package januar_2020.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonrar;
    private int antalTimer;
    private ArrayList<Vagt> vagter;

    Job(String kode, String beskrivelse, LocalDate dato, int timeHonrar, int antalTimer) { // Package visibility
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonrar = timeHonrar;
        this.antalTimer = antalTimer;
        vagter = new ArrayList<>();
    }

    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonrar() {
        return timeHonrar;
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public Vagt createVagt(int timer, Frivillig frivillig) {
        Vagt vagt = new Vagt(timer, this, frivillig);
        vagter.add(vagt);
        return vagt;
    }

    public int ikkeBesatteTimer() {
        int ikkeBesatteTimer = antalTimer;
        for (Vagt v : vagter) {
            ikkeBesatteTimer -= v.getTimer();
        }
        return ikkeBesatteTimer;
    }

    @Override
    public String toString() {
        return kode + " " + beskrivelse + " " + antalTimer;
    }
}
