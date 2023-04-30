package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;


public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }


    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType){
            case "FreshwaterAquarium" :
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium" :
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE,aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type){
            case "Ornament" :
                decoration = new Ornament();
                break;
            case "Plant" :
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        decorations.add(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE,type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium aquarium = aquariums.stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .get();

        Decoration decoration = decorations.findByType(decorationType);

        if (decoration == null){
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND,decorationType));
        }

        aquarium.getDecorations().add(decoration);
        decorations.remove(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM,decorationType,aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = aquariums.stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .get();

        Fish fish;
        switch (fishType){
            case "FreshwaterFish" :
                fish = new FreshwaterFish(fishName,fishSpecies,price);
                break;
            case "SaltwaterFish" :
                fish = new SaltwaterFish(fishName,fishSpecies,price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        if (aquarium.getFish().size() >= aquarium.getCapacity()){
            return String.format(NOT_ENOUGH_CAPACITY);
        }

        if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium") && fishType.equals("FreshwaterFish")){
            aquarium.getFish().add(fish);
        } else if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") && fishType.equals("SaltwaterFish")) {
            aquarium.getFish().add(fish);
        }else {
            return String.format(WATER_NOT_SUITABLE);
        }

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType,aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .get();

        for (Fish fish : aquarium.getFish()) {
            fish.eat();
        }

        return String.format(FISH_FED,aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .get();

        double decorationsPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double fishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();

        double totalValue = decorationsPrice + fishPrice;

        return String.format(VALUE_AQUARIUM,aquariumName,totalValue);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();

        for (Aquarium aquarium : aquariums) {
            builder.append(aquarium.getInfo()).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
