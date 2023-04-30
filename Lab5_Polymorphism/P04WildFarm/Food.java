package Lab5_Polymorphism.P04WildFarm;

public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public abstract Integer getQuantity();
}
