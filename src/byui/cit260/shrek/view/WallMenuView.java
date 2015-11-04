/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;
import byui.cit260.shrek.control.GameControl;
import static byui.cit260.shrek.view.GameMenuView.gameMenu;
import java.util.Scanner;
import shrek.Shrek;
import byui.cit260.shrek.control.WallControl;
import byui.cit260.shrek.model.Wall;

public class WallMenuView {
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
     private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|         Wall breaking adventure      |"
            +"\n----------------------------------------"
            +"\nThe goal of this adventure is  to break the wall launching an arrow."
            +"\nSo you have to choose the slope and the distance of the launch. "
            +"\nIf the launch height is more than 10 meters you break the wall ";
    private final String MENUslope=     
            "Insert the slope within O to 90 degrees:";
            
 
    private final String MENUdistance=     
            "Insert the distance within 10 and 50 meters:";
    
    void displayMenu() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("***MainMenuView.displayMenu() function called");
        //char selection=' ';
        double slope;
        double distance;
        boolean repeatDisplay=false;
        System.out.println(MENU);
        do {
            
            
            System.out.println(MENUslope);
            slope = Double.valueOf(this.getInput());
            System.out.println(MENUdistance);
            distance = Double.valueOf(this.getInput());
            //selection = input.charAt(0);
            repeatDisplay=this.doAction(slope,distance);
        } while(repeatDisplay==true);
    }
 
    private String getInput() {
        //To change body of generated methods, choose Tools | Templates.
        boolean valid=false;
        String value=null;
        Scanner keyboard = new Scanner(System.in);
        while(!valid){
            System.out.println("Enter the value");
            value=keyboard.nextLine();
            value=value.trim();
            if(value.length()<1) {
                System.out.println("Invalid value-it must not be blank");
                continue;}
            break;
            }
        return value;
        }
    

    private boolean doAction(double mySlope, double myDistance) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    boolean repeat=true;    
    double myHeight;
    double myHeight1;
    double myHeight2;
       WallControl myWallControl = new WallControl();
       myHeight= myWallControl.calcLaunchHeightArrow(mySlope, myDistance);
       //myHeight1=1000*myHeight;
       myHeight=Math.round(myHeight*100);
       myHeight=myHeight/100;
       System.out.println("The height is: "+myHeight);
       if (myWallControl.isWallBroken(myHeight)==false)System.out.println("Please choose again the slope and the distance to have an height >10 meters");
       //if (myHeight<=10)System.out.println("Please choose again the slope and the distance to have an height >10 meters");
       
       else {System.out.println("You broke the wall and Shrek enters the town!!!"); 
             repeat=false;}
       return repeat;
    
    }
 }
    
