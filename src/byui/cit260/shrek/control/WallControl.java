/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.control;

/**
 *
 * @author bruno
 */
public class WallControl {
    public double calcThrowArrowHeight(double slope, double distance){
            double height;
           // if (speed <= 0 || speed > 30){ return  -1; }
            if (slope <0 || slope > 90) { return  -1; }
            if (distance<10 || distance>50){ return  -1; }
            double evalTilt;
            evalTilt = Math.sin(Math.toRadians(slope));
            height = distance * evalTilt*Math.sqrt((1- evalTilt*evalTilt));
                
    return height;           
    }
   }
    
    

