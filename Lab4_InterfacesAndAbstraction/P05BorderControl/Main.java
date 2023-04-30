package Lab4_InterfacesAndAbstraction.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!input.equals("End")){

            String [] inputArr = input.split("\\s+");

            Identifiable identifiable = null;

            if (inputArr.length == 2){

                String model = inputArr[0];
                String id = inputArr[1];

                identifiable = new Robot(model,id);
            } else if (inputArr.length == 3) {

                String name = inputArr[0];
                int age = Integer.parseInt(inputArr[1]);
                String id = inputArr[2];

                identifiable = new Citizen(name,age,id);
            }

            identifiables.add(identifiable);
            input = scanner.nextLine();
        }
        String fakeId = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeId))
                .forEach(System.out::println);
    }
}
