package januar_2021.model;

import java.util.ArrayList;

public class Studerende implements Comparable<Studerende> {
    private String navn;
    private String email;
    private ArrayList<Deltagelse> deltagelser;

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
        deltagelser = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
        }
    }

    public int antalFraværsLektioner() {
        int antal = 0;
        for (Deltagelse d : deltagelser) {
            if (d.erRegistreretFravær()) {
                antal++;
            }
        }
        return antal;
    }

    @Override
    public int compareTo(Studerende other) {
        return navn.compareTo(other.navn);
    }
}
