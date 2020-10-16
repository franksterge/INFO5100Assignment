package main;
import classes.*;

public class TestCheckOut {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
        System.out.println("Number of items: " + checkout.numberOfItems());
        System.out.println("Total cost: " + checkout.totalCost());
        System.out.println("Total tax: " + checkout.totalTax());
        System.out.println("Cost + Tax: " + (checkout.totalCost() + checkout.totalTax()));
        System.out.println(checkout);
        System.out.println("============================================");
        checkout.clear();
        checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel",
                50));
        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
        checkout.enterItem(new Candy("Candy Corn", 3.0, 109));
        System.out.println("Number of items: " + checkout.numberOfItems());
        System.out.println("Total cost: " + checkout.totalCost());
        System.out.println("Total tax: " + checkout.totalTax());
        System.out.println("Cost + Tax: " + (checkout.totalCost() + checkout.totalTax()));
        System.out.println(checkout);

//        Test for long item names
        checkout.clear();
        System.out.println("============================================");
        checkout.enterItem(new Sundae("This is a very long topping name with many words and characters and numer 123",
                100,
                "this is a very long name for a Sundae to test how the program work with long names", 400));
        System.out.println(checkout);

        checkout.clear();
        System.out.println("============================================");
        checkout.enterItem(new Cookie("this is a very long name for a Sundae to test how the program work with long names",
                4,
                200));
        System.out.println(checkout);
    }
}
