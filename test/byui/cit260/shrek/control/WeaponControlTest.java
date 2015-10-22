/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bruno
 */
public class WeaponControlTest {
    
    public WeaponControlTest() {
    }

    /**
     * Test of calcThrowArrowHeight method, of class WeaponControl.
     */
    @Test
    public void testCalcLaunchHeight() {
        System.out.println("calcLaunchHeight1");
        double speed = 3.0;
        double slope = 20.0;
        WeaponControl instance = new WeaponControl();
        double expResult = 0.05367;
        double result = instance.calcLaunchHeight(speed, slope);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("calcLaunchHeight2");
        speed = 1.0;
        slope = 30.0;
        //WeaponControl instance = new WeaponControl();
        expResult = 0.0127;
        result = instance.calcLaunchHeight(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcLaunchHeight3");
        speed = 11.0;
        slope = 80.0;
        expResult = -1;
        result = instance.calcLaunchHeight(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcLaunchHeight4");
        speed = -1;
        slope = 100.0;
        expResult = -1;
        result = instance.calcLaunchHeight(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcLaunchHeight5");
        speed = 0.0;
        slope = 90.0;
        expResult = 0;
        result = instance.calcLaunchHeight(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcLaunchHeight6");
        speed = 10.0;
        slope = 0.0;
        expResult = 0;
        result = instance.calcLaunchHeight(speed, slope);
        assertEquals(expResult, result, 0.0001);
    }
    
}
