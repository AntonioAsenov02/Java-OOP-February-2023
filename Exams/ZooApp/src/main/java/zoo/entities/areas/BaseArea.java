package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
       return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() == this.capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s (%s):",this.name,this.getClass().getSimpleName()));
        builder.append(System.lineSeparator());
        builder.append("Animals: ");
        if (animals.isEmpty()){
            builder.append("none");
            builder.append(System.lineSeparator());
        }else {
            builder.append(animals.stream().map(Animal::getName).collect(Collectors.joining(" ")));
            builder.append(System.lineSeparator());
        }
        builder.append(String.format("Foods: %d",foods.size()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Calories: %d",sumCalories()));

        return builder.toString().trim();
    }
}
