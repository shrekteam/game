package byui.cit260.shrek.view;
import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.model.InventoryItem;
import java.util.Scanner;
import shrek.Shrek;
/**
 *
 * @author bruno
 */


public class PurchaseItemMenu extends View {
   
    public PurchaseItemMenu(){
    //private final String MENU="\n"
        super("\n"
            +"\n----------------------------------------"
            +"\n|         Purchase Item Menu     |"
            +"\n----------------------------------------"
            +"\nInsert S to purchase sword"
            +"\nInsert A to purchase arrow "
            + "\nInsert E to exit");
            //+"\nIf the launch height is more than 10 meters you break the wall ");
    }    
    @Override
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value= value.toUpperCase();
       
        char choice = value.charAt(0);
         Game myGame = Shrek.getCurrentGame();
         InventoryItem[] inventory= myGame.getInventory();
     
        switch (choice){
            case 'S':
               
                this.purchaseSword(inventory);
               
                break;
            case 'A':
                this.purchaseArrow(inventory);
                break;
            
            case 'E':
                return true;
            default:
                System.out.println("Enter the value");
                break;              
       }
    return false;
    }

    private void purchaseSword(InventoryItem[] inventory) {
        for (InventoryItem myItem:inventory) {
             //System.out.println(myItem.getInventoryType());
            if (myItem.getInventoryType()=="Sword"){
                myItem.setQuantityInStock(myItem.getQuantityInStock()+1);
               // System.out.println("sword ="+myItem.getQuantityInStock());
                System.out.println("A Sword is added to the Invetory List");
                System.out.println("Now the sword number is = "+myItem.getQuantityInStock());
            }
                
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void purchaseArrow(InventoryItem[] inventory) {
        for (InventoryItem myItem:inventory) {
             //System.out.println(myItem.getInventoryType());
            if (myItem.getInventoryType()=="Arrow"){
                myItem.setQuantityInStock(myItem.getQuantityInStock()+1);
                System.out.println("An arrow is added to the Inventory List");
                System.out.println("Now the arrows number is = "+myItem.getQuantityInStock());
            }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
}

    
