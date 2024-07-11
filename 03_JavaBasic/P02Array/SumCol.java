package P02Array;

import java.util.Scanner;

public class SumCol {
    public static void main(String[] args) {
        int n1;
        int n2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of row: ");
        n1 = sc.nextInt();
        System.out.println("Enter the number of column: ");
        n2 = sc.nextInt();

        int[][] arr = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.println("Enter value row "+(i+1)+", column " + (j+1));
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Your input array is: \n");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int col = 0;

        while (true) {

            System.out.println("Column to get Sum (-1 for exit): ");
            col = sc.nextInt();
            if (col == -1) {break;}
            int sum = 0;
            for (int i = 0; i < n1; i++) {
                sum = sum + arr[i][col - 1];
            }
            System.out.println("Sum is: " + sum);

        }



    }
}
