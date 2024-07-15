package P05AccessModifier;

public class Student {
    private int rollno;
    private String name;
    private String classes = "A";

    private static String college = "BBDIT";
    static void change() {
        college = "CODEGYM";
    }



    Student(int r, String n) {
        rollno = r;
        name = n;
    }
    Student() {
        name = "John";
        classes = "C02";

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

    void display1() {
        System.out.println("Student's name is " + name + ", Classes: " + classes);
    }

}
