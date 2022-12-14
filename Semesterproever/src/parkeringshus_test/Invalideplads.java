package parkeringshus_test;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads{
    private double area;
    public Invalideplads(int nummer, Parkeringshus parkeringshus, double area) {
        super(nummer, parkeringshus);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int pris(LocalTime afgang) {
        return 0;
    }
}
