package classes;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public Date(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Date o) {
        if (this.year == o.year) {
            if (this.month == o.month) {
                return this.day - o.day;
            }
            return this.month - o.month;
        }
        return this.year - o.year;
    }
}
