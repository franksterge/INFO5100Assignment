package classes;

public abstract class DessertItem {
    protected String name;

    public DessertItem(){}

    public DessertItem(String name) {
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public abstract int getCost();

    @Override
    public String toString() {
        String price = DessertShoppe.cents2dollarsAndCents(this.getCost());
        String result = DessertItem.formatItemName(this.name, price);
        result = DessertItem.attachPrice(result, price);
        return result;
    }


    protected static String formatItemName(String itemString, String price) {
        String result = "";
        String[] itemName = itemString.split("\\s+");
        int currentLineLength = 0;
        for (int i = 0; i < itemName.length; i++) {
            if (currentLineLength + itemName[i].length() >=
                    DessertShoppe.LINE_LENGTH - price.length() - DessertShoppe.MARGIN_SPACE_LENGTH) {
                result += "\n";
                currentLineLength = 0;
            }
            result += itemName[i] + " ";
            currentLineLength += itemName[i].length();

        }
        return result;
    }

    protected static String attachPrice(String result, String price) {
        int stringSize = result.length();
        if (result.length() > DessertShoppe.LINE_LENGTH) {
            String[] resultLines = result.split("\n");
            stringSize = resultLines[resultLines.length - 1].length();
        }
        int numOfSpace = DessertShoppe.LINE_LENGTH - stringSize - price.length();
        for (int i = 0; i < numOfSpace; i++) {
            result += " ";
        }
        result += price;
        return result;
    }
}
