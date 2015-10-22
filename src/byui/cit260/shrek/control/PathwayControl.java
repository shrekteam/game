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
public class PathwayControl {
    public double calcJumpDistance(double speed, double slope ){
        final double GRAVITY=9.80665;
        double distance;
        double evalTilt;
            //gravity acceleration
         if (speed<0 || speed > 10) { return  -1; }
         if (slope<0 || slope>90){ return  -1; }
         evalTilt = Math.sin(Math.toRadians(2*slope));
         distance = (speed * speed * evalTilt) / GRAVITY ;
//this is the maximum distance in the parabolic motion
return distance;

    }
    
}
