package classes;

public class Candy extends DessertItem{
    private double weightInLb;
    private int priceInCents;

    public Candy(String name, double weightInLb, int priceInCents) {
        this.name = name;
        this.weightInLb = weightInLb;
        this.priceInCents = priceInCents;
    }

    @Override
    public int getCost() {
        return (int) Math.round(weightInLb * priceInCents);
    }

    @Override
    public String toString() {
        String result = (this.weightInLb * 100 % 10 == 0 ? this.weightInLb + "0" : this.weightInLb)
                + " lbs. @ " + DessertShoppe.cents2dollarsAndCents(this.priceInCents) + " /lb.";
        result += "\n" + super.toString();
        return result;
    }
}
