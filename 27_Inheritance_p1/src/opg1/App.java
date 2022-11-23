package opg1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Mekaniker m1 = new Mekaniker("M1", "A1", 1998, 180.0);
        Mekaniker m2 = new Mekaniker("M2", "A2", 1998, 150.0);
        Mekaniker m3 = new Mekaniker("M3", "A3", 1998, 180.0);
        Mekaniker v1 = new Værkfører("V1", "A4", 1998, 180.0, 2000, 20);
        Mekaniker v2 = new Værkfører("V2", "A5", 1998, 180.0, 2010, 50);
        Mekaniker s1 = new Synsmand("S1", "A6", 1998, 130, 5);

        ArrayList<Mekaniker> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(v1);
        list.add(v2);
        list.add(s1);

        System.out.println(samletLoen(list));
    }

    public static double samletLoen(ArrayList<Mekaniker> list) {
        double samletLoen = 0.0;

        for (Mekaniker m : list) {
            samletLoen += m.beregnLoen();
        }

        return samletLoen;
    }
}
