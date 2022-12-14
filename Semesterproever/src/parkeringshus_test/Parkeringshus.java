package parkeringshus_test;

import java.time.LocalTime;
import java.util.ArrayList;

public class Parkeringshus {
    private String adresse;
    private ArrayList<Parkeringsplads> parkeringspladser;
    private int saldo;

    public Parkeringshus(String adresse) {
        this.adresse = adresse;
        parkeringspladser = new ArrayList<>();
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Parkeringsplads> getParkeringspladser() {
        return new ArrayList<>(parkeringspladser);
    }

    public Parkeringsplads createParkeringsplads(int nummer) {
        Parkeringsplads parkeringsplads = new Parkeringsplads(nummer, this);
        parkeringspladser.add(parkeringsplads);
        return parkeringsplads;
    }

    public Invalideplads createInvalidesplads(int nummer, double areal) {
        Invalideplads invalideplads = new Invalideplads(nummer, this, areal);
        parkeringspladser.add(invalideplads);
        return invalideplads;
    }

    public void removeParkeringsplads(Parkeringsplads parkeringsplads) {
        if (parkeringspladser.contains(parkeringsplads)) {
            parkeringspladser.remove(parkeringsplads);
        }
    }

    public int antalLedigePladser() {
        int antal = 0;
        for (Parkeringsplads p: parkeringspladser) {
            if (p.getBil() == null) {
                antal++;
            }
        }
        return antal;
    }

    public int findPladsMedBil(String regNummer) {
        int plads = -1;
        int i = 0;
        while (plads == -1 && i < parkeringspladser.size()) {
            Parkeringsplads p = parkeringspladser.get(i);
            Bil b = p.getBil();
            if (b != null && b.getRegNr().equals(regNummer)) {
                plads = p.getNummer();
            } else {
                i++;
            }
        }
        return plads;
    }

    public int getSaldo() {
        return saldo;
    }

    public void addToSaldo(int amount) {
        this.saldo += amount;
    }

    public int antalBiler(Bilmærke bilmærke) {
        int antal = 0;
        for (Parkeringsplads p : parkeringspladser) {
            Bil b = p.getBil();
            if (b != null && b.getBilmærke() == bilmærke) {
                antal++;
            }
        }
        return antal;
    }

    public ArrayList<String> optagnePladser() {
        ArrayList<String> result = new ArrayList<>();
        for (Parkeringsplads p : parkeringspladser) {
            Bil b = p.getBil();
            if (b != null) {
                String info = p.getNummer() + ", " + b.getRegNr() + ", " + b.getBilmærke();
                result.add(info);
            }
        }
        return result;
    }

    public Parkeringsplads getLedigParkeringsplads() {
        Parkeringsplads parkeringsplads = null;
        int i = 0;
        while (parkeringsplads == null && i < parkeringspladser.size()) {
            Parkeringsplads p = parkeringspladser.get(i);
            if (p.getBil() == null) {
                parkeringsplads = p;
            }
            i++;
        }
        return parkeringsplads;
    }

    @Override
    public String toString() {
        return adresse;
    }
}
