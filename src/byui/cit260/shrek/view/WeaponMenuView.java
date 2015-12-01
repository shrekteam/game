/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

/**
 *
 * @author bruno
 */
//import byui.cit260.shrek.control.WeaponControl;
import byui.cit260.shrek.control.WeaponControl;
import byui.cit260.shrek.exceptions.WeaponControlException;
//import byui.cit260.shrek.control.WallControl;
//import byui.cit260.shrek.exceptions.PathwayControlException;

/**
 *
 * @author bruno
 */
public class WeaponMenuView extends View{
    
   
    public WeaponMenuView(){
    //private final String MENU="\n"
      
        super("\n"
    
    //public class WallMenuView {

    //  private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|         Princess rescueing adventure      |"
            +"\n----------------------------------------"
            +"\nThe goal of this adventure is to rescue the princess climbing to the tower"
            +"\nSo you have to choose the slope and the speed of the weapon to go over the tower. ");
            
    }
    @Override
    public void display() {
        
        double slope=0.0;
        double speed=0.0;
        boolean repeatDisplay=false;
        //System.out.println(MENU);
        System.out.println(super.getPromptMessage());
        do {
            System.out.println("Insert the slope within O to 90 degrees:");  
            try{
            slope = Double.parseDouble(this.getInput());
            }catch(NumberFormatException nf) {
            System.out.println("Enter a valid number");return;}
            catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            return;
            }
            
            //System.out.println(MENUslope);
            //slope = Double.valueOf(this.getInput());
            System.out.println("Insert the speed within 1 m/s and 20 m/s:");
            try{
            speed = Double.parseDouble(this.getInput());
            }catch(NumberFormatException nf) {
            System.out.println("Enter a valid number");return;}
            catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            return;}
            
            repeatDisplay=this.doAction(slope,speed);}
            
            
            //System.out.println(MENUdistance);
            //speed = Double.valueOf(this.getInput());
            //selection = input.charAt(0);
            
        while(repeatDisplay==true);
    }
    
    @Override
    public boolean doAction(Object obj) {return false;}
    
    public boolean doAction(Object obj, Object obj2) {
    double mySlope=(double)obj;
    double mySpeed=(double)obj2;
    
    boolean repeat=true;    
    
      WeaponControl myWeaponControl = new WeaponControl();
      double myHeight=0.0;
       try {
       myHeight = myWeaponControl.calcLaunchHeight(mySpeed, mySlope);
       } catch(WeaponControlException wce) {
               System.out.println(wce.getMessage());
       }
     
       myHeight=Math.round(myHeight*100);
       myHeight=myHeight/100;
       System.out.println("The height is: "+myHeight);
    
       if (myHeight>10)
        {System.out.println("\nYou climbed the tower!!");
        repeat=false;
        }
        else {System.out.println("\nRetry values because the height must be > 10m !!");}
    return repeat;
    
    }
    
}   

