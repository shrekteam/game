
package byui.cit260.shrek.control;

//import byui.cit260.shrek.exceptions.GameControlException;
import byui.cit260.shrek.exceptions.GameControlException;
import byui.cit260.shrek.model.Enemy;
import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.model.InventoryItem;
import byui.cit260.shrek.model.Item;
import byui.cit260.shrek.model.Location;
import byui.cit260.shrek.model.Map;
import byui.cit260.shrek.model.Pathway;
import byui.cit260.shrek.model.Player;
import byui.cit260.shrek.model.Scene;
import byui.cit260.shrek.model.SceneType;
import byui.cit260.shrek.model.Wall;
import byui.cit260.shrek.model.Weapon;
import shrek.Shrek;
import byui.cit260.shrek.exceptions.MapControlException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author bruno
 */
public class GameControl {
    private static Object mapControl;
    
    public static void createNewGame(Player player) 
        throws MapControlException{
        
        Game game = new Game();
        Shrek.setCurrentGame(game);
        game.setPlayer(player);
        Pathway pathway = new Pathway();
        game.setPathway(pathway);
        Weapon weapon = new Weapon();
        game.setWeapon(weapon);
        //Enemy enemy = new Enemy();
        //game.setEnemy(enemy);
        Wall wall = new Wall();
        game.setWall(wall);
        //MapControl map = new MapControl();
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap();
        game.setMap(map);
        
        MapControl.moveActorsToStartingLocation(map);
              
        System.out.println("\n***createNewGame function called ***");
    }
    public static InventoryItem[] createInventoryList(){
        InventoryItem[] inventory=new InventoryItem[4];
        
        InventoryItem sword= new InventoryItem();
        sword.setInventoryType("Sword");
        sword.setQuantityInStock(0);
        sword.setRequiredAmount(0);
        sword.setInventoryCost(10);
        inventory[Item.sword.ordinal()]=sword;
        
        InventoryItem arrow= new InventoryItem();
        arrow.setInventoryType("Arrow");
        arrow.setQuantityInStock(0);
        arrow.setRequiredAmount(0);
        arrow.setInventoryCost(5);
        inventory[Item.arrow.ordinal()]=arrow;
        
        InventoryItem knife= new InventoryItem();
        knife.setInventoryType("Knife");
        knife.setQuantityInStock(0);
        knife.setRequiredAmount(0);
        knife.setInventoryCost(7);
        inventory[Item.knife.ordinal()]=knife;
        
        InventoryItem spear= new InventoryItem();
        spear.setInventoryType("Spear");
        spear.setQuantityInStock(0);
        spear.setRequiredAmount(0);
        spear.setInventoryCost(13);
        inventory[Item.spear.ordinal()]=spear;
        
    return inventory;
  }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        locations[0][0].setScenes(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScenes(scenes[SceneType.place.ordinal()]);
        locations[0][3].setScenes(scenes[SceneType.building.ordinal()]);
        locations[0][4].setScenes(scenes[SceneType.finish.ordinal()]);
    }

    public static InventoryItem[] getSortedInventoryList() {
       //this function implments bubblesort, but I use the next function, InsertionSort
        InventoryItem[] originalInventoryList = Shrek.getCurrentGame().getInventory();
        
        InventoryItem[] inventoryList = originalInventoryList.clone();
        InventoryItem tempInventoryItem;
        for(int i=0; i<inventoryList.length-1;i++) {
            for (int j=0;j<inventoryList.length-1-i;j++){
                if(inventoryList[j].getInventoryType().
                        compareToIgnoreCase(inventoryList[j+1].getInventoryType())>0){
                            tempInventoryItem = inventoryList[j];
                            inventoryList[j]= inventoryList[j+1];
                            inventoryList[j+1]= tempInventoryItem;
                }
                
            }
        }
               
        return inventoryList;
    }
    public static InventoryItem[] getInsertionSortedInventoryList() {
       //this function implements Insertion sort algorythm
        InventoryItem[] originalInventoryList = Shrek.getCurrentGame().getInventory();
        
        InventoryItem[] inventoryList = originalInventoryList.clone();
        InventoryItem tempInventoryItem;
        
        for(int i=1; i<inventoryList.length;i++) {
            for (int j=i;j>0;j--){
                if(inventoryList[j].getInventoryType().
                        compareToIgnoreCase(inventoryList[j-1].getInventoryType())>0){
                              tempInventoryItem = inventoryList[j];
                              inventoryList[j]=inventoryList[j-1];
                              inventoryList[j-1]=tempInventoryItem;
                 }             
                          
                }
                
            }
        
               
        return inventoryList;
    }
    
    public static InventoryItem[] getSortedQuantityInventoryList() {
       //this function implments bubblesort, but I use the next function, InsertionSort
        InventoryItem[] originalInventoryList = Shrek.getCurrentGame().getInventory();
        
        InventoryItem[] inventoryList = originalInventoryList.clone();
        InventoryItem tempInventoryItem;
        for(int i=0; i<inventoryList.length-1;i++) {
            for (int j=0;j<inventoryList.length-1-i;j++){
                if(inventoryList[j].getQuantityInStock()<inventoryList[j+1].getQuantityInStock()) {
                        
                            tempInventoryItem = inventoryList[j];
                            inventoryList[j]= inventoryList[j+1];
                            inventoryList[j+1]= tempInventoryItem;
                }
                
            }
        }
               
        return inventoryList;
    }

    public static void saveGame(Game game, String filePath) 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        throws GameControlException {
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream (fops);
            output.writeObject(game);
            //output.writeObject(Shrek.getCurrentGame().getInventory());
            }
        catch (IOException e){
            throw new GameControlException(e.getMessage());
            }
        }

    public static void getSavedGame(String filePath)
        throws GameControlException{
        Game game = null;
        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream output = new ObjectInputStream (fips);
            game = (Game) output.readObject();
            Shrek.setCurrentGame(game);
            //game.setInventory(inventoryList);
            }
        catch (FileNotFoundException fnfe){
            throw new GameControlException(fnfe.getMessage());
            }
        catch (Exception e){
             throw new GameControlException(e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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