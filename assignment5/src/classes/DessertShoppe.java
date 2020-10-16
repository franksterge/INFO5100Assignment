package classes;

public class DessertShoppe {
    static String STORE_NAME = "M & M Dessert Shoppe";
    static double TAX_RATE = 0.065;
    static int LEADING_SPACE_LENGTH = 5;
    static int LINE_LENGTH = STORE_NAME.length() + 2 * LEADING_SPACE_LENGTH;

    public static String cents2dollarsAndCents(int inCents) {
        return (inCents / 100 == 0 ? "" : inCents/100) + "." + (inCents % 100 < 10 ? "0" + inCents % 100 : inCents % 100);
    }
}

