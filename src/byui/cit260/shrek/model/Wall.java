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
public class Wall {
    private int bricksNum;
    private int bricks[] = {0,0,0,0,0,0,0,0,0,0};
    public Wall(){
        this.bricksNum=10;
       
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
    

