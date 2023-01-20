package semesterprøve_PRO1_januar_2023.application.controller;

import januar_2018.model.Uddannelse;
import semesterprøve_PRO1_januar_2023.application.model.*;
import semesterprøve_PRO1_januar_2023.storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    public static Salg createSalg(String køberNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        Salg salg = new Salg(køberNavn, aftaltSamletPris, varer);
        Storage.addSalg(salg);
        return salg;
    }

    public static Vare createVare(Varekategori varekategori, String navn, int udbudspris) {
        Vare vare = new Vare(varekategori, navn, udbudspris);
        Storage.addVare(vare);
        return vare;
    }

    public static Salgsannonce createSalgsannonceForSælger(Sælger sælger) {
        return sælger.createSalgsannonce();
    }

    public static Sælger createSælger(String navn, int studiekortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studiekortNummer, mobil);
        Storage.addSælger(sælger);
        return sælger;
    }

    public static void addVareToSalgsAnnonce(Vare vare, Salgsannonce salgsannonce) {
        salgsannonce.addVare(vare);
    }

    public static ArrayList<Salg> getSalg() {
        return Storage.getSalg();
    }

    public static ArrayList<Vare> getVarer() {
        return Storage.getVarer();
    }

    public static ArrayList<Sælger> getSælgere() {
        return Storage.getSælgere();
    }

    public static void salgTilFil(String filNavn) {
        ArrayList<Salg> salg = Storage.getSalg();
        Collections.sort(salg);
        try(PrintWriter printWriter = new PrintWriter(filNavn)) {
            for (Salg s : salg) {
                printWriter.println(s.oversigt() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Sælger> sælgereSomHarKøbt() {
        ArrayList<Sælger> sælgere = Storage.getSælgere();
        ArrayList<Salg> salg = Storage.getSalg();
        Collections.sort(sælgere);
        Collections.sort(salg);

        ArrayList<Sælger> sælgereSomHarKøbt = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < sælgere.size() && i2 < salg.size()) {
            Sælger sælger = sælgere.get(i1);
            String købersNavn = salg.get(i2).getKøberNavn();
            int comp = sælger.getNavn().compareTo(købersNavn);
            if (comp < 0) {
                i1++;
            } else if (comp > 0) {
                i2++;
            } else {
                sælgereSomHarKøbt.add(sælger);
                i1++;
                i2++;
            }
        }
        return sælgereSomHarKøbt;
    }

    public static ArrayList<Salgsannonce> getAktiveSalgsannoncer() {
        ArrayList<Salgsannonce> aktiveSalgsannoncer = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            for (Salgsannonce sa : sælger.getSalgsannoncer()) {
                if (!aktiveSalgsannoncer.contains(sa) && sa.isAktiv()) {
                    aktiveSalgsannoncer.add(sa);
                }
            }
        }
        return aktiveSalgsannoncer;
    }

    public static void initStorage() {
        Sælger sælger1 = Controller.createSælger("Viktor", 23, "45344247");
        Sælger sælger2 = Controller.createSælger("Gustav", 35, "56124522");

        Vare v1 = Controller.createVare(Varekategori.MOBILTELEFON, "Samsung mobil", 1200);
        Vare v2 = Controller.createVare(Varekategori.MOBILTELEFON, "IPhone", 2000);
        Vare v3 = Controller.createVare(Varekategori.STUDIEBOG, "Java", 400);
        Vare v4 = Controller.createVare(Varekategori.STUDIEBOG, "Android", 300);
        Vare v5 = Controller.createVare(Varekategori.STUDIEBOG, "Python", 200);
        Vare v6 = Controller.createVare(Varekategori.TØJ, "Regnjakke", 100);
        Vare v7 = Controller.createVare(Varekategori.TØJ, "Regnbukser", 80);

        // VIKTOR
        Salgsannonce sa1 = Controller.createSalgsannonceForSælger(sælger1);
        sa1.addVare(v1);
        Salgsannonce sa2 = Controller.createSalgsannonceForSælger(sælger1);
        sa2.addVare(v3);
        sa2.addVare(v4);
        sa2.addVare(v5);

        //GUSTAV
        Salgsannonce sa3 = Controller.createSalgsannonceForSælger(sælger2);
        sa3.addVare(v2);
        Salgsannonce sa4 = Controller.createSalgsannonceForSælger(sælger2);
        sa4.addVare(v6);
        sa4.addVare(v7);

        ArrayList<Vare> varerTilSalg1 = new ArrayList<>();
        varerTilSalg1.add(v4);
        varerTilSalg1.add(v5);
        ArrayList<Vare> varetTilSalg2 = new ArrayList<>();
        varetTilSalg2.add(v6);
        varetTilSalg2.add(v7);

        Salg salg1 = Controller.createSalg("Stine", 450, varerTilSalg1);
        Salg salg2 = Controller.createSalg("Laura", 120, varetTilSalg2);

    }
}
