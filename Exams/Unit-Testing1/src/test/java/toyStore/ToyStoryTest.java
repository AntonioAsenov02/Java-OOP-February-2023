package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ToyStoryTest {
    private ToyStore toyStore;

    @Before
    public void setup() {
        toyStore = new ToyStore();
    }

    @Test
    public void testCreateToyStore() {
        Map<String, Toy> toyShelf;
        toyShelf = new LinkedHashMap<>();
        toyShelf.put("A", null);
        toyShelf.put("B", null);
        toyShelf.put("C", null);
        toyShelf.put("D", null);
        toyShelf.put("E", null);
        toyShelf.put("F", null);
        toyShelf.put("G", null);

        Assert.assertEquals(toyShelf,toyStore.getToyShelf());
        Assert.assertEquals(7, toyStore.getToyShelf().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyDoesNotExistThrowsEx() throws OperationNotSupportedException {
     Toy toy = new Toy("Mercedes","E-class");

     toyStore.addToy("H",toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShelfIsTakenThrowsEx() throws OperationNotSupportedException {
        Toy toy = new Toy("Mercedes","E-class");
        Toy toy2 = new Toy("Mercedes","S-class");

        toyStore.addToy("A",toy);
        toyStore.addToy("A",toy2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyAlreadyOnShelfThrowsEx() throws OperationNotSupportedException {
        Toy toy = new Toy("Mercedes","E-class");

        toyStore.addToy("A",toy);

        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1,exist);
        toyStore.addToy("C",toy);
    }

    @Test
    public void testAddToySuccessfully() throws OperationNotSupportedException {
        Toy toy = new Toy("Bmw","5");

        Assert.assertEquals("Toy:5 placed successfully!",toyStore.addToy("A",toy));
        Assert.assertEquals("Bmw",toy.getManufacturer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShelfNotExistThrowsEx() throws OperationNotSupportedException {
        Toy toy = new Toy("Mercedes","E-class");

        toyStore.addToy("A",toy);
        toyStore.removeToy("H",toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyNoSuchToyOnShelf() throws OperationNotSupportedException {
        Toy toy = new Toy("Mercedes","E-class");

        toyStore.addToy("A",toy);

        toyStore.removeToy("B",toy);
    }

    @Test
    public void testRemoveToySuccessfully() throws OperationNotSupportedException {
        Toy toy = new Toy("Mercedes","E-class");

        toyStore.addToy("A",toy);

        Assert.assertEquals("Remove toy:E-class successfully!",toyStore.removeToy("A",toy));
    }
}