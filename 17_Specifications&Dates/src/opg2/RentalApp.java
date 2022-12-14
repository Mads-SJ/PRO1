package opg2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {
    public static void main(String[] args) {
        Rental r1 = new Rental(1, 10, LocalDate.of(2022, 11, 1), 1000.0);
        Rental r2 = new Rental(1, 10, LocalDate.now().plusMonths(10), 1000.0);

        System.out.println(r2.getStartDate());
        System.out.println(r1.getTotalPrice());
        System.out.println(r1.getEndDate());
        System.out.println(r1.getStartDate().minusDays(1));

        System.out.println(r2.getTotalPrice());
        System.out.println(r2.getEndDate());
        System.out.println(r2.getStartDate().minusDays(1));

        Period p = r1.getStartDate().until(r2.getStartDate());
        System.out.println(p.getYears() + " " + p.getMonths() + " " + p.getDays());

        long days = ChronoUnit.DAYS.between(r1.getStartDate(), r2.getStartDate());
        System.out.println(days);
    }
}
