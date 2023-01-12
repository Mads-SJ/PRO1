package januar_2022.storage;

import januar_2022.model.Forhindring;
import januar_2022.model.Løb;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Løb> løb = new ArrayList<>();
    private static ArrayList<Forhindring> forhindringer = new ArrayList<>();

    public static ArrayList<Løb> getLøb() {
        return new ArrayList<>(løb);
    }

    public static void addLøb(Løb løb) {
        Storage.løb.add(løb);
    }

    public static ArrayList<Forhindring> getForhindringer() {
        return new ArrayList<>(forhindringer);
    }

    public static void addForhindring(Forhindring forhindring) {
        Storage.forhindringer.add(forhindring);
    }
}
