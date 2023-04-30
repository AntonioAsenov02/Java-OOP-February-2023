package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.BaseDelicacy;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.BoothRepositoryImpl;
import christmasPastryShop.repositories.CocktailRepositoryImpl;
import christmasPastryShop.repositories.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;
    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        delicacyRepository = new DelicacyRepositoryImpl();
        cocktailRepository = new CocktailRepositoryImpl();
        boothRepository = new BoothRepositoryImpl();
        totalIncome = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);
        if (delicacy != null){
            String exceptionMessage = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,type,name);
            throw new IllegalArgumentException(exceptionMessage);
        }else {
            switch (type){
                case "Gingerbread" :
                    delicacy = new Gingerbread(name,price);
                    break;
                case "Stolen" :
                    delicacy = new Stolen(name,price);
                    break;
            }
        }
        delicacyRepository.add(delicacy);

        return String.format(DELICACY_ADDED,name,type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);
        if (cocktail != null){
            String exceptionMessage = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,type,name);
            throw new IllegalArgumentException(exceptionMessage);
        }else {
            switch (type){
                case "MulledWine" :
                    cocktail = new MulledWine(name,size,brand);
                    break;
                case "Hibernation" :
                    cocktail = new Hibernation(name,size,brand);
                    break;
            }
        }
        cocktailRepository.add(cocktail);

        return String.format(COCKTAIL_ADDED,name,brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
       Booth booth = boothRepository.getByNumber(boothNumber);
       if (booth != null){
           String exceptionMessage = String.format(ExceptionMessages.BOOTH_EXIST,boothNumber);
           throw new IllegalArgumentException(exceptionMessage);
       }else {
           switch (type){
               case "OpenBooth" :
                   booth = new OpenBooth(boothNumber,capacity);
                   break;
               case "PrivateBooth" :
                   booth = new PrivateBooth(boothNumber,capacity);
                   break;
           }
       }
       boothRepository.add(booth);

       return String.format(BOOTH_ADDED,boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        for (Booth booth : boothRepository.getAll()) {
            if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople){
                booth.reserve(numberOfPeople);
                return String.format(BOOTH_RESERVED,booth.getBoothNumber(),numberOfPeople);
            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);

    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        totalIncome += bill;
        booth.clear();

        return String.format(BILL,boothNumber,bill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME,totalIncome);
    }
}
