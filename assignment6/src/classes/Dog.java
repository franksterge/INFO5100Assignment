package classes;
import interfaces.Boardable;

public class Dog extends Pet implements Boardable {
    private String size;
    private Date startDate;
    private Date endDate;

    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }

    public String toString() {
        String result = "DOG:\n";
        result += super.toString();
        result += "\nSize: " + this.size;
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
