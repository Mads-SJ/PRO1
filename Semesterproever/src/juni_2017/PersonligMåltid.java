package juni_2017;

public class PersonligMåltid {
    private String navn;
    private String anretterNavn;

    public PersonligMåltid(String navn, String anretterNavn) {
        this.navn = navn;
        this.anretterNavn = anretterNavn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAnretterNavn() {
        return anretterNavn;
    }

    public void setAnretterNavn(String anretterNavn) {
        this.anretterNavn = anretterNavn;
    }
}
