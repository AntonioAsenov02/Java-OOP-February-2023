package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutSideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = foodRepository.getByName(name);

        if (food != null){
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }

        switch (type){
            case "Bread" :
                food = new Bread(name,price);
                break;
            case "Cake" :
                food = new Cake(name,price);
                break;
        }

        foodRepository.add(food);

        return String.format(FOOD_ADDED,name,type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = this.drinkRepository.getByNameAndBrand(name,brand);

        if (drink != null){
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }

        switch (type){
            case "Tea" :
                drink = new Tea(name,portion,brand);
                break;
            case "Water" :
                drink = new Water(name,portion,brand);
                break;
        }

        this.drinkRepository.add(drink);

        return String.format(DRINK_ADDED,name,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tableRepository.getByNumber(tableNumber);

        if (table != null){
            throw new IllegalArgumentException(String.format(TABLE_EXIST,tableNumber));
        }

        switch (type){
            case "InsideTable" :
                table = new InsideTable(tableNumber,capacity);
                break;
            case "OutsideTable" :
                table = new OutSideTable(tableNumber,capacity);
                break;
        }

        this.tableRepository.add(table);

        return String.format(TABLE_ADDED,tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = this.tableRepository.getAll()
                .stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        String result;
        if (table == null){
            result = String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
        }else {
            table.reserve(numberOfPeople);
            result = String.format(TABLE_RESERVED,table.getTableNumber(),numberOfPeople);
        }

        return result;
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = this.tableRepository.getByNumber(tableNumber);

        if (table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }

        BakedFood food = this.foodRepository.getByName(foodName);

        if (food == null){
            return String.format(NONE_EXISTENT_FOOD,foodName);
        }

        table.orderFood(food);

        return String.format(FOOD_ORDER_SUCCESSFUL,tableNumber,foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = this.tableRepository.getByNumber(tableNumber);

        if (table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }

        Drink drink = this.drinkRepository.getByNameAndBrand(drinkName,drinkBrand);

        if (drink == null){
            return String.format(NON_EXISTENT_DRINK,drinkName,drinkBrand);
        }

        table.orderDrink(drink);

        return String.format(DRINK_ORDER_SUCCESSFUL,tableNumber,drinkName,drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        totalIncome += bill;
        table.clear();

        return String.format(BILL,tableNumber,bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();
        for (Table table : this.tableRepository.getAll()) {
            if (!table.isReserved()){
                builder.append(table.getFreeTableInfo()).append(System.lineSeparator());
            }
        }

        return builder.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME,this.totalIncome);
    }
}
