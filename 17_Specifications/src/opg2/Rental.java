package opg2;

import java.time.LocalDate;

/**
 * Models a rental.
 */
public class Rental {
    private int number;
    private int days;
    private LocalDate startDate;
    private double price;

    /**
     * Initializes a new rental.
     * @param number the number of the rented object.
     * @param days the number of days of the rental.
     * @param startDate the date the rental begins.
     * @param price the daily price of the rental.
     */
    public Rental(int number, int days, LocalDate startDate, double price) {
        this.number = number;
        this.days = days;
        this.startDate = startDate;
        this.price = price;
    }

    /**
     * @return the daily price of the rental.
     */
    public double getPricePrDay() {
        return price;
    }

    /**
     * @return the number of days of the rental.
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets the number of days of the rental.
     * @param days the number of days.
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * @return the starting date of the rental.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Returns the end date calculated from the start date and the number of days.
     * @return the end date of the rental.
     */
    public LocalDate getEndDate() {
        return startDate.plusDays(days);
    }

    /**
     * @return the total price of the rental.
     */
    public double getTotalPrice() {
        return price * days;
    }
}
