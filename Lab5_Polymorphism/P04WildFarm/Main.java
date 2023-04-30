package Lab5_Polymorphism.P04WildFarm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Mammal mammal = null;
        String command = scanner.nextLine();
        int row = 0;
        while (!command.equals("End")){


            if (row % 2 == 0){
                String [] animalInfo = command.split("\\s+");

                String animalType = animalInfo[0];
                String animalName = animalInfo[1];
                Double animalWeight = Double.parseDouble(animalInfo[2]);
                String animalLivingRegion = animalInfo[3];

                switch (animalType){
                    case "Mouse" :
                        mammal = new Mouse(animalName,animalType,animalWeight,animalLivingRegion);
                        break;
                    case "Zebra" :
                        mammal = new Zebra(animalName,animalType,animalWeight,animalLivingRegion);
                        break;
                    case "Cat" :
                        String catBreed = animalInfo[4];
                        mammal = new Cat(animalName,animalType,animalWeight,animalLivingRegion,catBreed);
                        break;
                    case "Tiger" :
                        mammal = new Tiger(animalName,animalType,animalWeight,animalLivingRegion);
                        break;
                }

            }else {

                String [] foodInfo = command.split("\\s+");

                String foodType = foodInfo[0];
                Integer quantity = Integer.parseInt(foodInfo[1]);

                switch (mammal.getAnimalType()){
                    case "Mouse" :
                    case "Zebra" :
                        mammal.makeSound();
                        if (!foodType.equals("Vegetable")){
                            System.out.printf("%s are not eating that type of food!%n",mammal.getAnimalType() + "s");
                            System.out.println(mammal);
                        }else {
                            mammal.setFoodEaten(quantity);
                            System.out.println(mammal);
                        }
                        break;
                    case "Cat" :
                        mammal.makeSound();
                        mammal.setFoodEaten(quantity);
                        System.out.println(mammal);
                        break;
                    case "Tiger" :
                        mammal.makeSound();
                        if (!foodType.equals("Meat")){
                            System.out.printf("%s are not eating that type of food!%n",mammal.getAnimalType() + "s");
                            System.out.println(mammal);
                        }else {
                            mammal.setFoodEaten(quantity);
                            System.out.println(mammal);
                        }
                        break;
                }
            }
            row++;
            command = scanner.nextLine();
        }
    }
}
