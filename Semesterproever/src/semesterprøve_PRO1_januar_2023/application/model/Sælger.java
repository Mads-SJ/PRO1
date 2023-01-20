package semesterprøve_PRO1_januar_2023.application.model;

import java.util.ArrayList;

public class Sælger implements Comparable<Sælger> {
    private String navn;
    private int studiekortNummer;
    private String mobil;
    private ArrayList<Salgsannonce> salgsannoncer;

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
        salgsannoncer = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return new ArrayList<>(salgsannoncer);
    }

    public Salgsannonce createSalgsannonce() {
        Salgsannonce salgsannonce = new Salgsannonce(this);
        salgsannoncer.add(salgsannonce);
        return salgsannonce;
    }

    public void addSalgsAnnonce(Salgsannonce salgsannonce) {
        if (!salgsannoncer.contains(salgsannonce)) {
            salgsannoncer.add(salgsannonce);
        }
    }

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(Varekategori kategori) {
        ArrayList<Vare> ikkeSolgteVarerIKategori = new ArrayList<>();
        for (Salgsannonce s : salgsannoncer) {
            for (Vare v : s.getVarer()) {
                if (v.getVarekategori() == kategori && !v.isSolgt()) {
                    ikkeSolgteVarerIKategori.add(v);
                }
            }
        }
        return ikkeSolgteVarerIKategori;
    }

    @Override
    public int compareTo(Sælger other) {
        return navn.compareTo(other.navn);
    }
}
