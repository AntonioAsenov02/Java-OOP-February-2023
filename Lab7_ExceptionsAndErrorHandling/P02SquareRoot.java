package Lab7_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P02SquareRoot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        validNumber(scanner);
    }
    private static void validNumber(Scanner scanner) {
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            if (number < 0){
                System.out.println("Invalid");
            }else {
                double squareRoot = Math.sqrt(number);
                System.out.printf("%.2f%n",squareRoot);
            }
        } catch (NumberFormatException exception){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }
    }
}
