package football.entities.player;

public class Men extends BasePlayer {
    private static final double MEN_KG = 85.50;
    public Men(String name, String nationality, int strength) {
        super(name, nationality, MEN_KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(this.getStrength() + 145);
    }
}
