package januar_2022.controller;

import januar_2022.model.Forhindring;
import januar_2022.model.Løb;
import januar_2022.model.Note;
import januar_2022.model.Tilmelding;
import januar_2022.storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    public static ArrayList<Løb> getLøb() {
        return Storage.getLøb();
    }
    public static ArrayList<Forhindring> getForhindringer() {
        return Storage.getForhindringer();
    }
    public static Løb createLøb(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris) {
        Løb løb = new Løb(dato, sted, normalPris, earlyBirdDate, earlyBirdPris);
        Storage.addLøb(løb);
        return løb;
    }

    public static Forhindring createForhindring(int nummer, String navn) {
        Forhindring forhindring = new Forhindring(nummer, navn);
        Storage.addForhindring(forhindring);
        return forhindring;
    }

    public static Tilmelding createTilmeldingForLøb(Løb løb, String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer) {
       return løb.createTilmelding(navn, kvinde, tilmeldingsdato, løbeNummer);
    }

    public static Note createNoteForTilmelding(Tilmelding tilmelding, int strafSekunder, Forhindring forhindring) {
        return tilmelding.createNote(strafSekunder, forhindring);
    }

    public static void addForhindringToLøb(Løb løb, Forhindring forhindring) {
        løb.addForhindring(forhindring);
    }

    public static void resultaterTilFil(Løb løb, String filNavn) {
        ArrayList<Tilmelding> tilmeldinger = løb.getTilmeldinger();
        Collections.sort(tilmeldinger);

        try(PrintWriter printWriter = new PrintWriter(filNavn)) {
            for (Tilmelding t : tilmeldinger) {
                if (t.resultatTid() != -1) {
                    printWriter.println(t.getNavn() + " " + t.resultatTid());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initStorage() {
        Løb løb = Controller.createLøb(LocalDate.of(2021, 8, 23), "Hansle bakker",
                500, LocalDate.of(2021, 6, 23), 350);
        Forhindring f1 = Controller.createForhindring(1, "Stejl bakke");
        Forhindring f2 = Controller.createForhindring(2, "Meget stejl bakke");
        Forhindring f3 = Controller.createForhindring(3, "Mudderpøl");
        Forhindring f4 = Controller.createForhindring(4, "Over mur");
        Forhindring f5 = Controller.createForhindring(5, "Under gitter");
        Controller.addForhindringToLøb(løb, f1);
        Controller.addForhindringToLøb(løb, f2);
        Controller.addForhindringToLøb(løb, f3);
        Controller.addForhindringToLøb(løb, f4);
        Controller.addForhindringToLøb(løb, f5);
        Tilmelding t1 = Controller.createTilmeldingForLøb(løb, "Sune", false, LocalDate.of(2021, 5, 12), 1);
        Tilmelding t2 = Controller.createTilmeldingForLøb(løb, "Anne", true, LocalDate.of(2021, 7, 12), 2);
        Tilmelding t3 = Controller.createTilmeldingForLøb(løb, "Bent", false, LocalDate.of(2021, 7, 14), 3);
        Tilmelding t4 = Controller.createTilmeldingForLøb(løb, "Ole", false, LocalDate.of(2021, 5, 10), 4);
        Tilmelding t5 = Controller.createTilmeldingForLøb(løb, "Lars", false, LocalDate.of(2021, 4, 8), 5);
        Tilmelding t6 = Controller.createTilmeldingForLøb(løb, "Mette", true, LocalDate.of(2021, 8, 20), 6);
        t1.setLøbstid(8733);
        t2.setLøbstid(9132);
        Controller.createNoteForTilmelding(t2, 90, f4);
        t4.setLøbstid(8280);
        Controller.createNoteForTilmelding(t4, 220, f4);
        t5.setLøbstid(9126);
        Controller.createNoteForTilmelding(t5, 180, f4);
        Controller.createNoteForTilmelding(t5, 410, f5);
        t6.setLøbstid(12732);
    }
}
