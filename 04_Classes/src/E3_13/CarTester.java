package E3_13;

public class CarTester {
    public static void main(String[] args) {
        Car car = new Car(8.8);
        System.out.println("Expected gas in tank: 0, is: " + car.getGasInTank());
        car.addGas(13.2);
        System.out.println("");
        System.out.println("Expected gas in tank: 13.2, is: " + car.getGasInTank());
        car.drive(34.6);
        System.out.println("Expected gas in tank: 9.27, is: " + car.getGasInTank());
    }
}
