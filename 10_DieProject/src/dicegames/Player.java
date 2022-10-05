package dicegames;

/**
 * Models a player in the game of 'Pig'.
 */
public class Player {
    private final String name;
    private int points;
    private int rolls;
    private int noOfTurns;

    /**
     * Constructor for Player.
     * @param name the name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Calculates the average rolls per turn.
     * @return the average rolls per turn.
     */
    public double getAverageRollsPerTurn() {
        double averageRollsPerTurn = 0.0;

        if (noOfTurns != 0) {
            averageRollsPerTurn = (double) rolls / noOfTurns;
        }

        return averageRollsPerTurn;
    }

    public String getName() {
        return name;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public void incrementRolls() {
        rolls++;
    }

    public void incrementNoOfTurns() {
        noOfTurns++;
    }
}
