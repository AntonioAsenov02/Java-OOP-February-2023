package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("ShortHouse")){
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        }else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        this.houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")){
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        }else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);

        if (toy == null){
            String exceptionMessage = String.format(ExceptionMessages.NO_TOY_FOUND,toyType);
            throw new IllegalArgumentException(exceptionMessage);
        }
        House house = getHouseByName(houseName);
        house.buyToy(toy);
        this.toys.removeToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    private House getHouseByName(String houseName) {
        return this.houses.stream()
                .filter(house -> house.getName().equals(houseName))
                .findFirst()
                .get();
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;

        switch (catType){
            case "ShorthairCat" :
                cat = new ShorthairCat(catName,catBreed,price);
                break;
            case "LonghairCat" :
                cat = new LonghairCat(catName,catBreed,price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        House house = getHouseByName(houseName);

        boolean checkShort = catType.startsWith("Short") && house.getClass().getSimpleName().startsWith("Short");
        boolean checkLong = catType.startsWith("Long") && house.getClass().getSimpleName().startsWith("Long");

        if (checkShort || checkLong){
            house.addCat(cat);
        }else {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House foundHouse = getHouseByName(houseName);
        foundHouse.feeding();

        return String.format(ConstantMessages.FEEDING_CAT,foundHouse.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House foundHouse = getHouseByName(houseName);

        double sumOfCats = foundHouse.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumOfToys = foundHouse.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double sum = sumOfCats + sumOfToys;

        return String.format(ConstantMessages.VALUE_HOUSE,houseName,sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        for (House house : this.houses) {
            builder.append(house.getStatistics());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
