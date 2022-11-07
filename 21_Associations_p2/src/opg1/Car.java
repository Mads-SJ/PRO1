package opg1;

import java.util.ArrayList;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private final ArrayList<Rental> rentals;

    public Car(String license, int purchaseYear) {
        this.license = license;
        this.purchaseYear = purchaseYear;
        rentals = new ArrayList<>();
    }

    public void setDayPrice(double price) {
        pricePerDay = price;
    }

    public double getDayPrice() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public ArrayList<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public void addRental(Rental rental) {
        if (!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental(Rental rental) {
        if (rentals.contains(rental)) {
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    public int highestRentalDays() {
        int highestRentalDays = 0;

        for (Rental r : rentals) {
            int days = r.getDays();
            if (days > highestRentalDays) {
                highestRentalDays = days;
            }
        }

        return highestRentalDays;
    }
}
