package main;

import classes.Circle;
import classes.Cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        //Constructed a Circle with Circle()
        //Run of the program should produce the following output:
        //Radius is 2.0, Color is yellow, Base area is (your answer)

        Circle circle1 = new Circle(2.0, "yellow");
        System.out.println(circle1);

        //Constructed a Cylinder with Cylinder()
        //Run of the program should produce the following output:
        //Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)

        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1);
        //Constructed a Cylinder with Cylinder(height, radius)
        //Run of the program should produce the following output:
        //Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)

        Cylinder cylinder2 = new Cylinder(5.0, 2.0, "red");
        System.out.println(cylinder2);
    }
}
