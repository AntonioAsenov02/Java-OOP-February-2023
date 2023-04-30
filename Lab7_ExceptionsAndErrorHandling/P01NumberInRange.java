package Lab7_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P01NumberInRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");
        int startRange = Integer.parseInt(range[0]);
        int endRange = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]%n", startRange, endRange);

        int validNumber = readNumber(scanner, startRange, endRange);
        System.out.printf("Valid number: %d%n", validNumber);
    }

    private static int readNumber(Scanner scanner, int startRange, int endRange) {

        for (;;){
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= startRange && number <= endRange) {
                    return number;
                }

            } catch (NumberFormatException exception) {
            }
            System.out.println("Invalid number: " + input);
        }
    }
}
