package model;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // OPG 1
        // 1.1
        ArrayList<String> names = new ArrayList<>();
        names.add("Pax");
        names.add("Fido");
        names.add("Molly");
        names.add("Pluto");
        names.add("Juno");

        // 1.2
        System.out.println("OPG 1.2");
        System.out.println(names);
        System.out.println();

        // 1.3
        System.out.println("OPG 1.3");
        names.set(2, "King");
        System.out.println(names);
        System.out.println();

        // 1.4
        System.out.println("OPG 1.4");
        names.remove(1);
        System.out.println(names);
        System.out.println();

        // 1.5
        System.out.println("OPG 1.5");
        names.add(3, "Trine");
        System.out.println(names);
        System.out.println();

        // 1.6
        System.out.println("OPG 1.6");
        names.add(0, "Bella");
        System.out.println(names);
        System.out.println();

        // 1.7
        System.out.println("OPG 1.7");
        System.out.println("Der er " + names.size() + " elementer i listen");
        System.out.println();

        // 1.8
        System.out.println("OPG 1.8");
        int noOfNamesWith5Chars = 0;
        for (String name : names) {
            if (name.length() == 5) {
                noOfNamesWith5Chars++;
            }
        }
        System.out.println("Antal navne på fem bogstaver: " + noOfNamesWith5Chars);
        System.out.println();

        // 1.9
        System.out.println("OPG 1.9");
        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names.get(i));
        }
        System.out.println();

        // 1.10
        System.out.println("OPG 1.10");
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(names.get(i));
            }
        }
    }
}
