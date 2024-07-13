package P03ClassObject;

public class QuadEq {
    public static void main(String[] args) {

    }
}

class Quad {
    double a, b, c;
    public Quad() {}
    public Quad(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double getDiscriminant(){
        return b*b - 4*c*a;
    }
}
