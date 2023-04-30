package Exercise5_Polymorphism.P02VehicleExtension;

public class Truck extends Vehicle {
    public final static double ADDITIONAL_CONSUMPTION = 1.6;
    public final static double DRIVER_FUEL_DEDUCTION = 0.95;
    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity,fuelConsumption,tankCapacity,ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * DRIVER_FUEL_DEDUCTION);
    }
}
