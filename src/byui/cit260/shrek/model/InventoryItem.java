/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

/**
 *
 * @author bruno
 */
public class InventoryItem {
    private String inventoryType;
    private int quantityInStock;
    private int requiredAmount;
    private String description;
    private int inventoryCost;

    public int getInventoryCost() {
        return inventoryCost;
    }

    public void setInventoryCost(int inventoryCost) {
        this.inventoryCost = inventoryCost;
    }
    
    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public String getDescription() {
        return description;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
