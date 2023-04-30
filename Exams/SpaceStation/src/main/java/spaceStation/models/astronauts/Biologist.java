package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double BIOLOGIST_OXYGEN = 70;
    public Biologist(String name) {
        super(name, BIOLOGIST_OXYGEN);
    }

    @Override
    public void breath() {
        setOxygen(Math.max(this.getOxygen() - 5, 0));
    }
}
