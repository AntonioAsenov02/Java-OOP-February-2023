package magicGame;

import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {

    @Test(expected = NullPointerException.class)
    public void testCreateUsernameNullThrowsEx() {
        Magician magician = new Magician(null,50);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateUsernameNEmptyThrowsEx() {
        Magician magician = new Magician("     ",40);
        Assert.assertEquals("     ",magician.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidHealthThrowsEx() {
        Magician magician = new Magician("White",-10);
    }

    @Test
    public void testCreateCorrectly() {
        Magician magician = new Magician("White",120);

        Assert.assertEquals(120,magician.getHealth());
        Assert.assertEquals("White",magician.getUsername());
        Assert.assertTrue(magician.getMagics().isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageInvalidHealthThrowsEx() {
        Magician magician = new Magician("White",0);

        magician.takeDamage(10);
    }

    @Test
    public void testTakeDamageCorrectly() {
        Magician magician = new Magician("White",2);
        Magician magician2 = new Magician("White",10);
        magician.takeDamage(5);
        magician2.takeDamage(5);

        Assert.assertEquals(0,magician.getHealth());
        Assert.assertEquals(5,magician2.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullThrowsEx() {
        Magician magician = new Magician("White",100);
        Magic magic = new Magic("White",100);
        Magic magic2 = new Magic("White",100);
        magician.addMagic(null);
    }

    @Test
    public void testAddCorrectly() {
        Magician magician = new Magician("White",100);
        Magic magic = new Magic("White",100);
        Magic magic2 = new Magic("White",100);
        magician.addMagic(magic);

        Assert.assertEquals(1,magician.getMagics().size());
    }
    @Test
    public void testRemoveNonExistingThrowsEx() {
        Magician magician = new Magician("White",100);
        Magic magic = new Magic("White",100);
        Magic magic2 = new Magic("White",100);
        magician.addMagic(magic);

        Assert.assertFalse(magician.removeMagic(magic2));
    }

    @Test
    public void testRemoveExisting() {
        Magician magician = new Magician("White",100);
        Magic magic = new Magic("White",100);
        Magic magic2 = new Magic("White",100);
        magician.addMagic(magic);

        Assert.assertTrue(magician.removeMagic(magic));
    }

    @Test
    public void testGetMagic() {
        Magician magician = new Magician("White",120);
        Magic magic = new Magic("White",100);
        Magic magic2 = new Magic("White",100);
        magician.addMagic(magic);

        Assert.assertEquals("White",magician.getMagic("White").getName());
        Assert.assertEquals(100,magician.getMagic("White").getBullets());
    }
}
