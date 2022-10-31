package model;

import java.util.ArrayList;
import java.util.Random;

public class Yatzy {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;

	// Random number generator.
	private Random random = new Random();

	public Yatzy() {
		//
	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Sets the 5 face values of the dice. Pre: values contains 5 face values in
	 * [1..6]. Note: This method is only meant to be used for test, and
	 * therefore has package visibility.
	 */
	void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}

	/**
	 * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
	 * boolean values.
	 */
	public void throwDice(boolean[] holds) {
		for (int i = 0; i < holds.length; i++) {
			if (!holds[i]) {
				values[i] = random.nextInt(6) + 1;
			}
		}
		throwCount++;
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns all results possible with the current face values. The order of
	 * the results is the same as on the score board. Note: This is an optional
	 * method. Comment this method out, if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Returns an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v
	// <= 6.
	// Index 0 is not used.
	private int[] calcCounts() {
		int[] counts = new int[7];
		for (int value : values) {
			counts[value] += 1;
		}
		return counts;
	}

	/**
	 * Returns same-value points for the given face value. Returns 0, if no dice
	 * has the given face value. Pre: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int[] counts = calcCounts();
		return counts[value] * value;
	}

	/**
	 * Returns points for one pair (for the face value giving highest points).
	 * Returns 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		ArrayList<Integer> pairIndices = getPairIndices();
		int size = pairIndices.size();
		if (size < 1) {
			return 0;
		}
		return pairIndices.get(size - 1) * 2;
	}

	/**
	 * Returns points for two pairs (for the 2 face values giving highest
	 * points). Returns 0, if there aren't 2 dice with one face value and 2 dice
	 * with a different face value.
	 */
	public int twoPairPoints() {
		ArrayList<Integer> pairIndices = getPairIndices();
		int size = pairIndices.size();
		if (size < 2) { return 0; }

		return pairIndices.get(size - 1) * 2 + pairIndices.get(size - 2) * 2;
	}

	// Returns an array list of integers containing indices of pairs.
	private ArrayList<Integer> getPairIndices() {
		int[] counts = calcCounts();
		ArrayList<Integer> pairIndices = new ArrayList<>();

		for (int i = 1; i < counts.length; i++) {
			if (counts[i] >= 2) {
				pairIndices.add(i);
			}
		}

		return pairIndices;
	}

	/**
	 * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with
	 * the same face value.
	 */
	public int threeSamePoints() {
		return nOfAKindPoints(3);
	}

	/**
	 * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with
	 * the same face value.
	 */
	public int fourSamePoints() {
		return nOfAKindPoints(4);
	}

	// Returns points for n of a kind.
	private int nOfAKindPoints(int n) {
		int points = 0;
		int[] counts = calcCounts();

		for (int i = 1; i < counts.length; i++) {
			if (counts[i] >= n) {
				points =  i * n;
			}
		}
		return points;
	}

	/**
	 * Returns points for full house. Returns 0, if there aren't 3 dice with one
	 * face value and 2 dice a different face value.
	 */
	public int fullHousePoints() {
		int[] counts = calcCounts();
		int points = 0;
		boolean fullHouse = true;
		boolean hasTriple = false;

		int i = 1;
		while (i < counts.length && fullHouse) {
			if (counts[i] != 2 && counts[i] != 3 && counts[i] > 0) {
				fullHouse = false;
			} else {
				if (counts[i] == 3) {
					hasTriple = true;
				}
				points += counts[i] * i;
			}
			i++;
		}

		return hasTriple ? points : 0;
	}

	/**
	 * Returns points for small straight. Returns 0, if the dice are not showing
	 * 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		if (!isStraightInInterval(1, 5)) { return 0; }
		return 15;
	}

	/**
	 * Returns points for large straight. Returns 0, if the dice is not showing
	 * 2,3,4,5,6.
	 */
	public int largeStraightPoints() {
		if (!isStraightInInterval(2, 6)) { return 0; }
		return 20;
	}

	// Returns true if there is a straight in the given interval, or else false.
	private boolean isStraightInInterval(int start, int end) {
		int[] counts = calcCounts();
		boolean straight = true;

		int i = start;
		while (i <= end && straight) {
			if (!(counts[i] == 1)) {
				straight = false;
			}
			i++;
		}

		return straight;
	}

	/**
	 * Returns points for chance.
	 */
	public int chancePoints() {
		int points = 0;

		for (int value : values) {
			points += value;
		}

		return points;
	}

	/**
	 * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
	 * face value.
	 */
	public int yatzyPoints() {
		int[] counts = calcCounts();
		int points = 0;
		boolean yatzy = false;

		int i = 1;
		while (i < counts.length && !yatzy) {
			if (counts[i] == 5) {
				points = 50;
				yatzy = true;
			}
			i++;
		}

		return points;
	}

}
