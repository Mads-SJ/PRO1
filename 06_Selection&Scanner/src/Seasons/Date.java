package Seasons;

public class Date {
    private int day;
    private int month;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date(int day, int month) {
        this.day = day;
        this.month = month;
    }

    public String getSeason() {
        String season;

        if(month == 1 || month == 2 || month == 3) {
            season = "Winter";
        }
        else if(month == 4 || month == 5 || month == 6) {
            season = "Spring";
        }
        else if(month == 7 || month == 8 || month == 9) {
            season = "Summer";
        }
        else {
            season = "Fall";
        }

        if(month % 3 == 0 && day >= 21) {
            season = switch (season) {
                case "Winter" -> "Spring";
                case "Spring" -> "Summer";
                case "Summer" -> "Fall";
                default -> "Winter";
            };
        }

        return season;
    }
}
