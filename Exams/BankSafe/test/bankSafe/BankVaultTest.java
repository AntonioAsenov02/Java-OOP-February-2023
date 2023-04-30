package bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {
    private BankVault bankVault;

    @Before
    public void setup() {
        bankVault = new BankVault();
    }
    @Test
    public void testCreateBankVault() {
        Map<String, Item> vaultCells = new LinkedHashMap<>();
        vaultCells.put("A1", null);
        vaultCells.put("A2", null);
        vaultCells.put("A3", null);
        vaultCells.put("A4", null);
        vaultCells.put("B1", null);
        vaultCells.put("B2", null);
        vaultCells.put("B3", null);
        vaultCells.put("B4", null);
        vaultCells.put("C1", null);
        vaultCells.put("C2", null);
        vaultCells.put("C3", null);
        vaultCells.put("C4", null);

        Assert.assertEquals(12,bankVault.getVaultCells().size());
        Assert.assertEquals(bankVault.getVaultCells(),vaultCells);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemCellDoNotExist() throws OperationNotSupportedException {
        Item item1 = new Item("Atanas","1");
        bankVault.addItem("D1",item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemCellAlreadyTaken() throws OperationNotSupportedException {
        Item item1 = new Item("Atanas","1");
        Item item2 = new Item("Antonio","2");

        bankVault.addItem("A1",item1);
        bankVault.addItem("A1",item2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemAlreadyInCell() throws OperationNotSupportedException {
        Item item1 = new Item("Atanas","1");

        bankVault.addItem("A1",item1);
        bankVault.addItem("B1",item1);
    }

    @Test
    public void testAddItemCorrectly() throws OperationNotSupportedException {
        Item item1 = new Item("Atanas","1");

        Assert.assertEquals("Item:1 saved successfully!",bankVault.addItem("A1",item1));
        Assert.assertEquals("Atanas",bankVault.getVaultCells().get("A1").getOwner());
        Assert.assertEquals("1",bankVault.getVaultCells().get("A1").getItemId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCellDoesNotExist() {
        Item item1 = new Item("Atanas","1");

        bankVault.removeItem("D2",item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemInCellNotExist() {
        Item item1 = new Item("Atanas","1");

        bankVault.removeItem("A1",item1);
    }

    @Test
    public void testRemoveItemCorrectly() throws OperationNotSupportedException {
        Item item1 = new Item("Atanas","1");

        bankVault.addItem("A1",item1);

        Assert.assertEquals("Remove item:1 successfully!",bankVault.removeItem("A1",item1));
    }
}