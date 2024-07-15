package P05AccessModifier;

public class TestCircle {
    public static void main(String[] args) {
        System.out.println("Creat new Circle!");
        Circle c = new Circle();
        System.out.println("Circle's radius: " + c.getRadius());
        System.out.println("Circle's area: " + c.getArea());
        System.out.println();

        System.out.println("Create second circle!");
        Circle c2 = new Circle(2,"blue");
        System.out.println("Circle's radius: " + c2.getRadius());
        System.out.println("Circle's area: " + c2.getArea());

    }
}
