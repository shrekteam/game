/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.control.PathwayControl;
//import byui.cit260.shrek.control.WallControl;
import byui.cit260.shrek.exceptions.PathwayControlException;

/**
 *
 * @author bruno
 */
public class PathwayMenuView extends View{
    
   
    public PathwayMenuView(){
    //private final String MENU="\n"
      
        super("\n"
    
    //public class WallMenuView {

    //  private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|         Dragon escaping adventure      |"
            +"\n----------------------------------------"
            +"\nThe goal of this adventure is to escape from the dragon jumping on pathway"
            +"\nSo you have to choose the slope and the speed of the jump. ");
            
    }
    @Override
    public void display() {
        
        
        boolean repeatDisplay=false;
        //System.out.println(MENU);
        System.out.println(super.getPromptMessage());
        double slope=0.0;
        double speed=0.0;
        do {
            
            System.out.println("Insert the slope within O to 90 degrees:");      
            //System.out.println(MENUslope);
            try{
            slope = Double.parseDouble(this.getInput());
            }catch(NumberFormatException nf) {
            System.out.println("You must enter a valid number");
            return;}
            catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            return;
            }
            
            //slope = Double.valueOf(this.getInput());
            System.out.println("Insert the speed within 1 m/s and 10 m/s:");
            try{
            speed = Double.parseDouble(this.getInput());
            }catch(NumberFormatException nf) {
            System.out.println("You must enter a valid number");return;}
            catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            return;
            }
            
            //System.out.println(MENUdistance);
            //speed = Double.valueOf(this.getInput());
            //selection = input.charAt(0);
            repeatDisplay=this.doAction(slope,speed);
        } while(repeatDisplay==true);
    }
    
    @Override
    public boolean doAction(Object obj) {return false;}
    
    public boolean doAction(Object obj, Object obj2) {
    double mySlope=(double)obj;
    double mySpeed=(double)obj2;
    
    boolean repeat=true;    
    
      PathwayControl myPathwayControl = new PathwayControl();
      double myDistance=0.0;
       try {
       myDistance = myPathwayControl.calcJumpDistance(mySpeed, mySlope);
       }catch(PathwayControlException pce) {
               System.out.println(pce.getMessage());
       }
     
       myDistance=Math.round(myDistance*100);
       myDistance=myDistance/100;
       System.out.println("The distance is: "+myDistance);
    
       if (myDistance>10)
        {System.out.println("\nYou escaped from the dragon!!");
        repeat=false;
        }
        else {System.out.println("\nRetry values because the distance must be > 10m !!");}
    return repeat;
    
    }
    
}   
