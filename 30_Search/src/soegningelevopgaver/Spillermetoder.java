package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null;
        int i = 0;
        while (spiller == null && i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getMaal() == score) {
                spiller = k;
            }
            i++;
        }
        return spiller;
    }

    public Spiller findScoreBinær (ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null;
        int left = 0;
        int right = spillere.size() - 1;
        while (spiller == null && left <= right) {
            int middle = (left + right) / 2;
            Spiller k = spillere.get(middle);
            if (k.getMaal() == score) {
                spiller = k;
            } else if (k.getMaal() > score) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return spiller;
    }

    public String godSpiller (ArrayList<Spiller> spillere) {
        String spillerNavn = "";
        int i = 0;
        while (spillerNavn.equals("") && i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getHoejde() < 170 && k.getMaal() > 50) {
                spillerNavn = k.getNavn();
            }
            i++;
        }
        return spillerNavn;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3
    }

}
