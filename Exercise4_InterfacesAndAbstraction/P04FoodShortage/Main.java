package Exercise4_InterfacesAndAbstraction.P04FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        String [] inputArr = scanner.nextLine().split("\\s+");

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {

            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);
            if (inputArr.length == 4){

                 String id = inputArr[2];
                 String birthDate = inputArr[3];

                 Citizen citizen = new Citizen(name,age,id,birthDate);
                 citizens.add(citizen);
            }else {

                String group = inputArr[2];
                Rebel rebel = new Rebel(name,age,group);
                rebels.add(rebel);
            }
            if (i < numberOfPeople -1){
                inputArr = scanner.nextLine().split("\\s+");
            }

        }
        String person = scanner.nextLine();
        while (!person.equals("End")) {

                for (Citizen citizen : citizens) {

                    if (citizen.getName().equals(person)){
                        citizen.buyFood();
                    }
                }

            for (Rebel rebel : rebels) {

                if (rebel.getName().equals(person)){
                    rebel.buyFood();
                }
            }
            person = scanner.nextLine();
        }
        int citizenFoodBought = 0;
        int rebelsFoodBought = 0;

        for (Citizen citizen : citizens) {

                citizenFoodBought += citizen.getFood();
        }

        for (Rebel rebel : rebels) {

            rebelsFoodBought += rebel.getFood();
        }

        System.out.println(citizenFoodBought + rebelsFoodBought);
    }
}
