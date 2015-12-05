/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import java.io.Serializable;

/**
 *
 * @author bruno
 */
public class Map implements Serializable{
   

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(int noOfColumns) {
        this.noOfColumns = noOfColumns;
    }
    
    private int noOfRows;
    private int noOfColumns;
    private Location[][] locations;
    
    public Map(int noOfRows, int noOfColumns){
        if(noOfRows<1||noOfColumns<1){
            System.out.println("The number of rows and columns must be >0");
            return;
            }
        this.noOfRows=noOfRows;
        this.noOfColumns=noOfColumns;
        this.locations=new Location[noOfRows][noOfColumns];
       for(int row=0;row<noOfRows; row++){
        for (int column = 0;column<noOfColumns;column++){
            Location location = new Location ();
            location.setColumn(column);
            location.setRow(row);
            location.setVisited(false);
            locations[row][column]= location;
         }
       }
    }

    public Location[][] getLocations() {
        return locations;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
