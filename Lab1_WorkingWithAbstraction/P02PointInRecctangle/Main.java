package Lab1_WorkingWithAbstraction.P02PointInRecctangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] indexes = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int bottomLeftX = indexes[0];
        int bottomLeftY = indexes[1];
        int topRightX = indexes[2];
        int topRightY = indexes[3];

        Point bottomLeft = new Point(bottomLeftX,bottomLeftY);
        Point topRight = new Point(topRightX,topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int pointsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= pointsCount; i++) {

            int [] searchedPointArr = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            int searchedX = searchedPointArr[0];
            int searchedY = searchedPointArr[1];

            Point searchedPoint = new Point(searchedX,searchedY);

                System.out.println(rectangle.contains(searchedPoint));

        }
    }
}
