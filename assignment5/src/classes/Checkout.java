package classes;
import java.util.ArrayList;

public class Checkout {
    private ArrayList<DessertItem> checkoutItems;

    public Checkout() {
        this.checkoutItems = new ArrayList<>();
    }

    public int numberOfItems() {
        return this.checkoutItems.size();
    }

    public void enterItem(DessertItem item) {
        this.checkoutItems.add(item);
    }

    public void clear() {
        this.checkoutItems = new ArrayList<>();
    }

    public int totalCost() {
        int cost = 0;
        for (DessertItem d: this.checkoutItems) {
            cost += d.getCost();
        }
        return cost;
    }

    public int totalTax() {
        return (int) Math.round(this.totalCost() * DessertShoppe.TAX_RATE);
    }

    @Override
    public String toString() {
        String result = this.getCheckoutHeader() + "\n";
        for (DessertItem item: this.checkoutItems) {
            result += item.toString() + "\n";
        }
        result += "\n" + getFooter();
        return result;
    }

    private String getCheckoutHeader() {
        String result = "";
        String dividingLine = "";
        for (int i = 0; i < DessertShoppe.LEADING_SPACE_LENGTH; i++) {
            result += " ";
            dividingLine += " ";
        }
        result += DessertShoppe.STORE_NAME + "\n";
        for (int i = 0; i < DessertShoppe.STORE_NAME.length(); i++) {
            dividingLine += "-";
        }
        result += dividingLine + "\n";
        return result;
    }

    private String getFooter() {
        String result = "Tax";
        String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());
        String totalCost = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());
        result = DessertItem.attachPrice(result, tax) + "\n";
        result += DessertItem.attachPrice("Total Cost", totalCost);
        return result;
    }
}
