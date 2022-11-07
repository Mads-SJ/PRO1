package opg2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        gifts = new ArrayList<>();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age + " gammel.";
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    public void addGift(Gift gift) {
        if (!gifts.contains(gift)) {
            gifts.add(gift);
        }
    }

    public void removeGift(Gift gift) {
        if (gifts.contains(gift)) {
            gifts.remove(gift);
        }
    }

    public double totalGiftPrice() {
        double total = 0;

        for (Gift g : gifts) {
            total += g.getPrice();
        }

        return total;
    }

    public ArrayList<Person> getGivers() {
        ArrayList<Person> givers = new ArrayList<>();

        for (Gift g : gifts) {
            givers.add(g.getPerson());
        }

        return givers;
    }
}
