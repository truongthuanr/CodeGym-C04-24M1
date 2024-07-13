package P03ClassObject;

import java.util.Scanner;

public class QuadEq {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the a: ");
        a = sc.nextDouble();
        System.out.println("Enter the b: ");
        b = sc.nextDouble();
        System.out.println("Enter the c: ");
        c = sc.nextDouble();
        Quad eq =new Quad(a,b,c);
        System.out.printf("%.2f*^2 + %.2f*x + %.2f = 0%n", a, b, c);
        eq.solve();
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
        return this.b*this.b - 4*this.c*this.a;
    }
    public void solve(){
        double disc = getDiscriminant();
        if(disc == 0){
            System.out.println("The only real root: " + (-this.b/(2*this.a)));
        } else if (disc < 0) {
            System.out.println("No real root");
        } else if (disc > 0) {
            System.out.println("First Real Root: "+((-this.b-Math.pow(disc,0.5))/(2*this.a)));
            System.out.println("Second Real Root: "+((-this.b+Math.pow(disc,0.5))/(2*this.a)));
        }

    }
}
