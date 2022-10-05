package dicegames;

/**
 * This class models one pair of dices.
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
    private Die die1;

    /**
     * The second die in the pair.
     */
    private Die die2;

    // Statistics
    private int noOfRolls;
    private int noOfOnes;
    private int noOfTwos;
    private int noOfThrees;
    private int noOfFours;
    private int noOfFives;
    private int noOfSixes;
    private int noOfPairs;
    private int highestRoll;

    /**
     * Constructor for objects of class PairOfDices.
     */
    public PairOfDices() {
        die1 = new Die();
        die2 = new Die();
    }

    /**
     * Constructor for PairOfDices <br/>
     * where you can specify number of sides of the dices.
     *
     * @param sides number of sides.
     */
    public PairOfDices(int sides) {
        die1 = new Die(sides);
        die2 = new Die(sides);
    }

    /**
     * Rolls die1 and die2, checks and updates for different statistics.
     */
    public void rollBothDices() {
        die1.roll();
        die2.roll();

        int firstFaceValue = die1.getFaceValue();
        int secondFaceValue = die2.getFaceValue();

        checkFaceValue(firstFaceValue);
        checkFaceValue(secondFaceValue);

        if (firstFaceValue == secondFaceValue) {
            noOfPairs++;
        }

        int sumOfDices = sumOfDices();
        if (sumOfDices > highestRoll) {
            highestRoll = sumOfDices;
        }

        noOfRolls++;
    }

    /**
     * checks and updates the face value.
     *
     * @param faceValue value of a die.
     */
    private void checkFaceValue(int faceValue) {
        if (faceValue == 6) {
            noOfSixes++;
        } else if (faceValue == 5) {
            noOfFives++;
        } else if (faceValue == 4) {
            noOfFours++;
        } else if (faceValue == 3) {
            noOfThrees++;
        } else if (faceValue == 2) {
            noOfTwos++;
        } else if (faceValue == 1) {
            noOfOnes++;
        }
    }

    /**
     * @return the sum of the face value of die1 and die2.
     */
    public int sumOfDices() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    /**
     * Resets all statistics.
     */
    public void resetPairOfDice() {
        noOfRolls = 0;

        noOfOnes = 0;
        noOfTwos = 0;
        noOfThrees = 0;
        noOfFours = 0;
        noOfFives = 0;
        noOfSixes = 0;

        noOfPairs = 0;
        highestRoll = 0;
    }

    public int getNoOfRolls() {
        return noOfRolls;
    }

    public int getNoOfOnes() {
        return noOfOnes;
    }

    public int getNoOfTwos() {
        return noOfTwos;
    }

    public int getNoOfThrees() {
        return noOfThrees;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public int getNoOfFives() {
        return noOfFives;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }

    public int getNoOfPairs() {
        return noOfPairs;
    }

    public int getHighestRoll() {
        return highestRoll;
    }
}
