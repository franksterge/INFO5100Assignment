package classes;
import interfaces.Boardable;

public class Cat extends Pet implements Boardable {
    private String hairLength;
    private Date startDate;
    private Date endDate;

    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return this.hairLength;
    }

    @Override
    public String toString() {
        String result = "CAT:\n";
        result += super.toString();
        result += "\nHair: " + this.hairLength;
        return result;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.startDate = new Date(month, day, year);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.endDate = new Date(month, day, year);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Date boardingDate = new Date(month, day, year);
        return boardingDate.compareTo(this.startDate) >= 0 && boardingDate.compareTo(this.endDate) <= 0;
    }
}
