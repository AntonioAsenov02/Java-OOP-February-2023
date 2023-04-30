package Lab1_WorkingWithAbstraction;

import java.util.Scanner;

public class P01RhombusOfStars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printUpperPart(n);
        printRow(n,n);
        printLowerPart(n);
    }

    private static void printLowerPart(int n) {
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printUpperPart(int n) {
        for (int row = 1; row <= n -1 ; row++) {
            printRow(n,row);
        }
    }

    public static void printRow(int n, int row){
        for (int space = 1; space <= n - row ; space++) {
            System.out.print(" ");
        }
        for (int star = 1; star <= row ; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
