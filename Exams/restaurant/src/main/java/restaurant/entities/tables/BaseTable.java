package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.allPeople = 0;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        if (size < 0){
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    public void setAllPeople(double allPeople) {
        this.allPeople = numberOfPeople * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReservedTable = true;
        setAllPeople(numberOfPeople * pricePerPerson);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double foodSum = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beverageSum = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();

        return foodSum + beverageSum + allPeople;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        isReservedTable = false;
        this.numberOfPeople = 0;
        this.allPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Table - %d",number)).append(System.lineSeparator());
        builder.append(String.format("Size - %d",size)).append(System.lineSeparator());
        builder.append(String.format("Type - %s",this.getClass().getSimpleName())).append(System.lineSeparator());
        builder.append(String.format("All price - %f",pricePerPerson));

        return builder.toString().trim();
    }
}
