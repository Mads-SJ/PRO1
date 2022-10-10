package opg3;

import java.util.ArrayList;
import java.util.Comparator;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.println("Navn: " + player.getName() + ",  Alder: " + player.getAge() + ", Score: " + player.getScore());
        }
    }

    public double getAverageAge() {
        double avg = 0.0;
        int sum = players.stream()
                .mapToInt(Player::getAge)
                .sum();

        if (players.size() > 0) {
            avg = (double) sum / players.size();
        }
        return avg;
    }

    public int getTotalScore() {
        return players.stream()
                .mapToInt(Player::getScore)
                .sum();
    }

    public int getOldPLayersScore(int ageLimit) {
        return players.stream()
                .filter(player -> player.getAge() > ageLimit)
                .mapToInt(Player::getScore)
                .sum();
    }

    public int maxScore() {
        int maxScore = 0;

        for (Player player : players) {
            int score = player.getScore();
            if (score > maxScore){
                maxScore = score;
            }
        }
        return maxScore;
    }

    public String bestPlayer() {
        int maxScore = maxScore();

        for (Player player : players) {
            if (player.getScore() == maxScore) {
                return player.getName();
            }
        }

        return "Not found";
    }
}
