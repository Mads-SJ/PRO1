package januar_2020.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Festival {
    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Job> jobs;

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
        jobs = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonrar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timeHonrar, antalTimer);
        jobs.add(job);
        return job;
    }

    public int budgetteretJobUdgift() {
        int budgetteretUdgift = 0;
        for (Job j : jobs) {
            budgetteretUdgift += j.getTimeHonrar() * j.getAntalTimer();
        }
        return budgetteretUdgift;
    }

    public int realiseretJobUdgift() {
        int realiseretUdgift = 0;
        for (Job j : jobs) {
            for (Vagt v : j.getVagter()) {
                realiseretUdgift += v.getTimer() * j.getTimeHonrar();
            }
        }
        return realiseretUdgift;
    }

    public ArrayList<Frivillig> getFrivillige() {
        ArrayList<Frivillig> frivillige = new ArrayList<>();
        for (Job j : jobs) {
            for (Vagt v : j.getVagter()) {
                Frivillig frivillig = v.getFrivillig();
                if (!frivillige.contains(frivillig)) {
                    frivillige.add(frivillig);
                }
            }
        }
        return frivillige;
    }

    public ArrayList<String> gaverTilFrivillige() {
        ArrayList<String> result = new ArrayList<>();
        for (Frivillig f : getFrivillige()) {
            result.add(f.gaveTekst());
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public String toString() {
        return navn + " " + fraDato + " til " + tilDato;
    }
}
