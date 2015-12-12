
package byui.cit260.shrek.control;

import byui.cit260.shrek.model.Actor;
import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.model.Map;
import byui.cit260.shrek.model.Scene;
import byui.cit260.shrek.model.SceneType;
import byui.cit260.shrek.exceptions.MapControlException;
import byui.cit260.shrek.model.InventoryItem;
import java.awt.Point;
import shrek.Shrek;

/**
 *
 * @author bruno
 */

public class MapControl {
    
    public static Map createMap() {
        //Map map = new Map(20,20);
        Map map = new Map(20,20);
        Scene[] scenes= createScenes();
        GameControl.assignScenesToLocations(map,scenes);
        return map;
    }
public static int moveActorToLocation (Actor actor, Point coordinates)
                throws MapControlException{
    
        Map map = Shrek.getCurrentGame().getMap();
        int newRow=coordinates.x-1;
        int newColumn=coordinates.y-1;
        
        if(newRow<0||newColumn<0||newColumn>=map.getNoOfColumns()||newRow>=map.getNoOfRows()){
                throw new MapControlException("Can not move actor to location"
                           +coordinates.x+ ","+coordinates.y
                               +"because that location is outside "
                                +"the bounds of the map");
       //else()
       // return 0;
        }
             return 1;
}
    public static void moveActorsToStartingLocation(Map map)
//throw new UnsupportedOperationException("Not supported yet.");
              throws MapControlException{
        Actor[] actors=Actor.values();
        for (Actor actor:actors){
            Point coordinates=actor.getCoordinates();
            MapControl.moveActorToLocation(actor, coordinates);
            
          //  int returnValue=MapControl.moveActorToLocation(actor, coordinates);
          //  if (returnValue<0) {
        //        return returnValue;
            }
            
        }
       // return 0;
      
    
    public static Scene[] createScenes(){
        Game game = Shrek.getCurrentGame();
        Scene[] scenes = new Scene[SceneType.values().length];
        Scene startingScene = new Scene();
        startingScene.setDescription(
         "\nThe land of the Lord Farquaad");
        startingScene.setMapSymbol("ST");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        startingScene.setMoney(10);
        scenes[SceneType.start.ordinal()]=startingScene;
        
        Scene secondScene = new Scene();
        secondScene.setDescription(
         "\nAnd we escaped from the dragon");
        secondScene.setMapSymbol("PL");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(200);
        startingScene.setMoney(15);
        scenes[SceneType.place.ordinal()]=secondScene;
        
        Scene thirdScene = new Scene();
        thirdScene.setDescription(
         "\nAnd we did come to the tower");
        thirdScene.setMapSymbol("BU");
        thirdScene.setBlocked(false);
        thirdScene.setTravelTime(200);
        startingScene.setMoney(13);
        scenes[SceneType.building.ordinal()]=thirdScene;
        
        Scene finishScene=new Scene();
        finishScene.setDescription(
                "\nCongratulation! you finished the game ");
        finishScene.setMapSymbol("FI");
        finishScene.setBlocked(false);
        startingScene.setMoney(15);
        finishScene.setTravelTime((int) Double.POSITIVE_INFINITY);
        scenes[SceneType.finish.ordinal()]=finishScene;
        return scenes;
    }
    public static Scene[] getSortedSceneList(){
       //this function implments bubblesort, but I use the next function, InsertionSort
        //InventoryItem[] originalInventoryList = Shrek.getCurrentGame().getInventory();
        Scene[] originalScene=MapControl.createScenes();
        Scene[] sortedScene = originalScene.clone();
        Scene temp;
        for(int i=0; i<sortedScene.length-1;i++) {
            for (int j=0;j<sortedScene.length-1-i;j++){
                if(sortedScene[j].getMoney()>sortedScene[j+1].getMoney()){
                        
                        
                            temp = sortedScene[j];
                            sortedScene[j]= sortedScene[j+1];
                            sortedScene[j+1]= temp;
                }
                
            }
        }
               
        return sortedScene;
    }
}
