/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.control;

import byui.cit260.shrek.exceptions.WeaponControlException;

/**
 *
 * @author bruno
 */
public class WeaponControl {
    public double calcLaunchHeight(double speed, double slope)throws WeaponControlException{
            final double GRAVITY=9.80665;
            //gravity acceleration
          
            double height=0.0;
            double evalTilt=0.0;
            if (speed<0 || speed > 20|| slope<0 || slope>90){throw new 
        WeaponControlException("Slope must be between 0 and 90,Speed must be between 0 and 20, please input right values");}
            //slope is in degrees
            evalTilt = Math.sin(Math.toRadians(slope));
            height = speed * speed * evalTilt * evalTilt/(2*GRAVITY);
            return height;
    }
        
    /****
    * CALC APPLY WEAPON
    * 
    * Parameters:
    *     mass: mass of weapon in kg
    *     speed: speed of weapon in m/s
    *     targetHP: hit points to dislodge target
    * Return:
    *     adjusted hit points of target
    * 
    * @author Kevin Gray
    ****/
    public double calcApplyWeapon(double mass, double speed, double targetHP, double resist) {
        // validate
        if (mass <= 0 ||    
                speed <= 0 ||
                targetHP <= 0)
            return -1;
        if (resist < 0 ||
            resist >= 1)
            return -1;
        
        // body
        double adjustedHP;
        adjustedHP = (targetHP) - mass * speed * (1 - resist);
        if (adjustedHP < 0)
            adjustedHP = 0;
       
        return adjustedHP;
    }
}
        
        
           
    
    

