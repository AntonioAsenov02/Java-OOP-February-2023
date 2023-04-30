package Exercise3_Inheritance.NeedForSpeed;

public class Main {

    public static void main(String[] args) {


        Vehicle vehicle = new Vehicle(100,1000);
        Car car = new Car(120,150);
        SportCar sportCar = new SportCar(200,1200);

        System.out.println(car.getFuelConsumption());
        System.out.println(vehicle.getFuelConsumption());
        System.out.println(sportCar.getFuelConsumption());
    }
}
