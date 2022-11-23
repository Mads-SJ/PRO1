package juni_2017;

public class Patient {
    private String navn;
    private double vægt;
    private int vægtFaktor;

    public Patient(String navn, double vægt, int vægtFaktor) {
        this.navn = navn;
        this.vægt = vægt;
        this.vægtFaktor = vægtFaktor;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVægt() {
        return vægt;
    }

    public void setVægt(double vægt) {
        this.vægt = vægt;
    }

    public int getVægtFaktor() {
        return vægtFaktor;
    }

    public void setVægtFaktor(int vægtFaktor) {
        this.vægtFaktor = vægtFaktor;
    }
}
