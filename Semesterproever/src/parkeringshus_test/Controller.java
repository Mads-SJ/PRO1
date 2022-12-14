package parkeringshus_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static Parkeringshus createParkeringshus(String adresse) {
        Parkeringshus parkeringshus = new Parkeringshus(adresse);
        Storage.addParkeringshus(parkeringshus);
        return parkeringshus;
    }

    public static Parkeringsplads createParkeringsplads(int nummer, Parkeringshus parkeringshus) {
        Parkeringsplads parkeringsplads = parkeringshus.createParkeringsplads(nummer);
        return parkeringsplads;
    }

    public static Invalideplads createInvalideplads(int nummer, double areal, Parkeringshus parkeringshus) {
        Invalideplads invalideplads = parkeringshus.createInvalidesplads(nummer, areal);
        return invalideplads;
    }

    public static Bil createBil(String regNr) {
        Bil bil = new Bil(regNr);
        Storage.addBil(bil);
        return bil;
    }

    public static void setBilForParkeringsplads(Bil bil, Parkeringsplads parkeringsplads) {
        parkeringsplads.setBil(bil);
    }

    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return Storage.getParkeringshuse();
    }

    public static ArrayList<Bil> getBiler() {
        return Storage.getBiler();
    }

    public static void insertCarInLedigPlads(Bil bil, Parkeringshus parkeringshus) {
        Parkeringsplads p = parkeringshus.getLedigParkeringsplads();
        p.setBil(bil);
    }

    public static void createSomeObjects() {
        Bil b1 = Controller.createBil("AB 11 222");
        Bil b2 = Controller.createBil("EF 33 444");
        Bil b3 = Controller.createBil("BD 55 666");
        b1.setBilmærke(Bilmærke.TESLA);
        b2.setBilmærke(Bilmærke.PORSCHE);
        b3.setBilmærke(Bilmærke.CORVETTE);
        Parkeringshus parkeringshus = Controller.createParkeringshus("Havnegade 12, 8000 Aarhus");

        Parkeringsplads p1 = Controller.createParkeringsplads(1, parkeringshus);
        Parkeringsplads p2 = Controller.createParkeringsplads(2, parkeringshus);
        Parkeringsplads p3 = Controller.createParkeringsplads(3, parkeringshus);

        for (int i = 4; i <= 100; i++) {
            Controller.createParkeringsplads(i, parkeringshus);
        }

        for (int i = 101; i <= 110; i++) {
            Controller.createInvalideplads(i, 18, parkeringshus);
        }

        Controller.setBilForParkeringsplads(b1, p1);
        Controller.setBilForParkeringsplads(b2, p2);
        Controller.setBilForParkeringsplads(b3, p3);

    }

    public static void writeOptagnePladser(Parkeringshus hus, String filnavn) {
        try {
            PrintWriter printWriter = new PrintWriter(filnavn);
            ArrayList<String> optagnePladser = hus.optagnePladser();
            for (String s : optagnePladser) {
                printWriter.println(s);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
