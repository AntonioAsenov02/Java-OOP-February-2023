package Exercise5_Polymorphism.P01Vehicles;

public class Car extends Vehicle {
    public final static double ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelConsumption(fuelConsumption + ADDITIONAL_CONSUMPTION);
    }
}
