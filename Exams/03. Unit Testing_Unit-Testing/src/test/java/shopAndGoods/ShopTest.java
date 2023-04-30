package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    private Shop shop;

    @Before
    public void setup() {
        shop = new Shop();
    }
    @Test
    public void testCreateShop() {
        Map<String,Goods> shelves;
        shelves = new LinkedHashMap<>();
        shelves.put("Shelves1", null);
        shelves.put("Shelves2", null);
        shelves.put("Shelves3", null);
        shelves.put("Shelves4", null);
        shelves.put("Shelves5", null);
        shelves.put("Shelves6", null);
        shelves.put("Shelves7", null);
        shelves.put("Shelves8", null);
        shelves.put("Shelves9", null);
        shelves.put("Shelves10", null);
        shelves.put("Shelves11", null);
        shelves.put("Shelves12", null);

        Assert.assertEquals(12,shelves.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsInvalidName() throws OperationNotSupportedException {
        Goods good1 = new Goods("Good1","1");
        Goods good2 = new Goods("Good2","2");
        Goods good3 = new Goods("Good3","3");
        shop.addGoods("Shelves18",good1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShelfAlreadyTakenThrowsEx() throws OperationNotSupportedException {
        Goods good1 = new Goods("Good1","1");
        Goods good2 = new Goods("Good2","2");
        Goods good3 = new Goods("Good3","3");
        shop.addGoods("Shelves10",good1);
        shop.addGoods("Shelves10",good2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsAlreadyOnShelf() throws OperationNotSupportedException {
        Goods good1 = new Goods("Good1","1");
        Goods good2 = new Goods("Good2","2");
        Goods good3 = new Goods("Good3","3");
        shop.addGoods("Shelves10",good1);
        shop.addGoods("Shelves5",good1);
    }

    @Test
    public void testAddGoodsCorrectly() throws OperationNotSupportedException {
        Goods good1 = new Goods("Good1","1");
        Goods good2 = new Goods("Good2","2");
        Goods good3 = new Goods("Good3","3");
        shop.addGoods("Shelves8",good1);

        Assert.assertTrue(shop.getShelves().containsValue(good1));
        Assert.assertEquals("Good1",shop.getShelves().get("Shelves8").getName());
        Assert.assertEquals("1",shop.getShelves().get("Shelves8").getGoodsCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShelfNotExist() {
        Goods good1 = new Goods("Good1","1");
        Goods good2 = new Goods("Good2","2");
        Goods good3 = new Goods("Good3","3");
        shop.removeGoods("Shelves19",good1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tetRemoveGoodsGoodsNotExist() {
        Goods good1 = new Goods("Good1","1");
        Goods good2 = new Goods("Good2","2");
        Goods good3 = new Goods("Good3","3");
        shop.removeGoods("Shelves10",good1);
    }

    @Test
    public void testRemoveGoodsCorrectly() throws OperationNotSupportedException {
        Goods good1 = new Goods("Good1","1");
        Goods good2 = new Goods("Good2","2");
        Goods good3 = new Goods("Good3","3");
        shop.addGoods("Shelves10",good1);

        shop.removeGoods("Shelves10",good1);

        Assert.assertFalse(shop.getShelves().containsValue(good1));
    }
}