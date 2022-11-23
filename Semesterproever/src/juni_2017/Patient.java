package juni_2017;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Patient {
    private String navn;
    private double vægt;
    private int vægtFaktor;
    ArrayList<PersonligMåltid> personligMåltider;

    public Patient(String navn, double vægt, int vægtFaktor) {
        this.navn = navn;
        this.vægt = vægt;
        this.vægtFaktor = vægtFaktor;
        personligMåltider = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVægt() {
        return vægt;
    }

    public void setVægt(double vægt) {
        this.vægt = vægt;
    }

    public int getVægtFaktor() {
        return vægtFaktor;
    }

    public void setVægtFaktor(int vægtFaktor) {
        this.vægtFaktor = vægtFaktor;
    }

    public ArrayList<PersonligMåltid> getPersonligMåltider() {
        return new ArrayList<>(personligMåltider);
    }

    public void addPersonligMåltid(PersonligMåltid personligMåltid) {
        if (!personligMåltider.contains(personligMåltid)) {
            personligMåltider.add(personligMåltid);
            personligMåltid.setPatient(this);
        }
    }

    public void removePersonligMåltid(PersonligMåltid personligMåltid) {
        if (personligMåltider.contains(personligMåltid)) {
            personligMåltider.remove(personligMåltid);
            personligMåltid.setPatient(null);
        }
    }

    public double beregnAnbefaletKalorierPerDag() {
        return vægt * vægtFaktor;
    }

    public int beregnDagensAntalKalorier() {
        int dagensAntalKalorier = 0;

        for (PersonligMåltid pm : personligMåltider) {
            dagensAntalKalorier += pm.beregnAntalKalorier();
        }

        return dagensAntalKalorier;
    }

    public double beregnProcentDagligAnbefalet() {
        return beregnDagensAntalKalorier() / beregnAnbefaletKalorierPerDag() * 100;
    }

    public void sortMåltider() {
        personligMåltider.sort(PersonligMåltid::compareTo);
    }
}
