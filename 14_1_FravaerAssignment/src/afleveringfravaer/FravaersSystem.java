package afleveringfravaer;

import java.util.Arrays;

public class FravaersSystem {
    /**
     * Fraværstallene udskrives på skærmen
     *
     * @param fravaer
     */
    public void udskrivFravaer(int[][] fravaer) {
        System.out.print("Måned:  ");

        for (int i = 1; i <= fravaer[0].length; i++) {
            String spacing = "  ";
            if (i > 9) {
                spacing = " ";
            }
            System.out.print(i + spacing);
        }

        System.out.println();
        System.out.println("--------------------------------------------");

        for (int i = 0; i < fravaer.length; i++) {
            System.out.print("Elev " + (i + 1) + ": ");

            for (int j = 0; j < fravaer[i].length; j++) {
				String amount = "" + fravaer[i][j];
                if (j < fravaer[i].length - 1) {
                    amount += ", ";
                }
				System.out.print(amount);
            }
            System.out.println();
        }
    }

    /**
     * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
     * elevnr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public int samletFravaer(int[][] fravaer, int elevNr) {
        int samletFravaer = 0;

        for (int antalDage : fravaer[elevNr - 1]) {
            samletFravaer += antalDage;
        }
        return samletFravaer;
    }

    /**
     * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
     * elevNr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public double gennemsnit(int[][] fravaer, int elevNr) {
		int samletFravaer = samletFravaer(fravaer, elevNr);
		int antalMaaneder = fravaer[elevNr - 1].length;

        return (double) samletFravaer / antalMaaneder;
    }

    /**
     * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
     *
     * @param fravaer
     * @return
     */
    public int antalUdenFravaer(int[][] fravaer) {
        int antalUdenFravaer = fravaer.length;

        for (int[] elev : fravaer) {
            int i = 0;
            boolean harFravaer = false;
            while (i < elev.length && !harFravaer) {
                if (elev[i] != 0) {
                    antalUdenFravaer--;
                    harFravaer = true;
                }
                i++;
            }
        }
        return antalUdenFravaer;
    }

    /**
     * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
     * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer
     * for en af disse.
     *
     * @param fravaer
     * @return
     */
    public int mestFravaer(int[][] fravaer) {
        int elevNr = 0;
        int mestFravaer = samletFravaer(fravaer, elevNr + 1);

        for (int i = 1; i < fravaer.length; i++) {
            int samletFravaer = samletFravaer(fravaer, i + 1);
            if (samletFravaer > mestFravaer) {
                mestFravaer = samletFravaer;
                elevNr = i;
            }
        }
        return elevNr + 1;
    }

    /**
     * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
     * måneder.
     *
     * @param fravaer
     * @param elevNr
     */
    public void nulstil(int[][] fravaer, int elevNr) {
//		for (int i = 0; i < fravaer[elevNr - 1].length; i++) {
//			fravaer[elevNr - 1][i] = 0;
//		}

        Arrays.fill(fravaer[elevNr - 1], 0);
    }
}
