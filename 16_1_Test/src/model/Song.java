package model;

public class Song {
    private String title;
    private String artist;
    private int bpm;

    public Song(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String tilpas(int bpm) {
        String response = "perfekt";
        if (this.bpm < bpm) {
            response = "langsom";
        } else if (this.bpm > bpm) {
            response = "hurtig";
        }
        return response;
    }

    public void printSong() {
        System.out.println("*******************************");
        System.out.println("Titel     : " + title);
        System.out.println("Kunstner  : " + artist);
        System.out.println("Hastighed : " + bpm + " (Bpm)");
        System.out.println("*******************************");
    }
}
