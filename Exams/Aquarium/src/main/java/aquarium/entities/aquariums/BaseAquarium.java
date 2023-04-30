package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void addFish(Fish fish) {

        if (this.fish.size() < capacity){
            this.fish.add(fish);
        }else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : this.fish) {
            fish.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s (%s):",name,this.getClass().getSimpleName())).append(System.lineSeparator());
        if (this.fish.isEmpty()){
            builder.append("Fish: none").append(System.lineSeparator());
        }else {
            String text = this.fish.stream().map(Fish::getName).collect(Collectors.joining(" "));
            builder.append(String.format("Fish: %s",text)).append(System.lineSeparator());
        }

        builder.append(String.format("Decorations: %d",decorations.size())).append(System.lineSeparator());
        builder.append(String.format("Comfort: %d",calculateComfort()));

        return builder.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
