package afleveringfravaer;

public class AfproevFravaersSystem {

    public static void main(String[] args) {
        int[][] fravaer22S = {
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 },
                { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0 }
        };

        FravaersSystem fraværsSystem = new FravaersSystem();

        // OPG 1
        System.out.println("OPG 1:");
        fraværsSystem.udskrivFravaer(fravaer22S);
        System.out.println();

        // OPG 2
        System.out.println("OPG 2:");
        int samletFravaerElev1 = fraværsSystem.samletFravaer(fravaer22S, 1);
        System.out.println("Elev 1 samlet fravær - forventet: " + (2 + 3 + 1 + 2) + ", fik: " + samletFravaerElev1);
        System.out.println();

        // OPG 3
        System.out.println("OPG 3:");
        double gennemsnitligFravaerElev1 = fraværsSystem.gennemsnit(fravaer22S, 1);
        System.out.println("Elev 1 gennemsnitlig fravær - forventet: " + (8.0 / 12.0) + ", fik: " + gennemsnitligFravaerElev1);
        System.out.println();

        // OPG 4
        System.out.println("OPG 4:");
        int antalUdenFravaer = fraværsSystem.antalUdenFravaer(fravaer22S);
        System.out.println("Antal uden fravær - forventet: 1, fik: " + antalUdenFravaer);
        System.out.println();

        // OPG 5
        System.out.println("OPG 5:");
        int elevNrMedMestFravaer = fraværsSystem.mestFravaer(fravaer22S);
        System.out.println("Elev nummer med mest fravær - forventet: 4, fik: " + elevNrMedMestFravaer);
        System.out.println();

        // OPG 6
        System.out.println("OPG 6:");
        System.out.println("Fravær for elev nummer 4 nulstilles.");
        fraværsSystem.nulstil(fravaer22S, 4);
        fraværsSystem.udskrivFravaer(fravaer22S);
        System.out.println();
    }
}
