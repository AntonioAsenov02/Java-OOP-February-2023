package gifts;

import org.junit.Assert;
import org.junit.Test;

public class GiftFactoryTests {

    @Test
    public void testCreateGiftFactory() {
        GiftFactory giftFactory = new GiftFactory();

        Assert.assertEquals(0,giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftAlreadyExistingThrowsEx() {
        Gift gift = new Gift("Gift1",25);

        GiftFactory giftFactory = new GiftFactory();

        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }

    @Test
    public void testCreateGiftCorrectly() {
        Gift gift1 = new Gift("Gift1",25);
        Gift gift2 = new Gift("Gift2",100);

        GiftFactory giftFactory = new GiftFactory();

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);

        Assert.assertEquals(2,giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftInvalidNameThrowsEx() {
        Gift gift1 = new Gift("Gift1",25);
        Gift gift2 = new Gift("Gift2",100);

        GiftFactory giftFactory = new GiftFactory();

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);

        giftFactory.removeGift("    ");
    }

    @Test
    public void testRemoveGiftCorrectly() {
        Gift gift1 = new Gift("Gift1",25);
        Gift gift2 = new Gift("Gift2",100);

        GiftFactory giftFactory = new GiftFactory();

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);

        Assert.assertTrue(giftFactory.removeGift("Gift1"));
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        Gift gift1 = new Gift("Gift1",25);
        Gift gift2 = new Gift("Gift2",100);

        GiftFactory giftFactory = new GiftFactory();

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);

        Assert.assertEquals(25,giftFactory.getPresentWithLeastMagic().getMagic(),0.01);
    }

    @Test
    public void testGetPresentByName() {
        Gift gift1 = new Gift("Gift1",25);
        Gift gift2 = new Gift("Gift2",100);

        GiftFactory giftFactory = new GiftFactory();

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);

        Assert.assertEquals(gift1,giftFactory.getPresent("Gift1"));
    }

    @Test
    public void testGetPresents() {
        Gift gift1 = new Gift("Gift1",25);
        Gift gift2 = new Gift("Gift2",100);

        GiftFactory giftFactory = new GiftFactory();

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);

        Assert.assertEquals(2,giftFactory.getPresents().size());
    }
}
