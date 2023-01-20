package semesterprøve_PRO1_januar_2023.application.model;

public class Vare {
    private Varekategori varekategori;
    private String navn;
    private int udbudspris;
    private boolean solgt;
    private Salgsannonce salgsannonce;

    public Vare(Varekategori varekategori, String navn, int udbudspris) {
        this.varekategori = varekategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
        this.solgt = false;
    }

    public Varekategori getVarekategori() {
        return varekategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        if (this.salgsannonce != salgsannonce) {
            Salgsannonce oldSalgsannonce = this.salgsannonce;
            if (oldSalgsannonce != null) {
                oldSalgsannonce.removeVare(this);
            }
            this.salgsannonce = salgsannonce;
            if (salgsannonce != null) {
                salgsannonce.addVare(this);
            }
        }

    }

    @Override
    public String toString() {
        return navn + "    " + udbudspris + "    " + (solgt ? "solgt" : "til salg");
    }
}
