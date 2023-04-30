package Lab5_Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion,String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound(){
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        builder.append(String.format("%s[%s, %s, %s, %s, %d]",getAnimalType(),getAnimalName(),this.breed,
                df.format(getAnimalWeight()),getLivingRegion(),getFoodEaten()));
        return builder.toString();
    }
}
