package opg5;

public class ElArtikel extends Vare {
    private double avgEnergyConsumptionHr;

    public ElArtikel(double priceExclVAT, String name, String description, double avgEnergyConsumptionHr) {
        super(priceExclVAT, name, description, 1.3);
        this.avgEnergyConsumptionHr = avgEnergyConsumptionHr;
    }

    @Override
    public double getSalesPrice() {
        double priceInclVAT = getPriceExclVAT() * getVAT();

        if (priceInclVAT < 3) {
            priceInclVAT = 3;
        }
        return priceInclVAT;
    }
}
