package Exercise5_Polymorphism.P02VehicleExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private double additionalAcConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity,double additionalAcConsumption) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
        this.additionalAcConsumption = additionalAcConsumption;
    }

    public double getAdditionalAcConsumption() {
        return additionalAcConsumption;
    }

    public void setAdditionalAcConsumption(double additionalAcConsumption) {
        this.additionalAcConsumption = additionalAcConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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

    public String driveAC(double distance){
        setFuelConsumption(getFuelConsumption() + additionalAcConsumption);
        String driveResult = this.drive(distance);
        setFuelConsumption(getFuelConsumption() - additionalAcConsumption);
        return driveResult;
    }
    public String drive(double distance) {
        double fuelNeeded = distance * getFuelConsumption();
        if (getFuelQuantity() >= fuelNeeded) {
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity + liters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }
}
