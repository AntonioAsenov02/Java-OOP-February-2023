package Lab5_Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        builder.append(String.format("%s[%s, %s, %s, %d]",getAnimalType(),getAnimalName(),
                df.format(getAnimalWeight()),getLivingRegion(),getFoodEaten()));
        return builder.toString();
    }
}

