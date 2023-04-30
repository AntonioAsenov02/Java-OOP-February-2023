package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateExcavationInvalidCapacityThrowsEx() {
        Excavation excavation = new Excavation("Excavation1",-5);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExcavationNullNameThrowsEx() {
        Excavation excavation = new Excavation(null,5);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExcavationInvalidNameThrowsEx() {
        Excavation excavation = new Excavation("     ",5);
    }
    @Test
    public void testCreateExcavationCorrectly() {
        Excavation excavation = new Excavation("Excavation1",5);

        Assert.assertEquals("Excavation1",excavation.getName());
        Assert.assertEquals(5,excavation.getCapacity());
        Assert.assertEquals(0,excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistIfNoRoomThrowsEx() {
        Excavation excavation = new Excavation("Excavation1",1);

        Assert.assertEquals(0,excavation.getCount());

        Archaeologist archaeologist1 = new Archaeologist("Arch1",40);
        Archaeologist archaeologist2 = new Archaeologist("Arch2",20);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistIfAlreadyExistsThrowsEx() {
        Excavation excavation = new Excavation("Excavation1",5);

        Assert.assertEquals(0,excavation.getCount());

        Archaeologist archaeologist1 = new Archaeologist("Arch1",40);
        Archaeologist archaeologist2 = new Archaeologist("Arch1",40);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test
    public void testAddArchaeologistCorrectly() {
        Excavation excavation = new Excavation("Excavation1",5);

        Assert.assertEquals(0,excavation.getCount());

        Archaeologist archaeologist1 = new Archaeologist("Arch1",40);
        Archaeologist archaeologist2 = new Archaeologist("Arch2",20);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

        Assert.assertEquals(2,excavation.getCount());
        Assert.assertEquals(20,archaeologist2.getEnergy(),0.01);
    }

    @Test
    public void testRemoveArchaeologistNonExisting() {
        Excavation excavation = new Excavation("Excavation1",5);

        Assert.assertEquals(0,excavation.getCount());

        Archaeologist archaeologist1 = new Archaeologist("Arch1",40);
        Archaeologist archaeologist2 = new Archaeologist("Arch2",20);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

        Assert.assertFalse(excavation.removeArchaeologist("Arch3"));
    }

    @Test
    public void testRemoveArchaeologistExisting() {
        Excavation excavation = new Excavation("Excavation1",5);

        Assert.assertEquals(0,excavation.getCount());

        Archaeologist archaeologist1 = new Archaeologist("Arch1",40);
        Archaeologist archaeologist2 = new Archaeologist("Arch2",20);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

        Assert.assertTrue(excavation.removeArchaeologist("Arch2"));
    }
}
