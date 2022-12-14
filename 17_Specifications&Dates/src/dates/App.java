package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class App {
    
    public static void main(String[] args) {
        // Forskellige måder at tildele en LocalDate en værdi
        LocalDate dat1 = LocalDate.now();
        System.out.println(dat1);
        LocalDate dat2 = dat1.plusMonths(3);
        System.out.println(dat2);
        LocalDate dat3 = LocalDate.of(2021, 12, 6);
        System.out.println(dat3);
        System.out.println();
        LocalDate dat4 = LocalDate.parse("2021-10-15");
        System.out.println(dat4);
        System.out.println();
        
        // Varigheden mellem to datoer
        Period per = dat1.until(dat3);
        
        // days er mindre end 31 da det ellers er en måned
        long days = per.getDays();
        
        // months er mindre end 12 da det ellers er et år
        long months = per.getMonths();
        
        long years = per.getYears();
        
        System.out.println(
            "Fra " + dat1 + " til " + dat3 + " er der " + years + " år " + months + " måneder "
                + days + " dage");
        
        months = ChronoUnit.MONTHS.between(dat1, dat3);
        days = ChronoUnit.DAYS.between(dat1, dat3);
        
        System.out.println("Måneder: " + months);
        System.out.println("Dage: " + days);
        System.out.println();
        
        days = ChronoUnit.DAYS.between(dat1, dat1.plusDays(2));
        System.out.println("Dage mellem " + dat1 + " " + dat1.plusDays(2) + " " + days);
        System.out.println();
        LocalTime time1 = LocalTime.of(9, 15);
        System.out.println(time1);
        LocalTime time2 = LocalTime.now();
        System.out.println(time2);
        System.out.println();
        
        LocalDateTime dt = LocalDateTime.of(2021, 11, 3, 10, 15);
        System.out.println(dt.toLocalDate());
        System.out.println(dt.toLocalTime());
        
    }
    
}
