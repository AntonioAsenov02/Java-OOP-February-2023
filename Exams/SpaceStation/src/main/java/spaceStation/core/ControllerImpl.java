package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository<Astronaut> astronautRepository;
    private PlanetRepository<Planet> planetRepository;
    private int planetsExplored;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository<>();
        this.planetRepository = new PlanetRepository<>();
        this.planetsExplored = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type){
            case "Biologist" :
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist" :
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist" :
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);

        return String.format(ASTRONAUT_ADDED,type,astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }
        this.planetRepository.add(planet);

        return String.format(PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);

        if (astronaut == null){
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST,astronautName));
        }

        astronautRepository.remove(astronaut);

        return String.format(ASTRONAUT_RETIRED,astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);
        List<Astronaut> validAstronauts = astronautRepository.getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (validAstronauts.isEmpty()){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(planet,validAstronauts);
        planetsExplored++;
        long countOfDeadAstronauts = validAstronauts.stream().filter(a -> a.getOxygen() == 0).count();

        return String.format(PLANET_EXPLORED,planetName,countOfDeadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(REPORT_PLANET_EXPLORED,planetsExplored)).append(System.lineSeparator());
        builder.append(String.format(REPORT_ASTRONAUT_INFO)).append(System.lineSeparator());
        for (Astronaut astronaut : astronautRepository.getModels()) {
            builder.append(String.format(REPORT_ASTRONAUT_NAME,astronaut.getName())).append(System.lineSeparator());
            builder.append(String.format(REPORT_ASTRONAUT_OXYGEN,astronaut.getOxygen())).append(System.lineSeparator());
            if (astronaut.getBag().getItems().isEmpty()){
                builder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,"none")).append(System.lineSeparator());
            }else {
                String items = String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());
                builder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,items)).append(System.lineSeparator());
            }
        }

        return builder.toString().trim();
    }
}
