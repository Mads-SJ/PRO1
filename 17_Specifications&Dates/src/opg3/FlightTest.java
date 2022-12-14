package opg3;

import java.time.LocalDateTime;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);

        flight.setDepartDate(LocalDateTime.of(2022,12,24,10,15));
        flight.setArrivalDate(LocalDateTime.of(2022,12,24,12,0));

        System.out.println(flight.averageAgeOfPassengers());
        System.out.println(flight.flightDurationInHours());
        System.out.println(flight.midnightFlight());
    }

}
