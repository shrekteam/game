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
import byui.cit260.shrek.exceptions.WallControlException;
import byui.cit260.shrek.model.Wall;

public class WallMenuView extends View{
    
    public WallMenuView(){
    //private final String MENU="\n"
        super("\n"
    
//public class WallMenuView {

    //  private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|         Wall breaking adventure      |"
            +"\n----------------------------------------"
            +"\nThe goal of this adventure is  to break the wall launching an arrow."
            +"\nSo you have to choose the slope and the distance of the launch. "
            +"\nIf the launch height is more than 10 meters you break the wall ");
    }    
    private final String MENUslope=     
            "Insert the slope within O to 90 degrees or enter E to Exit";
          
    private final String MENUdistance=     
            "Insert the distance within 10 and 50 meters or enter E to Exit";
    @Override
    public void display() {
        
        double slope=0;
        double distance=0;
        boolean repeatDisplay=false;
        //System.out.println(MENU);
        System.out.println(super.getPromptMessage());
        do {
          boolean value1=true;
          boolean value2=true;
          while(value1==true) { 
            System.out.println(MENUslope);
            String value = this.getInput();
            if (value.equals("E")||value.equals("e"))return;
            try{
            slope = Double.parseDouble(value);
            value1=false;
            }catch(NumberFormatException nf) {
                System.out.println("You must enter a valid number.Try again or enter E to Exit");
                //System.out.println(MENUslope);
                
            }
            catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            //return;
            }
          }
          while(value2==true) {
            System.out.println(MENUdistance);
            String value = this.getInput();
            if (value.equals("E")||value.equals("e"))return;
            try{
            distance = Double.parseDouble(value);
            value2=false;
            }catch(NumberFormatException nf) {
                System.out.println("You must enter a valid number.Try again or enter E to Exit");
                
                //return;
            }
            catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            //return;
            }
          }
            //selection = input.charAt(0);
            repeatDisplay=this.doAction(slope,distance);
        } while(repeatDisplay==true);
    }
 /*
    private String getInput() {
        
        boolean valid=false;
        String value=null;
        Scanner keyboard = new Scanner(System.in);
        while(!valid){
            System.out.println("Enter the value");
            value=keyboard.nextLine();
            value=value.trim();
            //if value.parseDouble(value)
            if(value.length()<1) {
                System.out.println("Invalid value-it must not be blank");
                continue;}
            break;
            }
        return value;
        }
   */ @Override
    public boolean doAction(Object obj) {return false;}
    
    public boolean doAction(Object obj, Object obj2) {
    double mySlope=(double)obj;
    double myDistance=(double)obj2;
    
    boolean repeat=true;    
    double myHeight=0;
       WallControl myWallControl = new WallControl();
       try {
       myHeight= myWallControl.calcLaunchHeightArrow(mySlope, myDistance);
       }catch(WallControlException wce) {
               System.out.println(wce.getMessage());
       }
       //myHeight1=1000*myHeight;
       myHeight=Math.round(myHeight*100);
       myHeight=myHeight/100;
       System.out.println("The height is: "+myHeight);
       if (myWallControl.isWallBroken(myHeight)==false)
           System.out.println("Please choose again the slope and the distance to have an height >10 meters");
              
       else {System.out.println("You broke the wall and Shrek enters the town!!!"); 
             repeat=false;}
       return repeat;
    
    }
 }
    
