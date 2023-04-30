package Exercie1_WorkingWithAbstaction.P04TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] colorsArr = scanner.nextLine().split("\\s+");
        int numberOfTimes = Integer.parseInt(scanner.nextLine());

        List<TrafficLights> trafficLights = Arrays.stream(colorsArr)
                .map(Color::valueOf)
                .map(TrafficLights::new)
                .collect(Collectors.toList());

        for (int i = 0; i < numberOfTimes; i++) {
            for (TrafficLights trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
