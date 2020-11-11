package classes;

public class DessertShoppe {
    public static String STORE_NAME = "M & M Dessert Shoppe";
    public static double TAX_RATE = 0.065;
    public static int MARGIN_SPACE_LENGTH = 5;
    public static int LINE_LENGTH = STORE_NAME.length() + 2 * MARGIN_SPACE_LENGTH;

    public static String cents2dollarsAndCents(int inCents) {
        return (inCents / 100 == 0 ? "" : inCents/100) + "." + (inCents % 100 < 10 ? "0" + inCents % 100 : inCents % 100);
    }
}

