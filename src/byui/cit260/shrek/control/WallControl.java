/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.control;
//import byui.cit260.shrek.model;

import byui.cit260.shrek.model.Wall;

/**
 *
 * @author bruno
 */
public class WallControl {
    public double calcLaunchHeightArrow(double slope, double distance){
            double height;
           // if (speed <= 0 || speed > 30){ return  -1; }
            if (slope <0 || slope > 90) { return  -1; }
            if (distance<10 || distance>50){ return  -1; }
            double evalTilt;
            evalTilt = Math.sin(Math.toRadians(slope));
            height = distance * evalTilt*Math.sqrt((1- evalTilt*evalTilt));
                
    return height;           
    }
    public int initializeWall(Wall gameWall, int numBricks){
            int errOut=0;
            if (numBricks <=0 || numBricks > 10) { return  -1; }
            gameWall.setBricksNum(numBricks);
            for (int i=0; i<numBricks; i++)
               gameWall.setBricks(i,1);
            return errOut;
    }
    public boolean isWallDestroyed(Wall gameWall){
            boolean wallBroken=false;
            int test;
            test=gameWall.getNumBricks();
            for (int i=0;i<gameWall.getNumBricks();i++)
                 {if (gameWall.getBricks(i)==0)
                     test--;}
            
            if(test==0) wallBroken=true;
            return wallBroken;
    }
    public boolean isWallBroken(double height){
            boolean wallBroken=false;
                      
            if(height>10) wallBroken=true;
            return wallBroken;
    }
   }
    
    



