package P05AccessModifier;

public class TestStudent {
    public static void main(String[] args){

        System.out.println("Create new Student!");
        Student s1 = new Student();
        s1.display1();

        System.out.println("Change Student Info!");
        s1.setName("Nguyen Van A");
        s1.setClasses("Python01");
        s1.display1();

    }
}
