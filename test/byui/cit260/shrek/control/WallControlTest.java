/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.control;

import byui.cit260.shrek.model.Wall;
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
    @Test
    public void testInitializeWall() {
                
        System.out.println("initializeWall1");
        WallControl instance = new WallControl();
        int numBricks = 5;
        Wall myWall = new Wall();
        int expResult2 = 0;
        int result2 = instance.initializeWall(myWall,numBricks);
        assertEquals(expResult2, result2, 0.0001);
        
        System.out.println("initializeWall2");
        numBricks = 2;
        //Wall myWall = new Wall();
        expResult2 = 0;
        result2 = instance.initializeWall(myWall,numBricks);
        assertEquals(expResult2, result2, 0.0001);
        
        System.out.println("initializeWall3");
        numBricks = 11;
        //Wall myWall = new Wall();
        expResult2 = -1;
        result2 = instance.initializeWall(myWall,numBricks);
        assertEquals(expResult2, result2, 0.0001);
        
        System.out.println("initializeWall4");
        numBricks = 10;
        //Wall myWall = new Wall();
        expResult2 = 0;
        result2 = instance.initializeWall(myWall,numBricks);
        assertEquals(expResult2, result2, 0.0001);
     }   
    @Test
    public void isWallDestroyed() {
        
        System.out.println("isWallDestroyed1");
        WallControl instance = new WallControl();
        Wall myWall2 = new Wall();
        myWall2.setBricks(0, 1);
        myWall2.setBricks(1, 1);
        myWall2.setBricks(3, 1);
        myWall2.setBricks(4, 1);
        myWall2.setBricksNum(5);
        boolean resultE = false;
        boolean resultW = instance.isWallDestroyed(myWall2);
        int expResult3=0;
        int result3=0;
        if (resultE==true) expResult3=1;
        if (resultW==true) result3=1;
        assertEquals(expResult3, result3, 0.0001);
        
        System.out.println("isWallDestroyed2");
        Wall myWall3 = new Wall();        
        myWall3.setBricksNum(2);
        resultE = true;
        resultW = instance.isWallDestroyed(myWall3);
        expResult3=0;
        result3=0;
        if (resultE==true) expResult3=1;
        if (resultW==true) result3=1;
        assertEquals(expResult3, result3, 0.0001);
        
    }   
    
    
}
