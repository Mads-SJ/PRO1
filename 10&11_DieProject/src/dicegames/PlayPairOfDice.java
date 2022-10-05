package dicegames;

import java.util.Scanner;

/**
 * A game where the user can roll a pair of dice until they get bored.
 */
public class PlayPairOfDice {
    private final PairOfDices pairOfDices;
    private final Scanner scanner;

    /**
     * Constructs the PlayPairOfDice game.
     */
    public PlayPairOfDice() {
        pairOfDices = new PairOfDices();
        scanner = new Scanner(System.in);
    }

    private void welcomeToGame() {
        System.out.println("Welcome to the game 'Pair of Dices'!");
    }

    /**
     * Thanks the player for playing and shows different statistics for the game.
     */
    private void gameOver() {
        System.out.println("Thank you for playing! You rolled "
                + pairOfDices.getNoOfRolls()
                + " times.");
        System.out.println("You rolled a pair: " + pairOfDices.getNoOfPairs() + " times.");
        System.out.println("Your highest roll was: " + pairOfDices.getHighestRoll());
        System.out.println("Your rolled one: " + pairOfDices.getNoOfOnes() + " times.");
        System.out.println("Your rolled two: " + pairOfDices.getNoOfTwos() + " times.");
        System.out.println("Your rolled three: " + pairOfDices.getNoOfThrees() + " times.");
        System.out.println("Your rolled four: " + pairOfDices.getNoOfFours() + " times.");
        System.out.println("Your rolled five: " + pairOfDices.getNoOfFives() + " times.");
        System.out.println("Your rolled six: " + pairOfDices.getNoOfSixes() + " times.");
        scanner.close();
    }

    /**
     * Rolls the pair of dices and prints the sum.
     */
    private void takeTurn() {
        pairOfDices.rollBothDices();
        int sum = pairOfDices.sumOfDices();

        System.out.println("The sum of you roll is: " + sum);
    }

    /**
     * Start the game loop.<br/>
     * The game is finished when the player chooses to not roll the die anymore.
     */
    public void startGame() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Do you want to roll the pair of dices? Write 'Yes' or 'No'");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("No")) {
                finished = true;
            } else if (response.equalsIgnoreCase("Yes")) {
                takeTurn();
            } else {
                System.out.println("Please write 'Yes' or 'No'.");
            }
        }
        gameOver();
    }
}
