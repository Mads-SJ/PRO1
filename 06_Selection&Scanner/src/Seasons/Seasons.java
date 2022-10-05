package Seasons;


public class Seasons {
    public static void main(String[] args) {
        Date date = new Date(1, 1);
        System.out.println(date.getSeason());
        date.setMonth(4);
        System.out.println(date.getSeason());
        date.setMonth(7);
        System.out.println(date.getSeason());
        date.setMonth(10);
        System.out.println(date.getSeason());

        date.setDay(21);
        date.setMonth(3);

    }
}
