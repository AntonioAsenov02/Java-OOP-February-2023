package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrder;
    private Collection<Cocktail> cocktailOrder;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrder = new ArrayList<>();
        this.cocktailOrder = new ArrayList<>();
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.price = 0;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.price = pricePerPerson * numberOfPeople;
        isReserved = true;

    }

    @Override
    public double getBill() {
        double cocktailsPrice = 0;
        for (Cocktail cocktail : cocktailOrder) {
            cocktailsPrice += cocktail.getPrice();
        }

        double delicaciesPrice = 0;
        for (Delicacy delicacy : delicacyOrder) {
            delicaciesPrice += delicacy.getPrice();
        }

        return cocktailsPrice + delicaciesPrice;
    }

    @Override
    public void clear() {
        this.isReserved = false;
        cocktailOrder.clear();
        delicacyOrder.clear();
        setNumberOfPeople(0);
        this.price = 0;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
       if (numberOfPeople <= 0){
           throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
       }
       this.numberOfPeople = numberOfPeople;
    }
}
