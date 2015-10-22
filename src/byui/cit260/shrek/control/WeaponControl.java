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
public class WeaponControl {
    public double calcThrowArrowHeight(double speed, double slope){
            final double GRAVITY=9.80665;
            //gravity acceleration
          
            double height;
            double evalTilt;
           // if (speed <= 0 || speed > 30){ return  -1; }
            if (speed<0 || speed > 10) { return  -1; }
            if (slope<0 || slope>90){ return  -1; }
            evalTilt = Math.sin(Math.toRadians(slope));
            height = speed * speed * evalTilt * evalTilt/(2*GRAVITY);
            return height;
        
    }
    
}
