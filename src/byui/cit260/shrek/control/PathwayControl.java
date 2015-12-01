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
import byui.cit260.shrek.exceptions.PathwayControlException;
public class PathwayControl {
    public double calcJumpDistance(double speed, double slope )throws PathwayControlException{
        final double GRAVITY=9.80665;
        double distance;
        double evalTilt;
            //gravity acceleration
         if (speed<0 || speed > 10 ||slope<0 || slope>90) { 
         throw new PathwayControlException("Speed must be between 0 and 10,"
                 + " Slope between 0 and 90, please input right values");}
               
         //if (slope<0 || slope>90){ return  -1; }
         evalTilt = Math.sin(Math.toRadians(2*slope));
         distance = (speed * speed * evalTilt) / GRAVITY ;
//this is the maximum distance in the parabolic motion
return distance;
   
  }
}

