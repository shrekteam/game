/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import byui.cit260.shrek.control.MapControl;
import java.io.Serializable;

/**
 *
 * @author bruno
 */
public class Game implements Serializable{
    private Player player;
    private Pathway pathway;
    private Wall wall;
    private Weapon weapon;
    private InventoryItem[] inventory;
    private Map map;

    public void setPlayer(Player player) {
        this.player=player; 
        
        //System.out.println("ok player");
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Player getPlayer() {
        return player;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public Pathway getPathway() {
        return pathway;
    }

    public void setPathway(Pathway pathway) {
        this.pathway = pathway;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    
    

    public void setMap(MapControl map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMap(Map map) {
        this.map = map;
    }   
    public Map getMap() {
        return map; 
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setInventory(InventoryItem[] inventoryList) {
        this.inventory=inventoryList;
        //System.out.println("ok inventory");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InventoryItem[] getInventory() {
        return inventory;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
