package opg5;

public class Fødevare extends Vare {
    private int holdbarhedsperiode;

    public Fødevare(double priceExclVAT, String name, String description, int holdbarhedsperiode) {
        super(priceExclVAT, name, description, 1.05);
        this.holdbarhedsperiode = holdbarhedsperiode;
    }

    @Override
    public double getSalesPrice() {
        return getPriceExclVAT() * getVAT();
    }
}
