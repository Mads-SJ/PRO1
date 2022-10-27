package model;

import java.util.Scanner;

public class SongApp {
    public static void main(String[] args) {
        Song song1 = new Song("Title1", "Artist1", 100);
        Song song2 = new Song("Title2", "Artist2", 200);

        song1.setBpm(150);
        song1.printSong();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Venligst skriv en titel på en sang. (Afslut med 'Enter')");
        String title = scanner.nextLine();
        System.out.println("Venligst skriv kunstneren på sangen. (Afslut med 'Enter')");
        String artist = scanner.nextLine();
        System.out.println("Venligst skriv hastigheden (Bpm) på sangen. (Afslut med 'Enter')");
        int bpm = scanner.nextInt();

        Song song3 = new Song(title, artist, bpm);

        song3.printSong();
    }
}
