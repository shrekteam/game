/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author bruno
 */
public enum Actor implements Serializable {

    Ogre(" "),
    SoldierHead(""),
    Warrior(""),
    Farquaad("the Prince"),
    Soldier("He is an army soldier");
    
    private final String description;
    private final Point coordinates;
    
    Actor(String description){
        this.description=description;
        coordinates=new Point(1,1);
    }
    public String getDescription(){
     return description;   
    }
    public Point getCoordinates(){
     return coordinates;    
    }        
    }
    
    

