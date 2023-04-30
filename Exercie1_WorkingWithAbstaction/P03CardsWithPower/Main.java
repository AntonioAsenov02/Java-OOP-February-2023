package Exercie1_WorkingWithAbstaction.P03CardsWithPower;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Card card = Card.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());


        int sum = card.getPowerOfRank() + suit.getSuitPower();

        System.out.printf("Card name: %s of %s; Card power: %d%n",card.name(),suit.name(),sum);
    }
}
