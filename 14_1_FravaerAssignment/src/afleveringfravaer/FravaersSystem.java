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
		for (int i = 0; i < fravaer[0].length; i++) {
			String spacing = "  ";
			if (i + 1 > 8) { spacing = " "; }
			System.out.print((i + 1) + spacing);
		}
		System.out.println();
		System.out.println("-------------------------------------------");

		for (int i = 0; i < fravaer.length; i++) {
			System.out.print("Elev " + (i + 1) + ": ");
			for (int j = 0; j < fravaer[i].length; j++) {
				if (j == fravaer[i].length - 1) {
					System.out.print(fravaer[i][j]);
				} else {
					System.out.print(fravaer[i][j] + ", ");
				}
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

		for (int dage : fravaer[elevNr - 1]) {
			samletFravaer += dage;
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
		return (double) samletFravaer(fravaer, elevNr) / fravaer[0].length;
	}

	/**
	 * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
	 *
	 * @param fravaer
	 * @return
	 */
	public int antalUdenFravaer(int[][] fravaer) {
		int antalMedFravaer = 0;

		for (int[] elev : fravaer) {
			int i = 0;
			boolean harFravaer = false;
			while (i < elev.length && ! harFravaer) {
				if (elev[i] != 0) {
					antalMedFravaer++;
					harFravaer = true;
				}
				i++;
			}
		}
		return fravaer.length - antalMedFravaer;
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
		int mestFravaer = 0;

		for (int i = 0; i < fravaer.length; i++) {
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
