package application.controller;

import application.model.Konference;
import application.model.Tilmelding;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        ArrayList<Konference> konferencer = Controller.getKonferencer();

        ArrayList<Tilmelding> tilmeldinger = konferencer.get(0).getTilmeldinger();

        for (Tilmelding t : tilmeldinger) {
            System.out.println(t.getDeltager().getNavn() + ": " + t.samletPris());
        }
    }
}
