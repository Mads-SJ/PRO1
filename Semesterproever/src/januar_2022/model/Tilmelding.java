package januar_2022.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding implements Comparable<Tilmelding> {
    private String navn;
    private boolean kvinde;
    private LocalDate tilmeldingsdato;
    private int løbeNummer;
    private int løbstid;
    private Løb løb;
    private ArrayList<Note> noter;

    // package visibility
    Tilmelding(String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer, Løb løb) {
        this.navn = navn;
        this.kvinde = kvinde;
        this.tilmeldingsdato = tilmeldingsdato;
        this.løbeNummer = løbeNummer;
        this.løbstid = -1;
        this.løb = løb;
        noter = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public boolean isKvinde() {
        return kvinde;
    }

    public LocalDate getTilmeldingsdato() {
        return tilmeldingsdato;
    }

    public int getLøbeNummer() {
        return løbeNummer;
    }

    public int getLøbstid() {
        return løbstid;
    }

    public Løb getLøb() {
        return løb;
    }

    public ArrayList<Note> getNoter() {
        return new ArrayList<>(noter);
    }

    public Note createNote(int strafSekunder, Forhindring forhindring) {
        Note note = new Note(strafSekunder, forhindring);
        noter.add(note);
        return note;
    }

    public void removeNote(Note note) {
        if (noter.contains(note)) {
            noter.remove(note);
        }
    }

    public void registrerStrafPåForhindring(String navnForhindring, int strafSekunder) {
        for (Forhindring f : løb.getForhindringer()) {
            if (f.getNavn().equals(navnForhindring)) {
                createNote(strafSekunder, f);
            }
        }
    }

    public int resultatTid() {
        int resultatTid = løbstid;
        for (Note n : noter) {
            resultatTid -= n.getStrafSekunder();
        }
        return resultatTid;
    }

    public void setLøbstid(int løbstid) {
        this.løbstid = løbstid;
    }

    @Override
    public String toString() {
        return "Nr. " + løbeNummer + ", navn: " + navn + ", tid: " + resultatTid();
    }

    @Override
    public int compareTo(Tilmelding other) {
        int comp;
        if (this.kvinde == other.kvinde) {
            comp = this.resultatTid() - other.resultatTid();
        } else {
            if (this.kvinde) {
                comp = -1;
            } else {
                comp = 1;
            }
        }
        return comp;
    }
}
