package opg4;

import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String adresse;
    private ArrayList<Bolig> boliger;

    public Kollegie(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
        boliger = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Bolig> getBoliger() {
        return new ArrayList<>(boliger);
    }

    public Bolig createBolig(int kvm, String adresse, int prisPrMaaned) {
        Bolig bolig = new Bolig(kvm, adresse, prisPrMaaned, this);
        boliger.add(bolig);
        return bolig;
    }

    public void addBolig(Bolig bolig) {
        if (!boliger.contains(bolig)) {
            boliger.add(bolig);
            bolig.setKollegie(this);
        }
    }

    public void removeBolig(Bolig bolig) {
        if (boliger.contains(bolig)) {
            boliger.remove(bolig);
            bolig.setKollegie(null);
        }
    }
}
