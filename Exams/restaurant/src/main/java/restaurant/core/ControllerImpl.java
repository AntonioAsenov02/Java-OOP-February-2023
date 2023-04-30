package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalSum;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = healthFoodRepository.foodByName(name);
        if (food != null){
            throw new IllegalArgumentException(String.format(FOOD_EXIST,name));
        }

        switch (type){
            case "Salad" :
                food = new Salad(name,price);
                break;
            case "VeganBiscuits" :
                food = new VeganBiscuits(name,price);
                break;
            }

        healthFoodRepository.add(food);

        return String.format(FOOD_ADDED,name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages beverage = this.beverageRepository.beverageByName(name,brand);
        if (beverageRepository.beverageByName(name,brand) != null){
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST,name));
        }else {
            switch (type){
                case "Smoothie" :
                    beverage = new Smoothie(name,counter,brand);
                    break;
                case "Fresh" :
                    beverage = new Fresh(name,counter,brand);
                    break;
            }
        }

        beverageRepository.add(beverage);

        return String.format(BEVERAGE_ADDED,type,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;

            switch (type){
                case "Indoors" :
                    table = new Indoors(tableNumber,capacity);
                    break;
                case "InGarden" :
                    table = new InGarden(tableNumber,capacity);
                    break;
            }

        if(tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED,tableNumber));
        }else {
            tableRepository.add(table);
        }

        return String.format(TABLE_ADDED,tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = tableRepository.getAllEntities()
                .stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (table == null){
           return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED,table.getTableNumber(),numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }

        if (food == null){
            return String.format(NONE_EXISTENT_FOOD,healthyFoodName);
        }

        table.orderHealthy(food);

        return String.format(FOOD_ORDER_SUCCESSFUL,healthyFoodName,tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverages = beverageRepository.beverageByName(name,brand);

        if (table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }

        if (beverages == null){
            return String.format(NON_EXISTENT_DRINK,name,brand);
        }

        table.orderBeverages(beverages);

        return String.format(BEVERAGE_ORDER_SUCCESSFUL,name,tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);

        double bill = table.bill();
        totalSum += bill;
        table.clear();

        return String.format(BILL,tableNumber,bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY,totalSum);
    }
}
