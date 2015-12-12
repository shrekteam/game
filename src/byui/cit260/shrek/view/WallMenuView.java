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
import byui.cit260.shrek.model.InventoryItem;
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
            +"\nThe goal of this adventure is to break the wall launching an arrow."
            +"\nSo you have to choose the slope and the distance of the launch. "
            +"\nIf the launch height is more than 10 meters you break the wall"
                + "\nThe number of trying is your spears number ");
    }    
    private final String MENUslope=     
            "Insert the slope within O to 90 degrees or enter E to Exit";
          
    private final String MENUdistance=     
            "Insert the distance within 10 and 50 meters or enter E to Exit";
    @Override
    public void display() {
      InventoryItem[] inventory = Shrek.getCurrentGame().getInventory(); 
      int numberItem=0;
      for (InventoryItem myItem:inventory) {
            if (myItem.getInventoryType()=="Spear") {
                numberItem=myItem.getQuantityInStock();
        this.console.println("Your number of spears is "+numberItem);
       if (numberItem>0){   
        int numberIteration=0;
        
        double slope=0;
        double distance=0;
        boolean repeatDisplay=false;
        //System.out.println(MENU);
        this.console.println(super.getPromptMessage());
        do {
            numberIteration++;
          boolean value1=true;
          boolean value2=true;
          while(value1==true) { 
            this.console.println(MENUslope);
            String value = this.getInput();
            if (value.equals("E")||value.equals("e"))return;
            try{
            slope = Double.parseDouble(value);
            value1=false;
            }catch(NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),"You must enter a valid number.Try again or enter E to Exit");
                //System.out.println(MENUslope);
                
            }
            catch (Throwable te){
            ErrorView.display(this.getClass().getName(),te.getMessage());
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
                ErrorView.display(this.getClass().getName(),"You must enter a valid number.Try again or enter E to Exit");
                
                //return;
            }
            catch (Throwable te){
            ErrorView.display(this.getClass().getName(),te.getMessage());
            te.printStackTrace();
            //return;
            }
          }
            //selection = input.charAt(0);
            repeatDisplay=this.doAction(slope,distance);
        
         myItem.setQuantityInStock(numberItem-1);
         numberItem--;
        } while(repeatDisplay==true && numberIteration<=numberItem);
     }else {System.out.println("Please purchase a spear");}
    }
   }
  }
  @Override
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
               ErrorView.display(this.getClass().getName(),wce.getMessage());
       }
       //myHeight1=1000*myHeight;
       myHeight=Math.round(myHeight*100);
       myHeight=myHeight/100;
       this.console.println("The height is: "+myHeight);
       if (myWallControl.isWallBroken(myHeight)==false)
           this.console.println("Please choose again the slope and the distance to have an height >10 meters");
              
       else {this.console.println("You broke the wall and Shrek enters the town!!!"); 
            Shrek.getCurrentGame().setWinWall(true);
        if(Shrek.getCurrentGame().isWinWeapon()&&Shrek.getCurrentGame().isWinPathway())
         {this.console.println("\nYou win the game!!");
         repeat=false;
         } 
             repeat=false;}
       return repeat;
    
    }
 }
    
