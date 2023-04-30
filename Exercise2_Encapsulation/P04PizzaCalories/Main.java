package Exercise2_Encapsulation.P04PizzaCalories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] pizzaArr = scanner.nextLine().split("\\s+");
        String [] doughArr = scanner.nextLine().split("\\s+");

        String pizzaName = pizzaArr[1];
        int numberOfToppings = Integer.parseInt(pizzaArr[2]);

        String flourType = doughArr[1];
        String bakingTechnique = doughArr[2];
        double weightOfDough = Double.parseDouble(doughArr[3]);

        try {
            Pizza pizza = new Pizza(pizzaName,numberOfToppings);
            Dough dough = new Dough(flourType,bakingTechnique,weightOfDough);
            pizza.setDough(dough);

            String input = scanner.nextLine();
            while (!input.equals("END")){

                String [] toppingsArr = input.split("\\s+");

                String toppingType = toppingsArr[1];
                double toppingWeight = Double.parseDouble(toppingsArr[2]);

                Topping topping = new Topping(toppingType,toppingWeight);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }
            System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
