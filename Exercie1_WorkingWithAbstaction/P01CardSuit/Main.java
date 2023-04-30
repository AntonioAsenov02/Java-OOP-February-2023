package Exercie1_WorkingWithAbstaction.P01CardSuit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(input + ":");

        for (CardSuit cardSuit : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",cardSuit.ordinal(),cardSuit.name());
        }
    }
}
