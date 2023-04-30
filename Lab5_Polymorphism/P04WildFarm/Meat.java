package Lab5_Polymorphism.P04WildFarm;

public class Meat extends Food {
    private Integer quantity;

    public Meat(Integer quantity) {
        super(quantity);
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

}
