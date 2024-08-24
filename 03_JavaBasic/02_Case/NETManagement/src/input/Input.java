package input;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);


    public static int InputNumber(){
        do {
            try {
                String input = sc.nextLine();
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e){
                System.out.println("Please enter a number");
            }
        } while (true);
    }

    public static String InputString(){
        String datainput = sc.nextLine();
        return datainput;
    }
}
