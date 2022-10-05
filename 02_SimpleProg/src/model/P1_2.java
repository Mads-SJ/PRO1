package model;

public class P1_2 {
    public static void main(String[] args) {
        int numberOfWorkDays = 5;
        double distanceToWork = 52.5;
        double totalDistanceTravelled = 837.5;

        double personalDrivingDistance = calculatePersonalDrivingDistance(numberOfWorkDays, distanceToWork, totalDistanceTravelled);
        System.out.println(personalDrivingDistance);
        System.out.println(totalDistanceTravelled - personalDrivingDistance);
    }

    public static double calculatePersonalDrivingDistance(int numberOfWorkDays, double distanceToWork, double totalDistanceTravelled) {
        return totalDistanceTravelled - (distanceToWork * 2) * numberOfWorkDays;
    }
}
