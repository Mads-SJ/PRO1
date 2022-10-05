package dicegames;

import java.util.Scanner;

/**
 * A class that models the game of 'Craps'.
 */
public class CrapsPlay {
    private final Scanner scanner;
    private final Die die1;
    private final Die die2;
    private boolean finished;
    private boolean firstRoll;
    private int points;
    private int noOfWonGames;
    private int noOfLostGames;


    /**
     * Constructor for CrapsPlay.
     */
    public CrapsPlay() {
        scanner = new Scanner(System.in);
        die1 = new Die();
        die2 = new Die();
        finished = false;
        firstRoll = true;
    }

    private void welcomeToGame() {
        System.out.println("Welcome to the game of 'Craps'!");
    }

    /**
     * Informs the user that they won the game.
     */
    private void gameWon() {
        System.out.println("Congratulations you WON the game!");
        noOfWonGames++;
        checkForNewGame();
    }

    /**
     * Informs the user that they lost the game.
     */
    private void gameLost() {
        System.out.println("YOU LOST!");
        noOfLostGames++;
        checkForNewGame();
    }

    /**
     * Informs the user that the game is over and gives statistics <br>
     * of number of won and total games.
     */
    private void gameOver() {
        System.out.println("Thank you for playing! You won " + noOfWonGames
                + " out of " + (noOfWonGames + noOfLostGames) + " games.");
        scanner.close();
    }

    /**
     * Asks the user if they want to play again.
     */
    private void checkForNewGame() {
        System.out.println("Do you want to play again? Write 'yes' or 'no'.");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("no")) {
            finished = true;
        } else if (response.equalsIgnoreCase("yes")) {
            firstRoll = true;
        } else {
            System.out.println("Please write 'yes' or 'no'.");
        }
    }

    /**
     * Rolls the die and checks the different outcomes and handles these.
     */
    private void takeTurn() {
        int sum = rollDice();
        checkRoll(sum);
    }

    private int rollDice() {
        die1.roll();
        die2.roll();

        int sum = die1.getFaceValue() + die2.getFaceValue();
        System.out.println("You rolled: " + sum);

        return sum;
    }

    /**
     * Checks if the sum hits one of the outcomes that alternates the game <br>
     * and handles each outcome accordingly.
     * @param sum the sum of the dice.
     */
    private void checkRoll(int sum) {
        if (firstRoll) {
            if (sum == 7 || sum == 11) {
                gameWon();
            } else if (sum == 2 || sum == 3 || sum == 12) {
                gameLost();
            } else {
                points = sum;
                firstRoll = false;
            }
        } else {
            if (sum == 7) {
                gameLost();
            } else {
                if (sum == points) {
                    gameWon();
                }
            }
        }
    }

    /**
     * Handles the course of the game.
     */
    public void startGame() {
        welcomeToGame();

        while (!finished) {
            System.out.println("Do you want to roll the dice? Write 'yes' or 'no'.");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                finished = true;
            } else if (response.equalsIgnoreCase("yes")) {
                takeTurn();
            } else {
                System.out.println("Please write 'yes' or 'no'.");
            }
        }
        gameOver();
    }
}
