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
    /****
     * @author Kevin Gray
     */
    public void testcalcApplyWeapon() {
        System.out.println("calcApplyWeapon1");
        double mass = 2;
        double speed = 30;
        double targetHP = 150;
        double resist = .1;
        WeaponControl instance = new WeaponControl();
        double result = instance.calcApplyWeapon(mass, speed, targetHP, resist);
        System.out.println(result);
        double expResult = 96;
        assertEquals(expResult, result, 0.01);
       
        System.out.println("calcApplyWeapon2");
        mass= -3;
        speed = 3;
        targetHP = 100;
        resist = .5;
        result = instance.calcApplyWeapon(mass, speed, targetHP, resist);
        System.out.println(result);
        expResult = -1;
        assertEquals(expResult, result, 0.01);
        
        System.out.println("calcApplyWeapon3");
        mass= 3;
        speed = 30;
        targetHP = 89;
        resist = 1.5;
        result = instance.calcApplyWeapon(mass, speed, targetHP, resist);
        System.out.println(result);
        expResult = -1;
        assertEquals(expResult, result, 0.01);
        
        System.out.println("calcApplyWeapon4");
        mass= 3;
        speed = 30;
        targetHP = 0;
        resist = .23;
        result = instance.calcApplyWeapon(mass, speed, targetHP, resist);
        System.out.println(result);
        expResult = -1;
        assertEquals(expResult, result, 0.01);

        
        System.out.println("calcApplyWeapon5");
        mass= 10000;
        speed = 10000;
        targetHP = .1;
        resist = 0;
        result = instance.calcApplyWeapon(mass, speed, targetHP, resist);
        System.out.println(result);
        expResult = 0;
        assertEquals(expResult, result, 0);
        
        System.out.println("calcApplyWeapon6");
        mass= .1;
        speed = .1;
        targetHP = 10000;
        resist = .99;
        result = instance.calcApplyWeapon(mass, speed, targetHP, resist);
        System.out.println(result);
        expResult = 0.99;
        assertEquals(expResult, result, 9999.99);
        
        System.out.println("calcApplyWeapon7");
        mass= .1;
        speed = .1;
        targetHP = .1;
        resist = 0;
        result = instance.calcApplyWeapon(mass, speed, targetHP, resist);
        System.out.println(result);
        expResult = .09;
        assertEquals(expResult, result, 0.0001);
 
        
        
    }
    
}
