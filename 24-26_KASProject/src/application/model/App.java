package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Hotel h1 = new Hotel("Den Hvide Svane", 1050, 1250, "Testvej 1234");
        ArrayList<Hotel> hoteller = new ArrayList<>();
        hoteller.add(h1);
        Konference konference = new Konference(
                "Hav og Himmel",
                LocalDate.of(2022,5,18),
                LocalDate.of(2022,5, 20),
                "Odense Universitet",
                1500,
                LocalDate.of(2022, 5, 15),
                hoteller
        );
    }
}
