
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
import byui.cit260.shrek.model.Actor;
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
        InventoryItem[] inventory=new InventoryItem[3];
        
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
        /*
        InventoryItem knife= new InventoryItem();
        knife.setInventoryType("Knife");
        knife.setQuantityInStock(0);
        knife.setRequiredAmount(0);
        knife.setInventoryCost(7);
        inventory[Item.knife.ordinal()]=knife;
        */
        InventoryItem spear= new InventoryItem();
        spear.setInventoryType("Spear");
        spear.setQuantityInStock(0);
        spear.setRequiredAmount(0);
        spear.setInventoryCost(12);
        inventory[Item.spear.ordinal()]=spear;
        
    return inventory;
  }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        
        Scene scene0= new Scene();
        scene0.setDescription("no scene");
        scene0.setMoney(0);
        Scene scene1= new Scene();
        scene1.setDescription("Pinocchio");
        scene1.setMoney(10);
        Scene scene2= new Scene();
        scene2.setDescription("BeutyAndBeast");
        scene2.setMoney(12);
        Scene scene3= new Scene();
        scene3.setDescription("Raperunzel");
        scene3.setMoney(9);
        Scene scene4= new Scene();
        scene4.setDescription("Witch");
        scene4.setMoney(6);
        Scene scene5= new Scene();
        scene5.setDescription("DoctorPigs");
        scene5.setMoney(13);
        Scene scene6= new Scene();
        scene6.setDescription("Prince");
        scene6.setMoney(14);
        Scene scene7= new Scene();
        scene7.setDescription("MickeyMouse");
        scene7.setMoney(5);
        Scene scene8= new Scene();
        scene8.setDescription("Pluto");
        scene8.setMoney(4);
        Scene scene9= new Scene();
        scene9.setDescription("TipTap");
        scene9.setMoney(3);
        Scene scene10= new Scene();
        scene10.setDescription("DonaldDuck");
        scene10.setMoney(8);
        Scene scene11= new Scene();
        scene11.setDescription("Huey");
        scene11.setMoney(12);
        Scene scene12= new Scene();
        scene12.setDescription("Duey");
        scene12.setMoney(7);
        
        Location[][] locations = map.getLocations();
        for (int i=0; i<20; i++)
            for(int j=0;j<20; j++)
                locations[i][j].setScenes(scene0);
        locations[0][0].setScenes(scene1);
        locations[0][1].setScenes(scene2);
        locations[0][2].setScenes(scene1);
        locations[0][3].setScenes(scene2);
        locations[0][4].setScenes(scene1);
        locations[0][5].setScenes(scene2);
        locations[0][6].setScenes(scene1);
        locations[0][7].setScenes(scene2);
        locations[1][0].setScenes(scene1);
        locations[1][1].setScenes(scene3);
        locations[1][2].setScenes(scene4);
        locations[1][3].setScenes(scene5);
        locations[1][4].setScenes(scene1);
        locations[1][5].setScenes(scene2);
        locations[1][6].setScenes(scene3);
        locations[1][7].setScenes(scene4);
        locations[2][0].setScenes(scene6);
        locations[2][1].setScenes(scene7);
        locations[2][2].setScenes(scene8);
        locations[2][3].setScenes(scene9);
        locations[2][4].setScenes(scene10);
        locations[2][5].setScenes(scene11);
        locations[2][6].setScenes(scene12);
        locations[2][7].setScenes(scene5);
        locations[3][0].setScenes(scene6);
        locations[3][1].setScenes(scene7);
        locations[3][2].setScenes(scene8);
        locations[3][3].setScenes(scene9);
        locations[3][4].setScenes(scene10);
        locations[3][5].setScenes(scene11);
        locations[3][6].setScenes(scene12);
        locations[3][7].setScenes(scene2);
        /*
        locations[1][7].setScenes(scenes[SceneType.finish.ordinal()]);
        locations[1][8].setScenes(scenes[SceneType.start.ordinal()]);
        locations[1][9].setScenes(scenes[SceneType.place.ordinal()]);
        locations[1][10].setScenes(scenes[SceneType.building.ordinal()]);
        locations[1][11].setScenes(scenes[SceneType.finish.ordinal()]);
        locations[1][12].setScenes(scenes[SceneType.start.ordinal()]);
        locations[1][13].setScenes(scenes[SceneType.place.ordinal()]);
        locations[1][14].setScenes(scenes[SceneType.building.ordinal()]);
        locations[1][15].setScenes(scenes[SceneType.finish.ordinal()]);
        locations[2][0].setActor(Actor.Donkey);
        locations[2][0].setScenes(scene3);
         */
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
        
    public static String[] getSortedStringList(String[] list) {
       //this function implements Insertion sort algorythm
        //InventoryItem[] originalInventoryList = Shrek.getCurrentGame().getInventory();
        //list originalList = Actor.values();
        //String actorList[]= new String [5];
        //for (Actor actor:originalList){
            //System.out.print(actor);
            //actorList[actor.ordinal()]=actor.name();
        //} 
        String[] tempList = list.clone();
        String temp;
        
        for(int i=0; i<tempList.length-1;i++) {
            for (int j=0;j<tempList.length-1-i;j++){
                if(tempList[j].compareToIgnoreCase(tempList[j+1])>0){
                              temp = tempList[j];
                              tempList[j]=tempList[j+1];
                              tempList[j+1]=temp;
                 }             
                          
                }
                
            }
        for(int i=1; i<tempList.length;i++)
           System.out.println(tempList[i]);
        return tempList;
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
        int gain = Shrek.getCurrentGame().getGain();
        boolean found=false;
          for (InventoryItem myItem:inventory) {
             //System.out.println(myItem.getInventoryType());
            if (myItem.getInventoryType()==value) {
              if(gain>= myItem.getInventoryCost()){
                found = true;
                myItem.setQuantityInStock(myItem.getQuantityInStock()+1);
                Shrek.getCurrentGame().setGain(-myItem.getInventoryCost());
               // System.out.println("sword ="+myItem.getQuantityInStock());
                System.out.println("One "+value+" is added to the Inventory List");
                quantity=myItem.getQuantityInStock();
                System.out.println("Now the "+value+" number is = "+quantity);
              }
            } 
          }
        if (found==false) {System.out.println("It is not possible to add one "+value+", please increase your gain");}
       return quantity;
      }
    }