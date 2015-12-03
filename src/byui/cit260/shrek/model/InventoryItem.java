/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author bruno
 */
public class InventoryItem implements Serializable{
    private String inventoryType;
    private int quantityInStock;
    private int requiredAmount;
    private String description;
    private int inventoryCost;

    public InventoryItem() {
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "inventoryType=" + inventoryType + ", quantityInStock=" + quantityInStock + ", requiredAmount=" + requiredAmount + ", description=" + description + ", inventoryCost=" + inventoryCost + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.inventoryType);
        hash = 47 * hash + this.quantityInStock;
        hash = 47 * hash + this.requiredAmount;
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + this.inventoryCost;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItem other = (InventoryItem) obj;
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        if (this.quantityInStock != other.quantityInStock) {
            return false;
        }
        if (this.requiredAmount != other.requiredAmount) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.inventoryCost != other.inventoryCost) {
            return false;
        }
        return true;
    }
    

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
