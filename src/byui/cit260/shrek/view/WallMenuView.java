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
 

    private final String MENUslope=     
            "Insert the slope";
            /*
            + " \n"
            +"\n----------------------------------------"
            +"\n|            Main Menu                  |"
            +"\n----------------------------------------"
            +"\nN - Start new game"
            +"\nG - Get and start saved game"
            +"\nH - Get help on how to play the game"
            +"\nS - Save the game"
            +"\nE - Exit"
            +"\n----------------------------------------";
*/  
    private final String MENUdistance=     
            "Insert the distance";
    
    void displayMenu() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("***MainMenuView.displayMenu() function called");
        //char selection=' ';
        int slope;
        int distance;
        boolean repeatDisplay=false;
        do {
            System.out.println(MENUslope);
            slope = Integer.valueOf(this.getInput());
            System.out.println(MENUdistance);
            distance = Integer.valueOf(this.getInput());
            //selection = input.charAt(0);
            repeatDisplay=this.doAction(slope,distance);
        } while(slope==0 || distance==0 ||(repeatDisplay==true));
        
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
                System.out.println("Invalid name-it must not be blank");
                continue;}
            break;
            }
        return value;
        }
    

    private boolean doAction(int mySlope, int myDistance) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    boolean repeat=true;    
    double myHeight;
    WallControl myWallControl = new WallControl();
    
       myHeight= myWallControl.calcLaunchHeightArrow(mySlope, myDistance);
       System.out.println("height is:"+myHeight);
       if (myHeight<=5)System.out.println("choose again the slope and the distance to have an height >5");
    
    //while (myHeight<=5);
       else {System.out.println("the Wall is broken and Shrek enters into the town!"); 
             repeat=false;}
       return repeat;
             /*
    switch (choice){
            case 'N':
                this.startNewGame();
                break;
            case 'G':
                this.startExistingGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'E':
                return;
            default:
                System.out.println("Enter the value");
                break;              
       }
*/
    }
/*
    private void startNewGame() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        GameControl.createNewGame(Shrek.getPlayer());
        GameMenuView.gameMenu=new GameMenuView();
        gameMenu.displayMenu();
        
    }

    private void startExistingGame() {
        System.out.println("***Start Existing Game****");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void saveGame() {
        System.out.println("***Save Game************");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void displayHelpMenu() {
        HelpMenuView myHelp = new HelpMenuView();
        myHelp.displayMenu();
        
    }
  */    
 }
    
