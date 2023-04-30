package Exercie1_WorkingWithAbstaction.P02CardRanks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextLine() + ":");
        for (CardRanks cardRanks : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",cardRanks.ordinal(),cardRanks.name());
        }
    }
}
