package januar_2020.storage;

import januar_2020.model.Festival;
import januar_2020.model.Frivillig;
import januar_2020.model.FrivilligForening;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Festival> festivaller = new ArrayList<>();
    private static final ArrayList<Frivillig> frivillige = new ArrayList<>();

    public static ArrayList<Festival> getFestivaller() {
        return new ArrayList<>(festivaller);
    }

    public static void addFestival(Festival festival) {
        festivaller.add(festival);
    }

    public static ArrayList<Frivillig> getFrivillige() {
        return new ArrayList<>(frivillige);
    }

    public static void addFrivillig(Frivillig frivillig) {
        frivillige.add(frivillig);
    }
}
