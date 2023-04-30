package Exercise5_Polymorphism.P01Vehicles;

public class Truck extends Vehicle{
    public final static double ADDITIONAL_CONSUMPTION = 1.6;
    public final static double DRIVER_FUEL_DEDUCTION = 0.95;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelConsumption(fuelConsumption + ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + liters * DRIVER_FUEL_DEDUCTION);
    }
}
