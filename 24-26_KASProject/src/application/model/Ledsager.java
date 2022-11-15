package application.model;

import java.util.ArrayList;

public class Ledsager {
    private String navn;
    private ArrayList<Udflugt> udflugter;

    public Ledsager (String navn) {
        this.navn = navn;
        udflugter = new ArrayList<>();
    }

    public String getNavn () {
        return navn;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addLedsager(this);
        }
    }
}

