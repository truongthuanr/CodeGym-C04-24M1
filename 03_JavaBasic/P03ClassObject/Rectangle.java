package P03ClassObject;

import java.util.Scanner;

public class Rectangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the width of the rectangle: ");
        double w = sc.nextDouble();
        System.out.println("Enter the height of the rectangle: ");
        double h = sc.nextDouble();
        Rect r = new Rect(w, h);
        System.out.println("Your rectangle is: " + r.display());
        System.out.println("The area of the rectangle is " + r.getArea());
        System.out.println("The perimeter of the rectangle is " + r.getPerimeter());
        System.out.println("Your rectangle is: " + r.display());
        System.out.println("Change rectangle width to: ");
        r.width = sc.nextDouble();
        System.out.println("Change rectangle height to: ");
        r.height = sc.nextDouble();
        System.out.println("New rectangle dimension is: " + r.display());
        System.out.println("New area of the rectangle is: " + r.getArea());
        System.out.println("New perimeter of the rectangle is: " + r.getPerimeter());


    }

}

class Rect {
    double width, height;

    public Rect() {}

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height)*2;
    }

    public String display() {
        return String.format("Rectangle width: %.2f height: %.2f", width, height);
    }
}
