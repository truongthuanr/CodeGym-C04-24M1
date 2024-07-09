package P01Loop;


import java.util.Scanner;

public class Geo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        System.out.println("Menu");
        System.out.println("1. Draw the triangle");
        System.out.println("2. Draw the square");
        System.out.println("2. Draw the rectangular");

        choice = sc.nextInt();

        switch(choice){
            case 1:
                drawTriangle();
                break;
            case 2:
                drawSquare();
                break;
            case 3:
                drawRectangle();
                break;
        }
    }

    public static void drawTriangle(){
        System.out.println("Draw the triangle");
        for(int i = 1 ; i <= 5 ; i++){
            for(int j = 5 ; j >= i ; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawSquare(){
        System.out.println("Draw the square");
        for(int i = 1 ; i <= 5 ; i++){
            for(int j = 5 ; j >= 1 ; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawRectangle(){
        System.out.println("Draw the rectangle");
        for(int i = 1 ; i <= 3 ; i++){
            for(int j = 1 ; j <=10 ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


}
