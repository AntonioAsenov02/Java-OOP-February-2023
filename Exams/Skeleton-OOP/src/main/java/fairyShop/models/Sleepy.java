package fairyShop.models;

public class Sleepy extends BaseHelper {
    private static final int SLEEPY_ENERGY = 50;
    public Sleepy(String name) {
        super(name, SLEEPY_ENERGY);
    }

    @Override
    public void work() {
       // this.setEnergy(Math.max(getEnergy() - 15,0));
    }
}
