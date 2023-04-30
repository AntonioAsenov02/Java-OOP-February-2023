package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy toy : toys) {
            sum += toy.getSoftness();
        }

        return sum;
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() < this.capacity){
            this.getCats().add(cat);
        }else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        this.getCats().remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.getToys().add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : this.getCats()) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
       StringBuilder builder = new StringBuilder();

       builder.append(String.format("%s %s:%n",this.name,this.getClass().getSimpleName()));
       builder.append("Cats: ");
       if (this.getCats().isEmpty()){
           builder.append("none");
           builder.append(System.lineSeparator());
       }else {
           builder.append(this.getCats().stream().map(Cat::getName).collect(Collectors.joining(" ")).trim());
           builder.append(System.lineSeparator());
       }
       builder.append(String.format("Toys: %d ",this.getToys().size()));
       builder.append(String.format("Softness: %d",this.sumSoftness()));

       return builder.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
