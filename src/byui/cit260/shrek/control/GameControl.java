
package byui.cit260.shrek.control;

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

/**
 *
 * @author bruno
 */
public class GameControl {
    private static Object mapControl;
    
    public static void createNewGame(Player player) {
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
        sword.setQuantityInStock(2);
        sword.setRequiredAmount(0);
        inventory[Item.sword.ordinal()]=sword;
        
        InventoryItem arrow= new InventoryItem();
        arrow.setInventoryType("Arrow");
        arrow.setQuantityInStock(2);
        arrow.setRequiredAmount(0);
        inventory[Item.arrow.ordinal()]=arrow;
        
        InventoryItem knife= new InventoryItem();
        knife.setInventoryType("Knife");
        knife.setQuantityInStock(2);
        knife.setRequiredAmount(0);
        inventory[Item.knife.ordinal()]=knife;
        
        InventoryItem spear= new InventoryItem();
        spear.setInventoryType("Spear");
        spear.setQuantityInStock(2);
        spear.setRequiredAmount(0);
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
}