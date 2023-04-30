package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseInvalidCapacity() {
        House house = new House("House1", -10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseInvalidName() {
        House house = new House(null, 10);
    }

    @Test
    public void testCreateHouseCorrectly() {
        House house = new House("House1", 5);
        Assert.assertEquals("House1",house.getName());
        Assert.assertEquals(5,house.getCapacity());
    }

    @Test
    public void testAddCatCorrectly() {
        House house = new House("House1", 1);

        Cat cat1 = new Cat("Jake");

        Assert.assertEquals(0, house.getCount());

        house.addCat(cat1);

        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowsEx() {
        House house = new House("House1", 1);

        Cat cat1 = new Cat("Jake");
        Cat cat2 = new Cat("Sonic");

        house.addCat(cat1);
        Assert.assertEquals(1, house.getCount());
        house.addCat(cat2);
    }

    @Test
    public void testRemoveCatCorrectly() {
        House house = new House("House1", 3);

        Cat cat1 = new Cat("Jake");
        Cat cat2 = new Cat("Sonic");

        house.addCat(cat1);
        house.addCat(cat2);

        Assert.assertEquals(2,house.getCount());

        house.removeCat("Jake");

        Assert.assertEquals(1,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowsEx() {
        House house = new House("House1", 3);

        Cat cat1 = new Cat("Jake");
        Cat cat2 = new Cat("Sonic");

        house.addCat(cat1);
        house.addCat(cat2);

        house.removeCat("James");
    }

    @Test
    public void testCatForSaleCorrectly() {
        House house = new House("House1", 3);

        Cat cat1 = new Cat("Jake");
        Cat cat2 = new Cat("Sonic");

        house.addCat(cat1);
        house.addCat(cat2);

        Assert.assertFalse(house.catForSale("Sonic").isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsEx() {
        House house = new House("House1", 3);

        Cat cat1 = new Cat("Jake");
        Cat cat2 = new Cat("Sonic");

        house.addCat(cat1);
        house.addCat(cat2);

        house.catForSale("Kitty");
    }

    @Test
    public void testStatistics() {
        House house = new House("House1", 3);

        Cat cat1 = new Cat("Jake");

        house.addCat(cat1);

        String expected = String.format("The cat %s is in the house %s!",cat1.getName(),house.getName());
        Assert.assertEquals(expected,house.statistics());
    }
}

