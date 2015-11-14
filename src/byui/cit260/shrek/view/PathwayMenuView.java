/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.control.WallControl;

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
        
        double slope;
        double speed;
        boolean repeatDisplay=false;
        //System.out.println(MENU);
        System.out.println(super.getPromptMessage());
        do {
            System.out.println("Insert the slope within O to 90 degrees:");      
            //System.out.println(MENUslope);
            slope = Double.valueOf(this.getInput());
            System.out.println("Insert the speed within 1 m/s and 10 m/s:");
            //System.out.println(MENUdistance);
            speed = Double.valueOf(this.getInput());
            //selection = input.charAt(0);
            repeatDisplay=this.doAction(slope,speed);
        } while(repeatDisplay==true);
    }
    
    @Override
    public boolean doAction(Object obj, Object obj2) {
    double mySlope=(double)obj;
    double mySpeed=(double)obj2;
    
    boolean repeat=true;    
    double myDistance=10;
    double prod=mySlope*mySpeed;
    if (prod>10)
        {System.out.println("\nYou escaped from the dragon!!");
        repeat=false;
        }
    else {System.out.println("\nRetry values !!");}
        
    //private final String MENUslope="Insert the slope within O to 90 degrees:";
    //System.out.println("Insert the slope within O to 90 degrees:");      
    //private final String MENUspeed= "Insert the speed within 1 m/s and 10 m/s:";
    //System.out.println("Insert the speed within 1 m/s and 10 m/s:");
       /*
       WallControl myWallControl = new WallControl();
       myHeight= myWallControl.calcLaunchHeightArrow(mySlope, myDistance);
       //myHeight1=1000*myHeight;
       myHeight=Math.round(myHeight*100);
       myHeight=myHeight/100;
       System.out.println("The height is: "+myHeight);
       if (myWallControl.isWallBroken(myHeight)==false)
           System.out.println("Please choose again the slope and the distance to have an height >10 meters");
              
       else {System.out.println("You broke the wall and Shrek enters the town!!!"); 
             repeat=false;}
       */
       return repeat;
    
    }
    
}   
