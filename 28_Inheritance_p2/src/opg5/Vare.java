package opg5;

public abstract class Vare {
    private double priceExclVAT;
    private String name;
    private String description;
    private double VAT;

    public Vare(double priceExclVAT, String name, String description, double VAT) {
        this.priceExclVAT = priceExclVAT;
        this.name = name;
        this.description = description;
        this.VAT = VAT;
    }

    public double getPriceExclVAT() {
        return priceExclVAT;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getVAT() {
        return VAT;
    }

    public abstract double getSalesPrice();

    @Override
    public String toString() {
        return "Vare{" +
                "priceExclVAT=" + priceExclVAT +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", VAT=" + VAT +
                '}';
    }
}
