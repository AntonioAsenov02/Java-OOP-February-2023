package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;

public class ControllerImpl implements Controller{
    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    private int inspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind){
            case "Archaeologist" :
                discoverer = new Archaeologist(discovererName);
                break;
            case "Anthropologist" :
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist" :
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        discovererRepository.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED,kind,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
       Spot spot = new SpotImpl(spotName);
       Collections.addAll(spot.getExhibits(),exhibits);
       spotRepository.add(spot);

       return String.format(ConstantMessages.SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer foundDiscoverer = discovererRepository.byName(discovererName);

        if (foundDiscoverer == null){
            String exceptionMessage = String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST,discovererName);
            throw new IllegalArgumentException(exceptionMessage);
        }

        discovererRepository.remove(foundDiscoverer);

        return String.format(ConstantMessages.DISCOVERER_EXCLUDE,discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> validDiscoverers = discovererRepository.getCollection()
                .stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());

        if (validDiscoverers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot inspectedSpot = this.spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(inspectedSpot,validDiscoverers);

        long countOfExcludedDiscoverers = validDiscoverers.stream().filter(d -> d.getEnergy() == 0).count();

        inspectedSpots++;

        return String.format(ConstantMessages.INSPECT_SPOT,spotName,countOfExcludedDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT,inspectedSpots));
        builder.append(System.lineSeparator());
        builder.append(ConstantMessages.FINAL_DISCOVERER_INFO);

        for (Discoverer discoverer : discovererRepository.getCollection()) {
            builder.append(System.lineSeparator());
            builder.append(String.format(FINAL_DISCOVERER_NAME,discoverer.getName())).append(System.lineSeparator());
            builder.append(String.format(FINAL_DISCOVERER_ENERGY,discoverer.getEnergy())).append(System.lineSeparator());
            if (discoverer.getMuseum().getExhibits().isEmpty()){
                builder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,"None"));
            }else {
                builder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,discoverer.getMuseum().getExhibits())));
            }
        }

        return builder.toString().trim();
    }
}
