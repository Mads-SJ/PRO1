package dicegames;

import java.util.Scanner;

/**
 * Models the game of 'Pig'.
 */
public class PigGame {
    private final Scanner scanner;
    private final Die die;
    private final Player player1;
    private final Player player2;
    private int pointsToWin;
    private boolean isPlayer1InTurn;
    private boolean finished;

    /**
     * Constructor for PigGame.
     */
    public PigGame() {
        scanner = new Scanner(System.in);
        die = new Die();
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        isPlayer1InTurn = true;
        finished = false;
    }

    /**
     * Welcomes the user and asks for the needed points to win.
     */
    private void welcomeToGame() {
        System.out.println("Welcome to the game of 'Pig'!");
        System.out.println("How many points are needed to win? Please write a number.");
        pointsToWin = scanner.nextInt();
        scanner.nextLine(); // to avoid reading empty input on 'enter' press

    }

    /**
     * Informs the user that the game is over and gives statistics.
     */
    private void gameOver() {
        System.out.println(
                player1.getName()
                + " had "
                + player1.getPoints()
                + " points and rolled on average "
                + player1.getAverageRollsPerTurn()
                + " rolls per turn."
        );

        System.out.println(player2.getName()
                + " had "
                + player2.getPoints()
                + " points and rolled on average "
                + player2.getAverageRollsPerTurn()
                + " rolls per turn."
        );

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    /**
     * Takes a turn.
     * @param player the player in turn.
     */
    private void takeTurn(Player player) {
        startOfTurn(player);
        gameplay(player);
        endOfTurn(player);
    }

    private void startOfTurn(Player player) {
        System.out.println();
        System.out.println("It is " + player.getName() + "'s turn.");
        System.out.println("Total points: " + player.getPoints());
    }

    private void gameplay(Player player) {
        boolean isTurnOver = false;
        int sum = 0;

        while (!isTurnOver) {
            System.out.println();
            System.out.println("Do you want to roll? 'yes' or 'no'.");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("no")) {
                player.addPoints(sum);
                isTurnOver = true;
            } else if (response.equalsIgnoreCase("yes")) {
                die.roll();
                int roll = die.getFaceValue();
                System.out.println("You rolled: " + roll);

                player.incrementRolls();

                if (roll == 1) {
                    System.out.println("Bad luck... You lost your points for this turn.");
                    isTurnOver = true;
                } else {
                    sum += roll;
                    System.out.println("Your sum is now: " + sum);
                }
            } else {
                System.out.println("Please write 'yes' or 'no'.");
            }
        }
    }

    private void endOfTurn(Player player) {
        int totalPoints = player.getPoints();
        if (totalPoints >= pointsToWin) {
            System.out.println(player.getName() + " WON the game!");
            finished = true;
        } else {
            System.out.println(player.getName() + "'s total is now: " + totalPoints);
            isPlayer1InTurn = !isPlayer1InTurn;
        }

        player.incrementNoOfTurns();
    }

    /**
     * Handles the course of the game.
     */
    public void startGame() {
        welcomeToGame();

        while (!finished) {
            if (isPlayer1InTurn) {
                takeTurn(player1);
            } else {
                takeTurn(player2);
            }
        }
        gameOver();
    }
}
