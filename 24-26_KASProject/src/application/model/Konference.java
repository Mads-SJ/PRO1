package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private String lokation;
    private double dagspris;
    private LocalDate tilmeldingsfrist;
    private ArrayList<Tilmelding> tilmeldinger;
    private ArrayList<Udflugt> udflugter;
    private ArrayList<Hotel> hoteller;

    public Konference(
            String navn,
            LocalDate startDato,
            LocalDate slutDato,
            String lokation,
            double dagspris,
            LocalDate tilmeldingsfrist,
            ArrayList<Hotel> hoteller
    ) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.lokation = lokation;
        this.dagspris = dagspris;
        this.tilmeldingsfrist = tilmeldingsfrist;
        tilmeldinger = new ArrayList<>();
        udflugter = new ArrayList<>();
        this.hoteller = new ArrayList<>();

        this.hoteller.addAll(hoteller);
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public String getLokation() {
        return lokation;
    }

    public double getDagspris() {
        return dagspris;
    }

    public LocalDate getTilmeldingsfrist() {
        return tilmeldingsfrist;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public Udflugt createUdflugt(String navn, double pris, LocalDateTime dato, boolean inklFrokost) {
        Udflugt udflugt = new Udflugt(navn ,pris, dato, inklFrokost);
        udflugter.add(udflugt);
        return udflugt;
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
        }
    }

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }
}
