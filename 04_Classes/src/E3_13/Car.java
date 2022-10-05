package E3_13;

public class Car {
    private final double fuelEfficiency;
    private double gas;

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
        gas = 0;
    }

    public void drive(double distance) {
        gas -= distance / fuelEfficiency;
    }

    public double getGasInTank() {
        return gas;
    }

    public void addGas(double amount) {
        gas += amount;
    }
}
