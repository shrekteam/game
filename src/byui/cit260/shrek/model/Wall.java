/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author bruno
 */
public class Wall implements Serializable{
    private int bricksNum;
    private int bricks[] = {0,0,0,0,0,0,0,0,0,0};
    public Wall(){
        this.bricksNum=10;
       
    }

    @Override
    public String toString() {
        return "Wall{" + "bricksNum=" + bricksNum + ", bricks=" + bricks + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.bricksNum;
        hash = 11 * hash + Arrays.hashCode(this.bricks);
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
        final Wall other = (Wall) obj;
        if (this.bricksNum != other.bricksNum) {
            return false;
        }
        if (!Arrays.equals(this.bricks, other.bricks)) {
            return false;
        }
        return true;
    }
    
      public void setBricksNum(int numb) {
        this.bricksNum = numb;}
      public int getNumBricks() {
        return bricksNum;}
      public void setBricks(int element, int value) {
        this.bricks[element] = value;
      }
      public int getBricks(int element) {
        return this.bricks[element];}
    }
    

