/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author bruno
 */
public class Scene implements Serializable{
    private String description;
    private String mapSymbol;
    private boolean blocked;
    private int travelTime;

    public Scene() {
    }

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", mapSymbol=" + mapSymbol + ", blocked=" + blocked + ", travelTime=" + travelTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.mapSymbol);
        hash = 97 * hash + (this.blocked ? 1 : 0);
        hash = 97 * hash + this.travelTime;
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        if (this.travelTime != other.travelTime) {
            return false;
        }
        return true;
    }
    
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
