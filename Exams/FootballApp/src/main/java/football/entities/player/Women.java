package football.entities.player;

public class Women extends BasePlayer {
    private static final double WOMEN_KG = 60.00;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, WOMEN_KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(this.getStrength() + 115);
    }
}
