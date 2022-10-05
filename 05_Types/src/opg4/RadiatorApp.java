package opg4;

import java.util.ArrayList;

public class RadiatorApp {
    public static void main(String[] args) {
        Radiator r1 = new Radiator();
        Radiator r2 = new Radiator(22);
        r1.skruNed(2);
        r2.skruOp(3);
        System.out.println(r1.getTemperature());
        System.out.println(r2.getTemperature());



        ArrayList<Radiator> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);

        for(Radiator r : list) {
            r.skruOp(2);
        }

        System.out.println(r1.getTemperature());
        System.out.println(r2.getTemperature());
    }
}
