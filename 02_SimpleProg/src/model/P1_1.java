package model;

public class P1_1 {
    public static void main(String[] args) {
        double trainTicketPrice = 43;
        double distanceToWork = 50;
        double fuelEfficiency = 5; // miles pr gallon

        System.out.println(isTrainCheaper(trainTicketPrice, distanceToWork, fuelEfficiency));
    }

    public static boolean isTrainCheaper(double trainTicketPrice, double distanceToWork, double fuelEfficiency) {
        int costOfGas = 4;
        double maintenanceCostPrMile = 0.05;

        double drivingCost = distanceToWork / fuelEfficiency * costOfGas + (maintenanceCostPrMile * distanceToWork);

        return drivingCost > trainTicketPrice;
    }


}
