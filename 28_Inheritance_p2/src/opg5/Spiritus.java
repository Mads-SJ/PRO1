package opg5;

public class Spiritus extends Vare {
    private double alcoholPercent;

    public Spiritus(double priceExclVAT, String name, String description, double alcoholPercent) {
        super(priceExclVAT, name, description, 1.8);
        this.alcoholPercent = alcoholPercent;
    }

    @Override
    public double getSalesPrice() {
        double VAT = this.getVAT();

        if (getPriceExclVAT() > 90) {
            VAT = 2.2;
        }
        return getPriceExclVAT() * VAT;
    }
}
