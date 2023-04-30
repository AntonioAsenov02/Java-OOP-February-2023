package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private static final double GEODESIST_OXYGEN = 50;
    public Geodesist(String name) {
        super(name, GEODESIST_OXYGEN);
    }
}
