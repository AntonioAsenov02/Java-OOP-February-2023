package Lab5_Polymorphism.P04WildFarm;

public class Vegetable extends Food{
    private Integer quantity;

    public Vegetable(Integer quantity) {
        super(quantity);
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }
}
