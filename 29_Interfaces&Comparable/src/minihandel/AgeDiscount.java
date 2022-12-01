package minihandel;

import java.time.LocalDate;

public class AgeDiscount implements Discount{
    private int birthYear;

    public AgeDiscount(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public double getDiscount(double price) {
        return price * (LocalDate.now().getYear() - birthYear) / 100.0;
    }
}
