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
public class WallControlTest {
    
    public WallControlTest() {
    }

    /**
     * Test of calcThrowArrowHeight method, of class WallControl.
     */
    @Test
    public void testCalcLaunchHeightArrow() {
        System.out.println("calcLaunchHeightArrow1");
        double slope = 30.0;
        double distance = 20.0;
        WallControl instance = new WallControl();
        double expResult = 8.6602;
        double result = instance.calcLaunchHeightArrow(slope, distance);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcLaunchHeightArrow2");
        slope = 30.0;
        distance = 10.0;
        expResult = 4.3301;
        result = instance.calcLaunchHeightArrow(slope, distance);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcLaunchHeightArrow3");
        slope = 100.0;
        distance = 10.0;
        expResult = -1;
        result = instance.calcLaunchHeightArrow(slope, distance);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcLaunchHeightArrow4");
        slope = 90.0;
        distance = 20.0;
        expResult = 0;
        result = instance.calcLaunchHeightArrow(slope, distance);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcLaunchArrowHeight5");
        slope = 0.0;
        distance = 40.0;
        expResult = 0;
        result = instance.calcLaunchHeightArrow(slope, distance);
        assertEquals(expResult, result, 0.0001);
                
    }
    
}
