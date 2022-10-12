package opgave3Teater;

public class TheaterFloor {
	int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 }, { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
			{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

	/**
	 * Hvis plads seat på række row er ledig reserveres pladsen og der returneres true
	 * Der returneres false hvis pladsen er optaget.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */

	public boolean buySeat(int row, int seat) {
		int price = seats[row][seat];
		if (price == 0) { return false; }
		seats[row][seat] = 0;
		return true;
	}

	/**
	 * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
	 * der returneres true. Der returneres false, hvis der ikke er nogen pladser ledige
	 * til den pågældende pris.
	 *
	 * @param price
	 * @return
	 */
	public boolean buySeat(int price) {
		int i = 0;
		int j = 0;
		boolean found = false;

		while (i < seats.length && !found) {
			while (j < seats[0].length && !found) {
				if (seats[i][j] == price) {
					seats[i][j] = 0;
					found = true;
				}
				j++;
			}
			i++;
		}
		return found;

	}

	public void printTheaterFloor() {
		System.out.println("De ledige pladser er angivet med deres pris");
		System.out.print("Sæde:    ");
		for (int i = 1; i < 11; i++) {
			System.out.print(i + "   ");
		}
		System.out.println();
		System.out.println("---------------------------------------------");

		for (int i = 0; i < seats.length; i++) {
			System.out.print("Række " + (i + 1) + ": ");
			for (int j = 0; j < seats[0].length; j++) {
				int price = seats[i][j];
				if (j == seats.length) {
					System.out.println(price);
				}
				else {
					System.out.print(price + ", ");
				}
			}
		}
	}
}
