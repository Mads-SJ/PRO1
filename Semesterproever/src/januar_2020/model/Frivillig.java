package januar_2020.model;

import java.util.ArrayList;

public class Frivillig {
    private String navn;
    private String mobil;
    private int maksAntalTimer;
    private ArrayList<Vagt> vagter;

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
        vagter = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    // package visibility
    void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
        }
    }

    public int ledigeTimer() {
        int ledigeTimer = maksAntalTimer;
        for (Vagt v : vagter) {
            ledigeTimer -= v.getTimer();
        }
        return ledigeTimer;
    }

    public String oversigt() {
        StringBuilder sb = new StringBuilder();
        sb.append(navn + "\n" + "Maks timer der ønskes er " + maksAntalTimer + "\n");
        for (Vagt v : vagter) {
            sb.append(v.getTimer() + " på " + v.getJob().getKode() + "\n");
        }
        return sb.toString();
    }

    public String gaveTekst() {
        return navn + "    " + "1";
    }

    @Override
    public String toString() {
        return navn + " " + mobil + " " + maksAntalTimer;
    }
}
