package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    Garage garage;

    @Before
    public void setUp() {
        garage = new Garage();
    }

    public void fillUpGarage() {

    }
    @Test
    public void testAddCarSuccessful() {
        Assert.assertEquals(0,garage.getCount());
        Car B = new Car("Mercedes",220,60000);
        Car C = new Car("Mercedes",240,80000);
        Car E = new Car("Mercedes",260,100000);
        Car Bmw = new Car("BMW",220,65000);

        this.garage.addCar(B);
        this.garage.addCar(C);
        this.garage.addCar(E);
        this.garage.addCar(Bmw);
       Assert.assertEquals(4,garage.getCount());
       Assert.assertEquals(E,garage.getCars().get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrowsEx() {
        this.garage.addCar(null);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Car B = new Car("Mercedes",220,60000);
        Car C = new Car("Mercedes",240,80000);
        Car E = new Car("Mercedes",260,100000);
        Car Bmw = new Car("BMW",220,65000);

        this.garage.addCar(B);
        this.garage.addCar(C);
        this.garage.addCar(E);
        this.garage.addCar(Bmw);
        List<Car> foundCars = this.garage.findAllCarsWithMaxSpeedAbove(230);

        Assert.assertEquals(2,foundCars.size());
        Assert.assertEquals(C,foundCars.get(0));
        Assert.assertEquals(E,foundCars.get(1));
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car B = new Car("Mercedes",220,60000);
        Car C = new Car("Mercedes",240,80000);
        Car E = new Car("Mercedes",260,100000);
        Car Bmw = new Car("BMW",220,65000);

        this.garage.addCar(B);
        this.garage.addCar(C);
        this.garage.addCar(E);
        this.garage.addCar(Bmw);

        Car mostExpensive = this.garage.getTheMostExpensiveCar();

        Assert.assertEquals(E,mostExpensive);
    }

    @Test
    public void testFindAllCarsByBrand() {
        Car B = new Car("Mercedes",220,60000);
        Car C = new Car("Mercedes",240,80000);
        Car E = new Car("Mercedes",260,100000);
        Car Bmw = new Car("BMW",220,65000);

        this.garage.addCar(B);
        this.garage.addCar(C);
        this.garage.addCar(E);
        this.garage.addCar(Bmw);

        List<Car> mercedesList = this.garage.findAllCarsByBrand("Mercedes");

        Assert.assertEquals(3,mercedesList.size());
        Assert.assertEquals(B,mercedesList.get(0));
        Assert.assertEquals(C,mercedesList.get(1));
        Assert.assertEquals(E,mercedesList.get(2));
    }
}