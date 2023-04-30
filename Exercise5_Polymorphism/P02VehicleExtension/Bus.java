package Exercise5_Polymorphism.P02VehicleExtension;

public class Bus extends Vehicle {
    public final static double ADDITIONAL_CONSUMPTION = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity,ADDITIONAL_CONSUMPTION);
    }
}
