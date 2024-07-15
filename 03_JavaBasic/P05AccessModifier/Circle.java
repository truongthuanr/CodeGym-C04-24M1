package P05AccessModifier;

public class Circle {
    private double radius;
    private String color;

    Circle() {
        radius = 1.0;
        color = "red";
    }
    Circle(double radius){
        this.radius = radius;
        color = "red";
    }

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;

    }

    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
