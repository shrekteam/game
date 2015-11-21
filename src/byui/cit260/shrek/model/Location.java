/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Location {
    private int row;
    private int column;
    private boolean visited;
    private Scene scene;
    private ArrayList<Actor> actors;
    
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
