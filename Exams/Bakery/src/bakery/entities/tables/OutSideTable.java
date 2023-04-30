package bakery.entities.tables;

public class OutSideTable extends BaseTable {
    private static final double PRICE_PER_PERSON = 3.50;
    public OutSideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
