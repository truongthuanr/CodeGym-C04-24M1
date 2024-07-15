package P05AccessModifier;

public class MainCar {
    public static void main(String[] args) {
        Car c1 = new Car("Mazda 3", "Skyactiv3" );
        System.out.println(Car.noOfCar);
        Car c2 = new Car("Mazda 6", "Skyactiv6" );
        System.out.println(Car.noOfCar);
    }
}
