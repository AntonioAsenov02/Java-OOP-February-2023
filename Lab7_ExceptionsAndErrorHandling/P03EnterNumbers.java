package Lab7_ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03EnterNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = new ArrayList<>();
        int start = 1;
        int end = 100;

        isValidNumber(scanner,start,end,numbersList);
    }
    public static void isValidNumber(Scanner scanner,int start,int end,List<Integer> numbersList) {

        int count = 0;
        for (;;) {

            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number > start && number < end) {
                    start = number;
                    count++;
                    if (count <= 10){
                        numbersList.add(number);
                    }
                    if (count == 10){
                        int counter = 0;
                        for (Integer num : numbersList) {
                            counter++;
                            if (counter < 10){
                                System.out.print(num + ", ");

                            }else {
                                System.out.print(num);
                            }
                        }
                        return;
                    }
                }else {
                    System.out.printf("Your number is not in range %d - %d!%n",start,end);
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid Number!");
            }
        }
    }
}
