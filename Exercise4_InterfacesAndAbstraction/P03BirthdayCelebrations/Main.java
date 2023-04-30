package Exercise4_InterfacesAndAbstraction.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){

            String [] inputArr = input.split("\\s+");

            Birthable birthable;
            String object = inputArr[0];

            switch (object){
                case "Citizen" :
                    String name = inputArr[1];
                    int age = Integer.parseInt(inputArr[2]);
                    String id = inputArr[3];
                    String birthDate = inputArr[4];

                    birthable = new Citizen(name,age,id,birthDate);
                    birthables.add(birthable);
                    break;
                case "Pet" :
                    String petName = inputArr[1];
                    String petBirthDate = inputArr[2];

                    birthable = new Pet(petName,petBirthDate);
                    birthables.add(birthable);
                    break;
                case "Robot" :
                    String model = inputArr[1];
                    String robotId = inputArr[2];
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        birthables.stream()
                .map(Birthable::getBirthDate)
                .filter(b -> b.endsWith(year))
                .forEach(System.out::println);
    }
}
