/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author bruno
 */
public class Location implements Serializable{
    private int row;
    private int column;
    private boolean visited;
    private Scene scene;
    private ArrayList<Actor> actors;
    private Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
    
    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", scene=" + scene + ", actors=" + actors + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.row;
        hash = 97 * hash + this.column;
        hash = 97 * hash + (this.visited ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.scene);
        hash = 97 * hash + Objects.hashCode(this.actors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        return true;
    }
    

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
  

    public void setColumn(int column) {
        this.column= column;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setVisited(boolean b) {
        this.visited=b;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean isVisited() {
        return visited;
    }
       

    public void setScenes(Scene scene) {
        this.scene=scene;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Scene getScene() {
        return scene;
    }
    
}
