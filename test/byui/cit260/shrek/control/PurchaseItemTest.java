/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.control;

import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.model.InventoryItem;
import byui.cit260.shrek.view.PurchaseItemMenu;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import shrek.Shrek;

/**
 *
 * @author bruno
 */
public class PurchaseItemTest {

    public PurchaseItemTest() {
    }
    
    @Test
    public void testPurchaseItem() {
        System.out.println("purchaseSword");
        String value = "Sword";
        //Game myGame = Shrek.getCurrentGame();
        GameControl instance = new GameControl();
        InventoryItem[] inventory = instance.createInventoryList();
        //InventoryItem[] inventory= myGame.getInventory();
        //PurchaseItemMenu instance = new PurchaseItemMenu();
        int expResult = 1;
        int result = instance.purchaseItem(inventory, value);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("purchaseArrow");
        value = "Arrow";
        result = instance.purchaseItem(inventory, value);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("purchaseSpear");
        value = "Spear";
        result = instance.purchaseItem(inventory, value);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("purchaseKnife");
        value = "Knife";
        result = instance.purchaseItem(inventory, value);
        assertEquals(expResult, result, 0.0001);
    
}

}