package opg5;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast;
    private ArrayList<Episode> episodes;

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
        episodes = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return new ArrayList<>(cast);
    }

    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        episodes.add(episode);
        return episode;
    }

    public void removeEpisode(Episode episode) {
        if (episodes.contains(episode)) {
            episodes.remove(episode);
        }
    }

    /**
     * Return the total length (in minutes) of all the
     * episodes in the series.
     */
    public int totalLength() {
        int total = 0;

        for (Episode e : episodes) {
            total += e.getLengthMinutes();
        }

        return total;
    }

    /**
     * Return the total list of all guest actors from all
     * episodes.
     */
    public ArrayList<String> getGuestActors() {
        ArrayList<String> allGuestActors = new ArrayList<>();

        for (Episode e : episodes) {
            allGuestActors.addAll(e.getGuestActors());
        }

        return allGuestActors;
    }
}
