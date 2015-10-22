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
public class PathwayControlTest {
    
    public PathwayControlTest() {
    }

    /**
     * Test of calcJumpDistance method, of class PathwayControl.
     */
    @Test
    public void testCalcJumpDistance() {
        System.out.println("calcJumpDistance1");
        double speed = 2.3;
        double slope = 20.0;
        PathwayControl instance = new PathwayControl();
        double expResult = 0.3467;
        double result = instance.calcJumpDistance(speed, slope);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("calcJumpDistance2");
        speed = 1.0;
        slope = 15.0;
        //PathwayControl instance = new PathwayControl();
        expResult = 0.0509;
        result = instance.calcJumpDistance(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcJumpDistance3");
        speed = 11.0;
        slope = 80.0;
        //PathwayControl instance = new PathwayControl();
        expResult = -1;
        result = instance.calcJumpDistance(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcJumpDistance4");
        speed = -1.0;
        slope = 100.0;
        //PathwayControl instance = new PathwayControl();
        expResult = -1;
        result = instance.calcJumpDistance(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcJumpDistance5");
        speed = 0.0;
        slope = 90.0;
        //PathwayControl instance = new PathwayControl();
        expResult = 0.0;
        result = instance.calcJumpDistance(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcJumpDistance6");
        speed = 10.0;
        slope = 0.0;
        //PathwayControl instance = new PathwayControl();
        expResult = 0.0;
        result = instance.calcJumpDistance(speed, slope);
        assertEquals(expResult, result, 0.0001);
        
        
    }
    
}
