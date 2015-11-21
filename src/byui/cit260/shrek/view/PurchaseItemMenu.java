package byui.cit260.shrek.view;
import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.model.InventoryItem;
import java.util.Scanner;
import shrek.Shrek;
/**
 *
 * @author bruno
 */
/*
public class PurchaseItemMenu extends View {
   
    public PurchaseItemMenu(){
    //private final String MENU="\n"
        super("\n"
            +"\n----------------------------------------"
            +"\n|         Purchase Item Menu     |"
            +"\n----------------------------------------"
            +"\nInsert S to purchase sword"
            +"\nInsert A to purchase arrow "
            +"\nIf the launch height is more than 10 meters you break the wall ");
    }    
    @Override
    public boolean doAction() {
        //String value=(String)obj;
        //value= value.toUpperCase();
        //char choice = value.charAt(0);
    //private void doAction(char choice) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    switch (choice){
            case 'S':
                Game myGame = Shrek.getCurrentGame();
                InventoryItem[] inventory= myGame.getInventory();
                this.purchaseSword(inventory);
                break;
            case 'A':
                this.purchaseArrow();
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
        for (InventoryItem item:inventory) {
            if (item.getInventoryType()=="sword"){
                item.setQuantityInStock(item.getQuantityInStock()+1);
            }
                
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void purchaseArrow() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
*/
    
