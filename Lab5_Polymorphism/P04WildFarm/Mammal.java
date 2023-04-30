package Lab5_Polymorphism.P04WildFarm;

public abstract class Mammal extends Animal{
    private String livingRegion;
    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);
}
