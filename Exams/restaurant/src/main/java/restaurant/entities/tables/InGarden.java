package restaurant.entities.tables;

public class InGarden extends BaseTable {
    private static final double IN_GARDEN_PRICE_PER_PERSON = 4.50;
    public InGarden(int number, int size) {
        super(number, size, IN_GARDEN_PRICE_PER_PERSON);
    }
}
