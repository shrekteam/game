package byui.cit260.shrek.view;
import byui.cit260.shrek.control.GameControl;
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
            +"\nS to purchase a Sword with cost 10"
            +"\nA to purchase an Arrow with cost 5"
            +"\nK to purchase a knife with cost 7"
            +"\nP to purchase a Spear with cost 12 "
            + "\nE to exit");
            //+"\nIf the launch height is more than 10 meters you break the wall ");
    }
   
    @Override
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value= value.toUpperCase();
       
        char choice = value.charAt(0);
         Game myGame = Shrek.getCurrentGame();
         InventoryItem[] inventory= myGame.getInventory();
         GameControl myGameControl=new GameControl();
     
        switch (choice){
            case 'S':
                myGameControl.purchaseItem(inventory,"Sword");
                break;
            case 'A':
                myGameControl.purchaseItem(inventory,"Arrow");
                break;
            case 'K':
                myGameControl.purchaseItem(inventory,"Knife");
                break;
            case 'P':
                myGameControl.purchaseItem(inventory,"Spear");
                break;
               
            case 'E':
                return true;
            default:
                System.out.println("Enter the value");
                break;              
       }
    return false;
    }
/*
    public int purchaseItem(InventoryItem[] inventory, String value) {
        int quantity=0;
        for (InventoryItem myItem:inventory) {
             //System.out.println(myItem.getInventoryType());
            if (myItem.getInventoryType()==value){
                myItem.setQuantityInStock(myItem.getQuantityInStock()+1);
               // System.out.println("sword ="+myItem.getQuantityInStock());
                System.out.println("A"+value+" is added to the Inventory List");
                quantity=myItem.getQuantityInStock();
                System.out.println("Now the "+value+" number is = "+quantity);
            }
        }
       return quantity;
      }
*/
}

    
