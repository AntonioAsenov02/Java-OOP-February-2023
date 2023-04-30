package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateServiceInvalidCapacityThrowsEx() {
        Service service = new Service("Service1",-10);
    }

    @Test(expected = NullPointerException.class)
    public void tetCreateServiceInvalidNameThrowEx() {
        Service service = new Service("     ",10);
    }

    @Test
    public void testCreateServiceCorrectly() {
        Service service = new Service("Service1",15);

        Assert.assertEquals("Service1",service.getName());
        Assert.assertEquals(15,service.getCapacity());
        Assert.assertEquals(0,service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotNotEnoughCapacityThrowsEx() {
        Service service = new Service("Service1",1);

        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");

        service.add(robot1);
        service.add(robot2);
    }

    @Test
    public void testAddRobotCorrectly() {
        Service service = new Service("Service1",15);

        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");

        service.add(robot1);
        service.add(robot2);

        Assert.assertEquals(2,service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotNotExistThrowsEx() {
        Service service = new Service("Service1",15);

        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");

        service.add(robot1);
        service.add(robot2);

        service.remove("Robot3");
    }

    @Test
    public void testRemoveRobotCorrectly() {
        Service service = new Service("Service1",15);

        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");

        service.add(robot1);
        service.add(robot2);

        Assert.assertEquals(2,service.getCount());

        service.remove("Robot1");

        Assert.assertEquals(1,service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRobotForSaleNotExistThrowsEx() {
        Service service = new Service("Service1",15);

        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");

        service.add(robot1);
        service.add(robot2);

        service.forSale("Robot5");
    }

    @Test
    public void testRobotForSaleCorrectly() {
        Service service = new Service("Service1",15);

        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");

        service.add(robot1);
        service.add(robot2);

        service.forSale("Robot2");

        Assert.assertFalse(robot2.isReadyForSale());
    }

    @Test
    public void testReport() {
        Service service = new Service("Service1",15);

        Robot robot1 = new Robot("Robot1");
        Robot robot2 = new Robot("Robot2");

        service.add(robot1);
        service.add(robot2);

        Assert.assertEquals("The robot Robot1, Robot2 is in the service Service1!",service.report());
    }
}
