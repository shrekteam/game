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
    private int gain;
    private boolean winPathway=false;
    private boolean winWeapon=false;
    private boolean winWall=false;

    public int getGain() {
        return gain;
    }

    public boolean isWinPathway() {
        return winPathway;
    }

    public void setWinPathway(boolean winPathway) {
        this.winPathway = winPathway;
    }

    public boolean isWinWeapon() {
        return winWeapon;
    }

    public void setWinWeapon(boolean winWeapon) {
        this.winWeapon = winWeapon;
    }

    public boolean isWinWall() {
        return winWall;
    }

    public void setWinWall(boolean winWall) {
        this.winWall = winWall;
    }

    public void setGain(int gain) {
        this.gain = gain+this.gain;
    }

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
