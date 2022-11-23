package juni_2017;

import java.util.ArrayList;

public class PersonligMåltid implements Comparable<PersonligMåltid> {
    private String navn;
    private String anretterNavn;
    private ArrayList<Indtag> indtagelser;
    private Patient patient;

    public PersonligMåltid(String navn, String anretterNavn, Patient patient) {
        this.navn = navn;
        this.anretterNavn = anretterNavn;
        indtagelser = new ArrayList<>();
        this.patient = patient;
        patient.addPersonligMåltid(this);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAnretterNavn() {
        return anretterNavn;
    }

    public void setAnretterNavn(String anretterNavn) {
        this.anretterNavn = anretterNavn;
    }

    public ArrayList<Indtag> getIndtagelser() {
        return new ArrayList<>(indtagelser);
    }

    public Indtag createIndtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalKalorier) {
        Indtag indtag = new Indtag(vejetFørIndtagelse, vejetEfterIndtagelse, beskrivelse, anslåetAntalKalorier, this);
        indtagelser.add(indtag);
        indtag.setPersonligMåltid(this);
        return indtag;
    }

    public void addIndtag(Indtag indtag) {
        if (!indtagelser.contains(indtag)) {
            indtagelser.add(indtag);
            indtag.setPersonligMåltid(this);
        }
    }

    public void removeIndtag(Indtag indtag) {
        if (indtagelser.contains(indtag)) {
            indtagelser.remove(indtag);
            indtag.setPersonligMåltid(null);
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        if (this.patient != patient) {
            Patient oldPatient = this.patient;
            if (oldPatient != null) {
                oldPatient.removePersonligMåltid(this);
            }

            this.patient = patient;
            if (patient != null) {
                patient.addPersonligMåltid(this);
            }
        }
    }

    public double beregnAntalKalorier() {
        double antalKalorier = 0.0;

        for (Indtag i : indtagelser) {
            antalKalorier += (double) i.getAnslåetAntalKalorier() * i.getVejetEfterIndtagelse() / i.getVejetFørIndtagelse();
        }

        return antalKalorier;
    }

    @Override
    public int compareTo(PersonligMåltid other) {
        if (!this.anretterNavn.equals(other.anretterNavn)) {
            return this.anretterNavn.compareTo(other.anretterNavn);
        } else {
            return this.navn.compareTo(other.navn);
        }
    }
}
