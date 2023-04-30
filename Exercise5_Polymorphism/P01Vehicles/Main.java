package Exercise5_Polymorphism.P01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfCommands; i++) {

            String[] input = scanner.nextLine().split("\\s+");

            String command = input[0];
            String vehicleType = input[1];
            double argument = Double.parseDouble(input[2]);

            switch (command) {
                case "Drive":
                    vehicleMap.get(vehicleType).drive(argument);
                    break;
                case "Refuel":
                    vehicleMap.get(vehicleType).refuel(argument);
                    break;
            }
        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleInfo = scanner.nextLine().split("\\s+");
        String vehicleType = vehicleInfo[0];
        double carFuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double carFuelConsumption = Double.parseDouble(vehicleInfo[2]);

        switch (vehicleType){
            case "Car" :
                return new Car(carFuelQuantity, carFuelConsumption);
            case "Truck" :
                return  new Truck(carFuelQuantity, carFuelConsumption);
            default:
                throw new IllegalArgumentException("Missing car");
        }
    }
}