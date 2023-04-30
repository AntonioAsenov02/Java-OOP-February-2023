package Exercie1_WorkingWithAbstaction.P05JadiGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        Field field = new Field(rows,cols);
        Galaxy galaxy1 = new Galaxy(field);

        int[] jedi = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int evilRows = evil[0];
        int evilCols = evil[1];

        galaxy1.moveEvil(evilRows, evilCols);

        int jediRows = jedi[0];
        int jediCols = jedi[1];

        int starsCollected = galaxy1.moveJedi(jediRows, jediCols);

        System.out.println(starsCollected);
    }
}
