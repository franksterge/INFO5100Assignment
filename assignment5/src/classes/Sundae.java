package classes;

public class Sundae extends IceCream {
    private String toppingName;
    private int toppingPriceInCents;

    public Sundae(String toppingName, int toppingPriceInCents, String name, int price) {
        super(name, price);
        this.toppingName = toppingName;
        this.toppingPriceInCents = toppingPriceInCents;
    }

    @Override
    public int getCost() {
        return this.price + this.toppingPriceInCents;
    }

    @Override
    public String toString() {
        String price = DessertShoppe.cents2dollarsAndCents(this.getCost());
        String result = DessertItem.formatItemName(this.name + " Sundae with", price)
                + "\n" + DessertItem.formatItemName(this.toppingName, price);
        result = DessertItem.attachPrice(result, price);
        return result;
    }
}
