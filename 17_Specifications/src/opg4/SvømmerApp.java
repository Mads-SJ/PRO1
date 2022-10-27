package opg4;

import java.time.LocalDate;
import java.util.ArrayList;

public class SvømmerApp {
    public static void main(String[] args) {
        ArrayList<Double> tider = new ArrayList<>();
        tider.add(2.4);
        tider.add(2.2);
        tider.add(1.9);
        tider.add(1.4);
        Svømmer svømmer = new Svømmer("Mads", "Klubben", LocalDate.of(1998,8,8),tider);

        System.out.println(svømmer.bedsteTid());
        System.out.println(svømmer.gennemsnitAfTid());
        System.out.println(svømmer.snitUdenDårligste());
    }
}
