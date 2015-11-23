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
            +"\nInsert S to purchase a Sword"
            +"\nInsert A to purchase an Arrow "
            +"\nInsert K to purchase a knife "
            +"\nInsert P to purchase a Spear "
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
                this.purchaseItem(inventory,"Sword");
                break;
            case 'A':
                this.purchaseItem(inventory,"Arrow");
                break;
            case 'K':
                this.purchaseItem(inventory,"Knife");
                break;
            case 'P':
                this.purchaseItem(inventory,"Spear");
                break;
            case 'E':
                return true;
            default:
                System.out.println("Enter the value");
                break;              
       }
    return false;
    }

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

}

    
