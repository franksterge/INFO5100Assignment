package classes;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {}

    public Cylinder(double height) {
        this.setHeight(height);
    }

    public Cylinder(double height, double radius) {
        this(height);
        this.setRadius(radius);
    }

    public Cylinder(double height, double radius, String color) {
        this(height, radius);
        this.setColor(color);
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return this.getHeight() * super.getArea();
    }

    @Override
    public double getArea() {
        double radius = this.getRadius();
        return 2.0 * Math.PI * radius * (radius + this.getHeight());
    }

    @Override
    public String toString() {
        return "Radius is " + this.getRadius()
                + ", Height is " + this.getHeight()
                + ", Color is " + this.getColor()
                + ", Base area is " + this.getArea()
                + ", Volume is " + this.getVolume();
    }
}
