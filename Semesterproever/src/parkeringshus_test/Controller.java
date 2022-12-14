package parkeringshus_test;

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

    public static void createSomeObjects() {
        Bil b1 = Controller.createBil("AB 11 222");
        Bil b2 = Controller.createBil("EF 33 444");
        Bil b3 = Controller.createBil("BD 55 666");
        Parkeringshus parkeringshus = Controller.createParkeringshus(": Havnegade 12, 8000 Aarhus");

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
}
