package Exercise5_Polymorphism.P01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance){
        double fuelNeeded = distance * getFuelConsumption();
        if (getFuelQuantity() > fuelNeeded){
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km",getClass().getSimpleName(),df.format(distance));
        }
        return String.format("%s needs refueling",getClass().getSimpleName());
    }

    public void refuel(double liters){
        this.fuelQuantity += liters;
    }

    @Override
    public String toString(){
        return String.format("%s: %.2f",getClass().getSimpleName(),fuelQuantity);
    }
}
