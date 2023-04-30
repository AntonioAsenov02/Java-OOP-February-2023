package Lab5_Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }
    void setFoodEaten(Integer foodEaten){
        this.foodEaten = foodEaten;
    }
    abstract void makeSound();
    abstract void eat(Food food);

    protected String getAnimalName() {
        return animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        builder.append(String.format("%s[%s,%s,%d]",animalType,animalName,df.format(animalWeight),foodEaten));
        return builder.toString();
    }
}
