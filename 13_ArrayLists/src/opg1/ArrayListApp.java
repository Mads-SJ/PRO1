package opg1;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hans");
        list.add("Viggo");
        list.add("Jens");
        list.add("Børge");
        list.add("Bent");

        System.out.println(list.size());

        list.add(2, "Jane");

        System.out.println(list);

        list.remove(1);
        list.add(0, "Pia");
        list.add("Ib");

        System.out.println(list.size());

        list.set(2, "Hansi");

        System.out.println(list.size());

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).length());
        }

        System.out.println();

        for (String name : list) {
            System.out.println(name.length());
        }
    }
}
