package januar_2022.model;

import java.util.ArrayList;

public class Forhindring {
    private int nummer;
    private String navn;
    private ArrayList<Løb> løb;

    public Forhindring(int nummer, String navn) {
        this.nummer = nummer;
        this.navn = navn;
        løb = new ArrayList<>();
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Løb> getLøb() {
        return new ArrayList<>(løb);
    }

    public void addLøb(Løb løb) {
        if (!this.løb.contains(løb)) {
            this.løb.add(løb);
            løb.addForhindring(this);
        }
    }

    public void removeLøb(Løb løb) {
        if (this.løb.contains(løb)) {
            this.løb.remove(løb);
            løb.removeForhindring(this);
        }
    }
}
