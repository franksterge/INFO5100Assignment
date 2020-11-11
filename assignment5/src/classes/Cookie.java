package classes;

public class Cookie extends DessertItem {
    private int number;
    private int pricePerDozenInCents;
    private static double DOZEN_QUANTITY = 12;

    public Cookie(String name, int number, int pricePerDozenInCents) {
        this.name = name;
        this.number = number;
        this.pricePerDozenInCents = pricePerDozenInCents;
    }

    @Override
    public int getCost() {
        return (int) Math.round((double) this.number * (double) this.pricePerDozenInCents / Cookie.DOZEN_QUANTITY);
    }

    @Override
    public String toString() {
        String result = this.number + " @ " + DessertShoppe.cents2dollarsAndCents(this.pricePerDozenInCents) + " /dz.\n";
        result += super.toString();
        return result;
    }
}
