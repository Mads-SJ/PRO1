package application.model;

public class Deltager {
    private String navn;

    private String tlfNr;

    private String land;

    private String by;

    private String firmaNavn;

    private String firmaTlfNr;

    public Deltager(String navn, String tlfNr, String land, String by,
                    String firmaNavn, String firmaTlfNr) {
        this.navn = navn;

        this.tlfNr = tlfNr;

        this.land = land;

        this.by = by;

        this.firmaNavn = firmaNavn;

        this.firmaTlfNr = firmaTlfNr;
    }

    public String getNavn() {
        return navn;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public String getLand() {
        return land;
    }

    public String getBy() {
        return by;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public String getFirmaTlfNr() {
        return firmaTlfNr;
    }

}
