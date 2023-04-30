package Exercise5_Polymorphism.P02VehicleExtension;

public class Car extends Vehicle {
    public final static double ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity,ADDITIONAL_CONSUMPTION);
    }
}
