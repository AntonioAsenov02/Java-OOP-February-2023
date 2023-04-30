package Lab1_WorkingWithAbstraction.P03students;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String[] input = getInput(scanner);
        while (!input[0].equals("Exit")) {
            studentSystem.ParseCommand(input);
            input = getInput(scanner);
        }
    }
    private static String[] getInput(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
