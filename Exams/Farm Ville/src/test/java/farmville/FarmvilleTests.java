package farmville;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FarmvilleTests {

    List<Animal> animals = new ArrayList<>();
    @Test(expected = IllegalArgumentException.class)
    public void testCreateFarmInvalidCapacity() {
        Farm farm = new Farm("cowFarm",-1);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateFarmInvalidName() {
        Farm farm = new Farm(null,5);
    }

    @Test
    public void testCreateFarmCorrectly() {
        Farm farm = new Farm("cowFarm",5);

        Assert.assertEquals("cowFarm",farm.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalInFullFarmThrowEx() {
        Farm farm = new Farm("cowFarm",1);

        Assert.assertEquals(0,animals.size());

        Animal cow = new Animal("Cow",50);
        Animal rabbit = new Animal("Rabbit",34);

        farm.add(cow);
        farm.add(rabbit);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddIfAnimalAlreadyInFarmThrowEx() {
        Farm farm = new Farm("cowFarm",2);

        Assert.assertEquals(0,farm.getCount());

        Animal cow = new Animal("Cow",50);
        Animal cow2 = new Animal("Cow",34);

        farm.add(cow);
        farm.add(cow2);
    }

    @Test
    public void testAddCorrectly() {
        Farm farm = new Farm("cowFarm",5);

        Assert.assertEquals(0,animals.size());

        Animal cow = new Animal("Cow",50);
        Animal rabbit = new Animal("Rabbit",34);

        farm.add(cow);
        farm.add(rabbit);

        Assert.assertEquals(2,farm.getCount());
        Assert.assertEquals(50,cow.getEnergy(),0.01);
    }

    @Test
    public void testRemoveAnimalNotInFarm() {
        Farm farm = new Farm("cowFarm",5);

        Assert.assertEquals(0,animals.size());

        Animal cow = new Animal("Cow",50);
        Animal rabbit = new Animal("Rabbit",34);

        farm.add(cow);
        farm.add(rabbit);

        Assert.assertFalse(farm.remove("Dog"));
    }

    @Test
    public void testRemoveAnimalInFarm() {
        Farm farm = new Farm("cowFarm",5);

        Assert.assertEquals(0,animals.size());

        Animal cow = new Animal("Cow",50);
        Animal rabbit = new Animal("Rabbit",34);

        farm.add(cow);
        farm.add(rabbit);

        Assert.assertTrue(farm.remove("Rabbit"));
    }
}
