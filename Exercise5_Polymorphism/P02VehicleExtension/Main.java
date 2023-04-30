package Exercise5_Polymorphism.P02VehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);
        Vehicle bus = getVehicle(scanner);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus",bus);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfCommands; i++) {

            String[] input = scanner.nextLine().split("\\s+");

            String command = input[0];
            String vehicleType = input[1];
            double argument = Double.parseDouble(input[2]);

            switch (command) {
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).driveAC(argument));
                    break;
                case "DriveEmpty" :
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    try{
                        vehicleMap.get(vehicleType).refuel(argument);
                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
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
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);

        switch (vehicleType){
            case "Car" :
                return new Car(carFuelQuantity, carFuelConsumption,tankCapacity);
            case "Truck" :
                return  new Truck(carFuelQuantity, carFuelConsumption,tankCapacity);
            case "Bus" :
                return new Bus(carFuelQuantity,carFuelConsumption,tankCapacity);
            default:
                throw new IllegalArgumentException("Missing car");
        }
    }
}