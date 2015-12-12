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

    Ogre("He is the ogre and leader of adventures"),
    SoldierHead("He is Shrek's adventure friend"),
    Prince("She is the princess and she is to rescueing"),
    Farquaad("He is the Lord of the land"),
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
    
    

