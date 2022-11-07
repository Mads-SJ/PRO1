package opg4;

import java.time.LocalDate;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private Bolig bolig;
    private Lejer lejer1;
    private Lejer lejer2;

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

    public Lejer getLejer1() {
        return lejer1;
    }

    public void setLejer1(Lejer lejer) {
        if (lejer1 != lejer) {
            lejer1 = lejer;
        }
    }

    public Lejer getLejer2() {
        return lejer2;
    }

    public void setLejer2(Lejer lejer) {
        if (lejer2 != lejer) {
            lejer2 = lejer;
        }
    }
}
