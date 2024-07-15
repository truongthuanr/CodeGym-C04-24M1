package P05AccessModifier;

public class Car {
    private String name;
    private String engine;
    public static int noOfCar;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        noOfCar++;
    }
}
