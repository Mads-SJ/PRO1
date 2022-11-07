package opg4;

import java.time.LocalDate;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private Bolig bolig;

    public Lejeaftale(Bolig bolig) {
        fraDato = LocalDate.now();
        this.bolig = bolig;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public Bolig getBolig() {
        return bolig;
    }
}
