/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

/**
 *
 * @author bruno
 */
public class Scene {
    private String description;
    private String mapSymbol;
    private boolean blocked;
    private int travelTime;
    public void setDescription(String string) {
        this.description=string;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        return description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String st) {
        this.mapSymbol=st;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBlocked(boolean b) {
        this.blocked =b;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTravelTime(int i) {
        this.travelTime=i;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
