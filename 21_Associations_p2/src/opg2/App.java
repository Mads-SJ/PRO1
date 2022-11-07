package opg2;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Lars", 24);
        Person p2 = new Person("Sonya", 27);
        Person p3 = new Person("Mads", 24);

        Gift g1 = new Gift("d1", p1);
        Gift g2 = new Gift("d2", p2);
        Gift g3 = new Gift("d3", p3);

        p1.addGift(g1);
        p1.addGift(g2);
        p1.addGift(g3);

        System.out.println(p1 + " modtager: " + p1.getGifts());

        System.out.println(p1.getGivers());

        System.out.println(p1);
    }
}
