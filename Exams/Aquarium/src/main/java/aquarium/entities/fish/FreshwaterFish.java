package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    private static final int FRESH_WATER_FISH_SIZE = 3;
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(FRESH_WATER_FISH_SIZE);
    }

    @Override
    public void eat() {
        setSize(getSize() + 3);
    }
}
